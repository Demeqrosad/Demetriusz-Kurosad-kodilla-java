package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDAOTestSuite
{
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private ProductDAO productDAO;

    @Test
    public void testInvoiceDAOSave()
    {
        //Given
        Product product1 = new Product("Product1");
        productDAO.save(product1);
        Product product2 = new Product("Product2");
        productDAO.save(product2);
        Product product3 = new Product("Product3");
        productDAO.save(product3);
        Invoice invoice = new Invoice("INV/2019/12/001");
        invoiceDAO.save(invoice);
        Item item1 = new Item(new BigDecimal("5.50"), 2);
        product1.getItems().add(item1);
        item1.setProduct(product1);
        invoice.getItems().add(item1);
        item1.setInvoice(invoice);
        Item item2 = new Item(new BigDecimal("6.25"), 4);
        product2.getItems().add(item2);
        item2.setProduct(product2);
        invoice.getItems().add(item2);
        item2.setInvoice(invoice);
        Item item3 = new Item(new BigDecimal("4.00"), 1);
        product3.getItems().add(item3);
        item3.setProduct(product3);
        invoice.getItems().add(item3);
        item3.setInvoice(invoice);
        Item item4 = new Item(new BigDecimal("5.75"), 6);
        product1.getItems().add(item4);
        item4.setProduct(product1);
        invoice.getItems().add(item4);
        item4.setInvoice(invoice);
        //When
        long actNumberOfItems = itemDAO.count();
        itemDAO.save(item1);
        itemDAO.save(item2);
        itemDAO.save(item3);
        itemDAO.save(item4);
        int actInvoiceID = invoice.getInvoiceID();
        actNumberOfItems = itemDAO.count() - actNumberOfItems;
        //Then
        Assert.assertNotEquals(0, actInvoiceID);
        Assert.assertEquals(4, actNumberOfItems);
        //CleanUp
        invoiceDAO.deleteById(invoice.getInvoiceID());
        productDAO.deleteById(product1.getProductID());
        productDAO.deleteById(product2.getProductID());
        productDAO.deleteById(product3.getProductID());
    }
}
