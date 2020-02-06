package h2.studio.demo.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/images")

public class ImageController {
    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) { this.imageService = imageService;}

    @GetMapping
    public List<Image> getAllImages(){ return this.imageService.getAllImages();}

    @GetMapping("/{id}")
    public Image getOneImage(@PathVariable int id){
        Image image = imageService.getOneImage(id).orElseThrow(IllegalArgumentException::new);

        return image;
    }

    @PostMapping
    public Image addnewImage(@RequestBody Image newImage){
        return imageService.addNewImage(newImage);
    }

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
