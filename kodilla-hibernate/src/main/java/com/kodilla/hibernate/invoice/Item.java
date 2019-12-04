package com.kodilla.hibernate.invoice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "Items")
public class Item
{
    private int itemID;
    private Product product;
    private BigDecimal productPrice;
    private int productQuantity;
    private BigDecimal itemValue;
    private Invoice invoice;

    public Item()
    {
    }

    public Item(BigDecimal productPrice, int productQuantity)
    {
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "itemID")
    public int getItemID()
    {
        return this.itemID;
    }

    @ManyToOne
    @JoinColumn(name = "productID")
    public Product getProduct()
    {
        return this.product;
    }

    @Column(name = "productPrice")
    public BigDecimal getProductPrice()
    {
        return this.productPrice;
    }

    @Column(name = "productQuantity")
    public int getProductQuantity()
    {
        return this.productQuantity;
    }

    @Column(name = "itemValue")
    public BigDecimal getItemValue()
    {
        return getProductPrice().multiply(BigDecimal.valueOf(getProductQuantity()));
    }

    @ManyToOne
    @JoinColumn(name = "invoiceID")
    public Invoice getInvoice()
    {
        return invoice;
    }

    public void setItemID(int itemID)
    {
        this.itemID = itemID;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public void setProductPrice(BigDecimal productPrice)
    {
        this.productPrice = productPrice;
    }

    public void setProductQuantity(int productQuantity)
    {
        this.productQuantity = productQuantity;
    }

    private void setItemValue(BigDecimal itemValue)
    {
        this.itemValue = itemValue;
    }

    public void setInvoice(Invoice invoice)
    {
        this.invoice = invoice;
    }
}
