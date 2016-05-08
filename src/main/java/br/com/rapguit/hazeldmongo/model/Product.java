package br.com.rapguit.hazeldmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by raphael on 07/05/16.
 */
@Document(collection = "products")
public class Product implements Serializable{

    @Id
    private String id;
    private String name;
    private double price;

    @Override
    public String toString() {
        return String.format("[id=%s, name=%s, price=%s]", id, name, price);
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
