package h2.studio.demo.images;

import h2.studio.demo.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
//    List<Image> findImageByAddressFieldEquals(String number);

    List<Image> findImagesByProductIdEquals(String prodId);

//    List<Image> findImagesByProduct_idEquals(String prod_id);
//    List<Image> findImagesByProduct_id(String prod_id);

    //    List<Image> findImagesByProduct_idEquals(int id);
//    default List<Image> findImagesByProduct_id(int id) {
//        return null;
//    }

}
