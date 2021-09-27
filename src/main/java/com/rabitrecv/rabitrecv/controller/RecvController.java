package com.rabitrecv.rabitrecv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabitrecv.rabitrecv.connection.ConecctionRecv;


@RestController
@RequestMapping("/recv")
public class RecvController {

	@Autowired
	private ConecctionRecv conecctionRecv;
	
	@PostMapping
	public String save() {
		try {
			conecctionRecv.getMessage();
			return "Datos almacenados con exito";
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
	}
}
