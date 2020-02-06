package h2.studio.demo.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) { this.imageRepository = imageRepository;}

    public List<Image> getAllImages() { return this.imageRepository.findAll();}

    public Optional<Image> getOneImage(int id) { return imageRepository.findById(id);}

    public Image addNewImage(Image newImage){
        Image currentImage = imageRepository.save(newImage);

        return currentImage;
    }

    public Image updateImage (Image updatedImage){ return imageRepository.save(updatedImage);}

    public String deleteImage(int id){
        imageRepository.deleteById(id);
        return "ID " + id + " was removed.";
    }


}
