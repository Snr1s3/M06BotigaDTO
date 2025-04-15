package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Service.ProductService;

import java.util.Set;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/catalog")
    public String catalog(Model model) {
        Set<ProductDTO> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @RequestMapping(value = "/search")
    public String showSearchPage() {
        return "search";
    }

    @RequestMapping(value = "/prodname")
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null && !name.trim().isEmpty()) {
            ProductDTO product = productService.findProductsByName(name);
            if (product != null) {
                model.addAttribute("product", product);
            } else {
                model.addAttribute("notFound", true);
            }
        }
        return "search";
    }
}
