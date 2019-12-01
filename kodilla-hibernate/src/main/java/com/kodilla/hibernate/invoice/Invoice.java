package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Invoices")
public class Invoice
{
    private int invoiceID;
    private String invoiceNumber;
    private List<Item> items = new ArrayList<>();

    public Invoice()
    {
    }

    public Invoice(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "invoiceID")
    public int getInvoiceID()
    {
        return this.invoiceID;
    }

    @NotNull
    @Column(name = "invoiceNumber")
    public String getInvoiceNumber()
    {
        return this.invoiceNumber;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Item> getItems()
    {
        return this.items;
    }

    private void setInvoiceID(int invoiceID)
    {
        this.invoiceID = invoiceID;
    }

    private void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }

    private void setItems(List<Item> items)
    {
        this.items = items;
    }
}
