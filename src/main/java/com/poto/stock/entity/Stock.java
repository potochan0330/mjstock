package com.poto.stock.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String code;

    @Column
    String name;

    @Column
    Double start_price;

    @Column
    Double latest_price;

    @Column
    Integer quantity;

    @Column
    Double expected_return;

    @Column
    Double annual_sd;

    @Column
    Timestamp create_time;

    public Stock() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStart_price() {
        return start_price;
    }

    public void setStart_price(Double start_price) {
        this.start_price = start_price;
    }

    public Double getLatest_price() {
        return latest_price;
    }

    public void setLatest_price(Double latest_price) {
        this.latest_price = latest_price;
    }

    public Double getExpected_return() {
        return expected_return;
    }

    public void setExpected_return(Double expected_return) {
        this.expected_return = expected_return;
    }

    public Double getAnnual_sd() {
        return annual_sd;
    }

    public void setAnnual_sd(Double annual_sd) {
        this.annual_sd = annual_sd;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", start_price=" + start_price +
                ", latest_price=" + latest_price +
                ", quantity=" + quantity +
                ", expected_return=" + expected_return +
                ", annual_sd=" + annual_sd +
                ", create_time=" + create_time +
                '}';
    }
}
