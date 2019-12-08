package com.kodilla.hibernate.invoice;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product
{
    private int productID;
    private String productName;
    private List<Item> items = new ArrayList<>();

    public Product()
    {
    }

    public Product(String productName)
    {
        this.productName = productName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "productID")
    public int getProductID()
    {
        return this.productID;
    }

    @NotNull
    @Column(name = "productName", unique = true)
    public String getProductName()
    {
        return this.productName;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Item> getItems()
    {
        return this.items;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }
}
