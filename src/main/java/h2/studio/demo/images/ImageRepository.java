package h2.studio.demo.images;

import h2.studio.demo.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
