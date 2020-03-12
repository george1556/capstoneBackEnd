package h2.studio.demo.images;

import h2.studio.demo.products.Product;
import h2.studio.demo.products.ProductService;
import h2.studio.demo.transactions.Transaction;
import h2.studio.demo.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/images")

public class ImageController {
    @Autowired
    private final ImageService imageService;

    @Autowired
    private final ProductService productService;

    public ImageController(ImageService imageService, ProductService productService) { this.imageService = imageService;
        this.productService = productService;
    }

    @GetMapping
    public List<Image> getAllImages(){ return this.imageService.getAllImages();}

    @GetMapping("/{id}")
    public Image getOneImage(@PathVariable int id){
        Image image = imageService.getOneImage(id).orElseThrow(IllegalArgumentException::new);


        return image;
    }


    @PostMapping
    public Image addnewImage(@RequestBody Image newImage){


        System.out.println("NewImage " + newImage.toString());
        return imageService.addNewImage(newImage);
    }



    @PostMapping("/{id}")
    public Image addNewImage(@RequestBody Image newImage, @PathVariable int id){
        Product product = productService.getOneProduct(id).orElseThrow(IllegalArgumentException::new);

        System.out.println("newImage before: " + newImage.toString());
        newImage.setProduct(product);
        System.out.println("newImage after: " + newImage.toString());
        return imageService.addNewImage(newImage);
    }














//    @PostMapping
//    public Image addnewImage(@RequestBody HashMap<String,String> reqBody){
//
//        Product currentProduct;
//        currentProduct
//       // public ProductService(ProductRepository productRepository) { this.productRepository = productRepository;}
//
//        productRepository.findById(reqBody.get("product_id"));
//
//        System.out.println("NewImage " + newImage.toString());
//        return imageService.addNewImage(newImage);
//    }







    @PatchMapping
    public Image updateImage(@RequestBody Image updatedImage){
        Image image = imageService.getOneImage(updatedImage.getId()).orElseThrow(IllegalArgumentException::new);
        return imageService.updateImage(updatedImage);
    }

    @DeleteMapping("/{id}")
    public String deleteImage(@PathVariable int id) {
        return imageService.deleteImage(id);
    }
}
