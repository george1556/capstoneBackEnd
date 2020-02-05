package h2.studio.demo.products;



import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "products")
@Data

public class Product {
    public Product(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private Double price;

    @Column(columnDefinition="TEXT")
    private String summary;

    @Column(columnDefinition="TEXT")
    private String description1;

    @Column(columnDefinition="TEXT")
    private String description2;

    @Column(columnDefinition="TEXT")
    private String description3;

    @Column(columnDefinition="TEXT")
    private String description4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }
}
