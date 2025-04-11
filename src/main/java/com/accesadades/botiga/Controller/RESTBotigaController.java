package com.accesadades.botiga.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/botiga")
public class RESTBotigaController {

    @Autowired
    private BotigaService botigaService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping("/")
    public String iniciar() {
        return "API BIBLIOTECA";
    }

    //api/botiga/inserirProducte
    @PostMapping("/api/botiga/inserirProductes")
    public String inserirProducte (@RequestBody ProductDTO productDTO) {
        botigaService.inserirProducte(productDTO);
        return "producte inserit";  
    }

    //api/botiga/LlistarProductes
    @GetMapping("/LlistarProductes")
    public String llistarProductes() {
        botigaService.llistarProductes();
        return "productes";
    }

    //api/botiga/CercaProductes?nom=...
    @GetMapping("/api/botiga/CercaProductes")
    public ResponseEntity<?> cercaProductes(@RequestParam(name = "nom", required = false) String productName) {
        try {
            Set<ProductDTO> productDTO = productService.findProductsByName(productName);
            return productDTO
                .map(product -> ResponseEntity.ok(product.toString()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No hi ha cap llibre amb aquesta id"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nom no vàlid");
        }
    }

    //api/botiga/ModificarPreu?id=...&nouPreu=...
    @PostMapping("/api/botiga/ModificarPreu")
    public String modificarPreu( @RequestParam(name = "id", required = true) Long id, @RequestParam(name = "nouPreu", required = true) Long nouPreu) {
        try {
            boolean updated = productService.updatePrice(id, nouPreu);
            if (updated) { return "Preu actualitzat correctament"; } 
            else { return "No s'ha trobat cap producte amb aquesta ID";}
        } catch (Exception e) {
            return "Error en actualitzar el preu: " + e.getMessage();
        }
    }

    //api/botiga/inserirCategoria
    @PostMapping("api/botiga/inserirCategoria")
    public String inserirCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.save(categoriaDTO);    
        return "categoria";  
    }

    //api/botiga/LlistarCategories
    @GetMapping("api/botiga/LlistarCategories")
    public String llistarCategories() {
        Set<CategoriaDTO> categoriaDTO = categoriaService.findAll();
        return categoriaDTO.toString();  
    }

    //api/botiga/inserirSubcategoria
    @PostMapping("api/botiga/inserirSubcategoria")
    public String inserirSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        subcategoriaService.save(subcategoriaDTO); 
        return "subcategoria inserida amb èxit";
    }

    //api/botiga/LlistarSubcategories
    @GetMapping("api/botiga/LlistarSubcategories")
    public String llistarSubcategories() {
        Set<SubcategoriesDTO> subcategoriaDTO = subcategoriaDTO.findAll();
        return subcategoriaDTO.toString();  
    }

    ///api/botiga/EliminarProducte?id=...
    @PostMapping("api/botiga/EliminarProducte")
    public String eliminarProducte(@RequestParam(name = "id", required = true) Long id) {
        try {
            boolean deleted = productService.delete(id);
            if (deleted) { return "Producte eliminat correctament"; } 
            else { return "No s'ha trobat cap producte amb aquesta ID"; }
        } catch (Exception e) { return "Error en eliminar el producte: " + e.getMessage(); }
    }

    ///api/botiga/LlistarProductesPerCategoria?idCategoria=...
    @GetMapping("api/botiga/LlistarProductesPerCategoria")
    public String llistarProductesPerCategoria(@RequestParam(name = "idCategoria", required = true) Long idCategoria) {
        try {
            Set<ProductDTO> producteDTO = productService.findAllProductsBySubcategory(idCategoria);
            return producteDTO.toString();  
        } catch (Exception e) { return "Error en llistar els productes per categoria: " + e.getMessage(); }
    }

    ///api/botiga/LlistarSubcategoriesPerCategoria?idCategoria=...
    @GetMapping("/api/botiga/LlistarSubcategoriesPerCategoria")
    public String llistarSubcategoriesPerCategoria(@RequestParam(name = "idCategoria", required = true) Long idCategoria) {
        try {
            Set<SubcategoriesDTO> subcategoriaDTO = subcategoriaService.findById(idCategoria);
            return subcategoriaDTO.toString();  
        } catch (Exception e) { return "Error en llistar les subcategories per categoria: " + e.getMessage(); }
    }

    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
}