package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Service.ProductService;

import java.util.Set;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        Set<ProductDTO> products = productService.findAll();
        model.addAttribute("products", products);
        return "catalog";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "search";
    }
}
