package h2.studio.demo.transactions;

import h2.studio.demo.products.Product;
import h2.studio.demo.users.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data

public class Transaction {
    public Transaction(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }





    @Column
    private int orderNumber;

    @Column
    private String email;

    //Many products per transaction
    @ManyToOne
    private Product product;

    @Column
    private double productPrice;

    @Column
    private int productQuantity;

    @Column
    private double cartTotal;

    @Column
    private String customerIpAddress;

    @Column
    private String stripeTokenId;

    @Column
    private String stripeCardId;

    @Column
    private String stripeCardZip;

    @Column
    private String stripeCardBrand;

    @Column
    private String stripeCardExpMonth;

    @Column
    private String stripeCardExpYear;

    @Column
    private String stripeCardLast4;

    @Column
    private String stripeCardName;

    @Column
    private String billingFirstName;

    @Column
    private String billingLastName;

    @Column
    private String billingAddress;

    @Column
    private String billingAddress2;

    @Column
    private String billingCity;

    @Column
    private String billingState;

    @Column
    private String billingZipCode;

    @Column
    private String shippingFirstName;

    @Column
    private String shippingLastName;

    @Column
    private String shippingAddress;

    @Column
    private String shippingAddress2;

    @Column
    private String shippingCity;

    @Column
    private String shippingState;

    @Column
    private String shippingZipCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public String getStripeTokenId() {
        return stripeTokenId;
    }

    public void setStripeTokenId(String stripeTokenId) {
        this.stripeTokenId = stripeTokenId;
    }

    public String getStripeCardId() {
        return stripeCardId;
    }

    public void setStripeCardId(String stripeCardId) {
        this.stripeCardId = stripeCardId;
    }

    public String getStripeCardZip() {
        return stripeCardZip;
    }

    public void setStripeCardZip(String stripeCardZip) {
        this.stripeCardZip = stripeCardZip;
    }

    public String getStripeCardBrand() {
        return stripeCardBrand;
    }

    public void setStripeCardBrand(String stripeCardBrand) {
        this.stripeCardBrand = stripeCardBrand;
    }

    public String getStripeCardExpMonth() {
        return stripeCardExpMonth;
    }

    public void setStripeCardExpMonth(String stripeCardExpMonth) {
        this.stripeCardExpMonth = stripeCardExpMonth;
    }

    public String getStripeCardExpYear() {
        return stripeCardExpYear;
    }

    public void setStripeCardExpYear(String stripeCardExpYear) {
        this.stripeCardExpYear = stripeCardExpYear;
    }

    public String getStripeCardLast4() {
        return stripeCardLast4;
    }

    public void setStripeCardLast4(String stripeCardLast4) {
        this.stripeCardLast4 = stripeCardLast4;
    }

    public String getStripeCardName() {
        return stripeCardName;
    }

    public void setStripeCardName(String stripeCardName) {
        this.stripeCardName = stripeCardName;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(String billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public String getShippingFirstName() {
        return shippingFirstName;
    }

    public void setShippingFirstName(String shippingFirstName) {
        this.shippingFirstName = shippingFirstName;
    }

    public String getShippingLastName() {
        return shippingLastName;
    }

    public void setShippingLastName(String shippingLastName) {
        this.shippingLastName = shippingLastName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingZipCode() {
        return shippingZipCode;
    }

    public void setShippingZipCode(String shippingZipCode) {
        this.shippingZipCode = shippingZipCode;
    }

}
