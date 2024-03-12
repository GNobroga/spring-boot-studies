package br.com.gabrielcardoso.websocktes;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


record  Product(String name, Double price) {

}

@Controller
@RequestMapping("/home")
public class TemplateController {
    
    @GetMapping
    public ModelAndView index() {
        var model = new ModelAndView("index");
        model.addObject("students", new HashMap<Integer, String>() {
            {
                put(1, "Gabriel 1");
                put(2, "Gabriel 2");
            }
        });
        model.addObject("student", new Product("", 1D));
        return model;
    }

    @PostMapping("/saveStudent")
    public ModelAndView saveStudent(Product product) {
        var model = new ModelAndView("index");
        model.addObject("student", product);
        return model;
    }

}
