package com.rabitrecv.rabitrecv.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rabitrecv.rabitrecv.domain.ProductosMapperBD;


@Repository
public interface ProductosDao extends CrudRepository<ProductosMapperBD, Integer>{

}
