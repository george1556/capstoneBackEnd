package h2.studio.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository;}

    public List<Product> getAllProducts() { return this.productRepository.findAll();}

    public Optional<Product> getOneProduct(int id) { return productRepository.findById(id); }

    public Product addNewProduct(Product newProduct){
        Product currentProduct = productRepository.save(newProduct);

        return currentProduct;
    }

    public Product updateProduct (Product updatedProduct){ return productRepository.save(updatedProduct);}

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "ID " + id + " was removed.";
    }


}
