package com.controller;

import com.model.DocModel;
import com.model.FileInfo;
import com.model.Form;
import com.service.ReportService;
import com.service.XmlService;
import com.service.ZipService;
import com.xsd.XsdClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xml.sax.SAXException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController implements WebMvcConfigurer {
    @Autowired
    ZipService zipService;
    @Autowired
    XmlService xmlService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private final Map<String, ReportService> reportServiceMap = new HashMap<>();
    private final XsdClass xsdClass;

    public MainController() throws IOException {
        xsdClass = new XsdClass();
    }

    @GetMapping("/")
    public String firstView(Form form) {
        return "page";
    }

    @PostMapping("/")
    public String parseFile(@ModelAttribute("form") @Valid Form form, BindingResult bindingResult, Model model) throws Exception {
        if(form.getZipFile().isEmpty()) {
            bindingResult.addError(new FieldError("form", "zipFile", "Required field"));
        }

        if(bindingResult.hasErrors()) {
            return "page";
        }

        try {
            Map<String, FileInfo> map = zipService.convert(form.getZipFile(), bindingResult);
            List<DocModel> docModels  = reportServiceMap.get(form.getName()).createReport(map);
            String result = validation(map);
            validationInProgram(map);
            createResponse(docModels);
            model.addAttribute("result", result);

            return "page";
        } catch(Exception e){
                String result = e.getMessage();
                model.addAttribute("result", result);

                return "page";
            }
        }

    private void createResponse(List<DocModel> docModels) {
        restTemplate.postForObject("http://localhost:9090/report", docModels, String.class);
    }

    private String validation(Map<String, FileInfo> map) throws IOException {
        StringBuilder finalString = new StringBuilder();

        for(Map.Entry<String, FileInfo> entry : map.entrySet()) {
            finalString.append(xmlService.getValidationErrors(entry.getKey(),
                    entry.getValue().getTextContent(),
                    xsdClass.xsd(entry.getValue().getRootElement())));
        }

        return finalString.toString();
    }

    private void validationInProgram(Map<String, FileInfo> map) throws IOException {
        Logger log = LoggerFactory.getLogger(MainController.class);

        for(Map.Entry<String, FileInfo> entry : map.entrySet()) {
            log.info("validation : " + xmlService.validation(xsdClass.xsd(entry.getValue().getRootElement()),
                    entry.getValue().getTextContent()));
            log.info("errors : " + xmlService.validationErrors(entry.getValue().getTextContent(),
                    xsdClass.xsd(entry.getValue().getRootElement())));
            List list = new ArrayList<SAXException>();
            log.info("validationWithErrors : " + xmlService.validation(xsdClass.xsd(entry.getValue().getRootElement()),
                    entry.getValue().getTextContent(), list));
        }
    }
}
