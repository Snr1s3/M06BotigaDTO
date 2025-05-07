package com.accesadades.botiga.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Service.CategoriaService;
import com.accesadades.botiga.Service.ProductService;
import com.accesadades.botiga.Service.SubcategoriaService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/botiga")
public class RESTBotigaController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SubcategoriaService subcategoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping("/")
    public String iniciar() {
        return "API BOTIGA";
    }

    // api/botiga/inserirProducte
    @PostMapping("/api/botiga/inserirProductes")
    public ResponseEntity<String> inserirProducte(@RequestBody ProductDTO productDTO) {
        try {
            if (productDTO.getName() == null || productDTO.getName().isEmpty()) {
                return ResponseEntity.badRequest().body("Error: El nom del producte és obligatori");
            }
            if (productDTO.getPrice() <= 0) {
                return ResponseEntity.badRequest().body("Error: El preu ha de ser superior a 0");
            }
            ProductDTO saved = productService.save(productDTO);
            if (saved != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Producte inserit amb èxit");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("No s'ha pogut inserir el producte per un error desconegut");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en inserir el producte: " + e.getMessage());
        }
    }

    // api/botiga/LlistarProductes
    @GetMapping("api/botiga/LlistarProductes")
    public ResponseEntity<?> llistarProductes() {
        try {
            Set<ProductDTO> productes = productService.findAll();
            if (productes != null && !productes.isEmpty()) {
                return ResponseEntity.ok(productes);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha productes disponibles");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en obtenir els productes: " + e.getMessage());
        }
    }

    // api/botiga/CercaProductes?nom=...
    @GetMapping("/api/botiga/CercaProductes")
    public ResponseEntity<?> cercaProductes(@RequestParam(name = "nom", required = false) String productName) {
        try {
            if (productName == null || productName.trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Error: Cal proporcionar un nom de producte per a la cerca");
            }
            Set<ProductDTO> products = productService.findProductsByName(productName);
            if (products != null && !products.isEmpty()) {
                return ResponseEntity.ok(products);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha cap producte que contingui '" + productName + "' al seu nom");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en cercar productes: " + e.getMessage());
        }
    }

    // api/botiga/ModificarPreu?id=...&nouPreu=...
    @PostMapping("/api/botiga/ModificarPreu")
    public ResponseEntity<String> modificarPreu(@RequestParam(name = "id", required = true) Long id,
            @RequestParam(name = "nouPreu", required = true) Long nouPreu) {
        try {
            if (nouPreu <= 0) {
                return ResponseEntity.badRequest().body("Error: El preu ha de ser superior a 0");
            }
            boolean updated = productService.updatePrice(id, nouPreu);
            if (updated) {
                return ResponseEntity.ok("Preu actualitzat correctament");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No s'ha trobat cap producte amb aquesta ID");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en actualitzar el preu: " + e.getMessage());
        }
    }

    // api/botiga/inserirCategoria
    @PostMapping("api/botiga/inserirCategoria")
    public ResponseEntity<String> inserirCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        try {
            if (categoriaDTO.getStatus() == null || categoriaDTO.getStatus().isEmpty()) {
                return ResponseEntity.badRequest().body("Error: L'estat de la categoria és obligatori");
            }

            CategoriaDTO saved = categoriaService.save(categoriaDTO);

            if (saved != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Categoria inserida amb èxit");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("No s'ha pogut inserir la categoria per un error desconegut");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en inserir la categoria: " + e.getMessage());
        }
    }

    // api/botiga/LlistarCategories
    @GetMapping("api/botiga/LlistarCategories")
    public ResponseEntity<?> llistarCategories() {
        try {
            Set<CategoriaDTO> categories = categoriaService.findAll();
            if (categories != null && !categories.isEmpty()) {
                return ResponseEntity.ok(categories);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha categories disponibles");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en obtenir les categories: " + e.getMessage());
        }
    }

    // api/botiga/inserirSubcategoria
    @PostMapping("api/botiga/inserirSubcategoria")
    public ResponseEntity<String> inserirSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        try {
            if (subcategoriaDTO.getCategoria() == null || subcategoriaDTO.getCategoria().getNombre() == null) {
                return ResponseEntity.badRequest().body("Error: Cal assignar la subcategoria a una categoria.");
            }
            SubcategoriaDTO saved = subcategoriaService.save(subcategoriaDTO);
    
            if (saved != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Subcategoria inserida amb èxit");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("No s'ha pogut inserir la subcategoria per un error desconegut");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en inserir la subcategoria: " + e.getMessage());
        }
    }
    

    // api/botiga/LlistarSubcategories
    @GetMapping("api/botiga/LlistarSubcategories")
    public ResponseEntity<?> llistarSubcategories() {
        try {
            Set<SubcategoriaDTO> subcategories = subcategoriaService.findAll();
            if (subcategories != null && !subcategories.isEmpty()) {
                return ResponseEntity.ok(subcategories);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha subcategories disponibles");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en obtenir les subcategories: " + e.getMessage());
        }
    }

    // api/botiga/EliminarProducte?id=...
    @PostMapping("api/botiga/EliminarProducte")
    public ResponseEntity<String> eliminarProducte(@RequestParam(name = "id", required = true) Long id) {
        try {
            boolean deleted = productService.delete(id);
            if (deleted) {
                return ResponseEntity.ok("Producte eliminat correctament");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No s'ha trobat cap producte amb aquesta ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en eliminar el producte: " + e.getMessage());
        }
    }

    // api/botiga/LlistarProductesPerCategoria?nombreCategoria=...
    @GetMapping("api/botiga/LlistarProductesPerCategoria")
    public ResponseEntity<?> llistarProductesPerCategoria(@RequestParam(name = "nomCategoria", required = true) String nomCategoria) {
        try {
            Set<ProductDTO> productes = productService.findAllByCategoriaNom(nomCategoria);
            if (productes != null && !productes.isEmpty()) {
                return ResponseEntity.ok(productes);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha productes disponibles per la categoria amb nom: " + nomCategoria);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en llistar els productes per categoria: " + e.getMessage());
        }
    }
    

    // api/botiga/LlistarSubcategoriesPerCategoria?idCategoria=...
    @GetMapping("/api/botiga/LlistarSubcategoriesPerCategoria")
    public ResponseEntity<?> llistarSubcategoriesPerCategoria(@RequestParam(name = "idCategoria", required = true) Long idCategoria) {
        try {
            Set<SubcategoriaDTO> subcategories = subcategoriaService.findAllByCategoriaId(idCategoria);
            if (subcategories != null && !subcategories.isEmpty()) {
                return ResponseEntity.ok(subcategories);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha subcategories disponibles per la categoria amb ID: " + idCategoria);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en llistar les subcategories per categoria: " + e.getMessage());
        }
    }

    @PostMapping("/api/botiga/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
}
