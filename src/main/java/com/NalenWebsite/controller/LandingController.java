package com.NalenWebsite.controller;

import com.NalenWebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class LandingController {
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String index(@RequestParam(required = false) String productName, Model model) {
        var products = productService.getAllProducts(productName);
        model.addAttribute("products", products);
        return "home.html";
    }
}
