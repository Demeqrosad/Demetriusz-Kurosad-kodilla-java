package com.kodilla.hibernate.invoice;

import javax.persistence.*;
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
        this.itemValue = getProductPrice().multiply(BigDecimal.valueOf(getProductQuantity()));
    }

    public void count()
    {
        setItemValue(getProductPrice().multiply(new BigDecimal(getProductQuantity())));
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
        return this.itemValue;
    }

    @ManyToOne
    @JoinColumn(name = "invoiceID")
    public Invoice getInvoice()
    {
        return invoice;
    }

    private void setItemID(int itemID)
    {
        this.itemID = itemID;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    private void setProductPrice(BigDecimal productPrice)
    {
        this.productPrice = productPrice;
    }

    private void setProductQuantity(int productQuantity)
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
