package h2.studio.demo.images;

import h2.studio.demo.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findImagesByProductIdEquals(String prodId);

}
