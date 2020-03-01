package h2.studio.demo.products;


import h2.studio.demo.images.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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





//    @PostMapping
//    public Product addNewProduct(@RequestBody Product newProduct){
//
//
//        System.out.println("newProduct: " + newProduct.toString());
//
//
//        Image image = null;
//        List<Image> listImages = new ArrayList<Image>();
//
//        Product product = new Product();
//        product.setTitle(newProduct.getTitle());
//        product.setPrice(newProduct.getPrice());
//        product.setSummary(newProduct.getSummary());
//        product.setDescription1(newProduct.getDescription1());
//        product.setDescription2(newProduct.getDescription2());
//        product.setDescription3(newProduct.getDescription3());
//        product.setDescription4(newProduct.getDescription4());
//
//        if (newProduct.getProductImages().size() > 0){
//            for (int i = 0; i < newProduct.getProductImages().size(); i++) {
//
//                image = new Image();
//                image.setAddressField(newProduct.getProductImages().get(i).getAddressField());
//                image.setProduct(product);
//
//                listImages.add(image);
//            }
//        }
//
//        System.out.println("listImages: " + listImages.toString());
//
//
//        System.out.println("product: " + product.toString());
//
//        product.setProductImages(listImages);
//        System.out.println("product after setproductimages: " + product.toString());
//
//
//        System.out.println("productService.AddNewProduct(product): " + productService.addNewProduct(product));
//        //Delete this after testing
//    return productService.addNewProduct(product);
//    }

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
