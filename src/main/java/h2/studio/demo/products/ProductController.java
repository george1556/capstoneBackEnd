package h2.studio.demo.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping
    public List<Product> getAllProducts(){ return this.productService.getAllProducts();}

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable int id){
        Product product = productService.getOneProduct(id).orElseThrow(IllegalArgumentException::new);

        return product;

    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product newProduct){
        return productService.addNewProduct(newProduct);
    }

    @PatchMapping
    public Product updateProduct(@RequestBody Product updatedProduct){
        Product product = productService.getOneProduct(updatedProduct.getId()).orElseThrow(IllegalArgumentException::new);

        return productService.updateProduct(updatedProduct);
    }

    @DeleteMapping("/{id}")
        public String deleteProduct(@PathVariable int id){
            return productService.deleteProduct(id);
        }

}
