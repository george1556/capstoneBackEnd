package h2.studio.demo.images;

import h2.studio.demo.products.Product;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "images")
@Data

public class Image {
    public Image(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String addressField;

    @ManyToOne
    @JoinColumn
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressField() {
        return addressField;
    }

    public void setAddressField(String addressField) {
        this.addressField = addressField;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
