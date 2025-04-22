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
        Set<ProductDTO> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "search"; // carrega el formulari de cerca
    }

    @PostMapping("/prodname")
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null && !name.trim().isEmpty()) {
            ProductDTO product = productService.findProductsByName(name);
            if (product != null) {
                model.addAttribute("product", product);
            } else {
                model.addAttribute("notFound", true); // per mostrar un missatge d’error si no trobat
            }
        }
        return "search";
    }
}
