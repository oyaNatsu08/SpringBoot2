package com.example.lesson.service;

import com.example.lesson.dao.PgProductDao;
import com.example.lesson.entity.ProductRecord;
import com.example.lesson.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PgProductService implements ProductService {

    @Autowired
    private PgProductDao pgProductDao;

    @Override
    public List<ProductRecord> findAll() {
        return pgProductDao.findAll();
    }

    @Override
    public ProductRecord findById(int id) {
        var product = pgProductDao.findById(id);

        if (product == null) {
            throw new ProductNotFoundException();
        }

        return product;
    }

    @Override
    public int insert(ProductRecord productRecord) {
        try {
            return pgProductDao.insert(productRecord);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(ProductRecord productRecord) {
        return pgProductDao.update(productRecord);
    }

    @Override
    public int delete(int id) {
        return pgProductDao.delete(id);
    }
}
