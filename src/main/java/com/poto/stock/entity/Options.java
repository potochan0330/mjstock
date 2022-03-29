package com.poto.stock.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="OPTIONS")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String code;

    @Column
    Integer type;

    @Column
    Double option_price;

    @Column
    Integer quantity;

    @Column
    Double strike_price;

    @Column
    Double maturity_year;

    @Column
    Timestamp created_time;

    public Options() {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getStrike_price() {
        return strike_price;
    }

    public void setStrike_price(Double strike_price) {
        this.strike_price = strike_price;
    }

    public Double getMaturity_year() {
        return maturity_year;
    }

    public void setMaturity_year(Double maturity_year) {
        this.maturity_year = maturity_year;
    }

    public Timestamp getCreate_time() {
        return created_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.created_time = create_time;
    }

    public Double getOption_price() {
        return option_price;
    }

    public void setOption_price(Double option_price) {
        this.option_price = option_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", option_price=" + option_price +
                ", quantity=" + quantity +
                ", strike_price=" + strike_price +
                ", maturity_year=" + maturity_year +
                ", create_time=" + created_time +
                '}';
    }

}
