package com.poto.stock.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String product_code;

    @Column
    String customer_id;

    @Column
    String product_type;

    @Column
    Double price;

    @Column
    Integer quantity;

    public Transaction() {
    }

    public Transaction(Integer id, String product_code, String customer_id, String product_type, Double price, Integer quantity) {
        this.id = id;
        this.product_code = product_code;
        this.customer_id = customer_id;
        this.product_type = product_type;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", product_code='" + product_code + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", product_type='" + product_type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
