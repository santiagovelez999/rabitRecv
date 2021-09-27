package com.rabitrecv.rabitrecv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabitrecv.rabitrecv.dao.ProductosDao;
import com.rabitrecv.rabitrecv.domain.ProductosMapperBD;

@Service
public class ProductosService {

	@Autowired
	private ProductosDao productosDao;
	
	public void saveDatos(ProductosMapperBD productosMapperBD) {
		productosDao.save(productosMapperBD);
	}
}
