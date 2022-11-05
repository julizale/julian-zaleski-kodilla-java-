package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Item item1 = new Item(product1, BigDecimal.valueOf(99.99), 8);
        Item item2 = new Item(product2, BigDecimal.valueOf(49.99), 3);
        Invoice invoice1 = new Invoice("FV 01/11/2022");
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();

        //Then
        assertNotEquals(0, invoice1Id);

        //CleanUp
        invoiceDao.deleteById(invoice1Id);
    }
}
