package com.controller;

import com.model.DocModel;
import com.model.Form;
import com.service.ReportService;
import com.service.ZipService;
import com.service.impl.ReportServiceJaxbImpl;
import com.service.impl.ReportServiceW3cImpl;
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
import org.yaml.snakeyaml.representer.BaseRepresenter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController implements WebMvcConfigurer {
    @Autowired
    ZipService zipService;
    @Autowired
    private Map<String, ReportService> reportServiceMap = new HashMap<>();

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
            List<DocModel> docModels = null;
            Map<String, String> map = zipService.convert(form.getZipFile(), bindingResult);
            docModels = reportServiceMap.get(form.getName()).createReport(map);

            createResponse(docModels);

            String result = "File is parsed!";
            model.addAttribute("result", result);

            return "page";
        } catch(Exception e){
                String result = e.getMessage();
                model.addAttribute("result", result);

                return "page";
            }
        }

    private void createResponse(List<DocModel> docModels) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject("http://localhost:9090/report", docModels, String.class);
    }


}
