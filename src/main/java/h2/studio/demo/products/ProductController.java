package h2.studio.demo.products;


import h2.studio.demo.images.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private final ProductService productService;

    private final EntityManager em;

    public ProductController(ProductService productService, EntityManager em) { this.productService = productService; this.em = em; }

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
    @Transactional
        public String deleteProduct(@PathVariable int id){

        //Product product = productService.getOneProduct(id).orElseThrow(IllegalArgumentException::new);

        Query q1 = em.createNativeQuery("delete from images where product_id = ?");
        q1.setParameter(1, id);
        em.joinTransaction();
        q1.executeUpdate();


        return productService.deleteProduct(id);
        }

}
