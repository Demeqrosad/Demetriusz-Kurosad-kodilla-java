package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer>
{
}
