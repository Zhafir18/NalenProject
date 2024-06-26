package com.NalenWebsite.controller;

import com.NalenWebsite.dto.Product.UpsertProductDTO;
import com.NalenWebsite.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String index(@RequestParam(required = false) String productName, Model model) {
        var product = productService.getAllProducts(productName);
        model.addAttribute("product", product);
        return "product/index";
    }

    @PostMapping("/upsert")
    public String upsertProduct(@Valid @ModelAttribute("dto") UpsertProductDTO dto, BindingResult bindingResult, Model model) {
        return "1";
    }
}
