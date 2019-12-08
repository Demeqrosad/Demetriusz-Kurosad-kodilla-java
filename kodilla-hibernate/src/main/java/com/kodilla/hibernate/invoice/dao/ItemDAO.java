package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@Repository
public interface ItemDAO extends CrudRepository<Item, Integer>
{
    //@Query(nativeQuery = true)
    //public BigDecimal retrieveItemValueByItemID(@Param("ITEM_ID") int ItemID);
}
