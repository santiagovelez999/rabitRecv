package com.rabitrecv.rabitrecv.connection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabitrecv.rabitrecv.domain.ProductosMapperBD;
import com.rabitrecv.rabitrecv.pojos.Productos;
import com.rabitrecv.rabitrecv.service.ProductosService;

@Component
public class ConecctionRecv {

	private final String QUEUE_NAME = "chat";
	
	@Autowired
	private ProductosService productosService;

	
	public void getMessage() throws Exception{
		 System.out.print("--------------------ENTRO-----------------");  
		 ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost("localhost");
	        Connection connection = factory.newConnection();
	        Channel channel = connection.createChannel();
	        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	            String message = new String(delivery.getBody(), "UTF-8");
	            ObjectMapper mapper = new ObjectMapper();
	            List<Productos> productosLista =  mapper.readValue(message, new TypeReference<List<Productos>>() {});
	            
	            if(!productosLista.isEmpty()) {
	            	productosLista.forEach(x -> {
		            	ProductosMapperBD nuevoProductoMaper = new ProductosMapperBD();
		            	nuevoProductoMaper.setNombreProducto(x.getNombreProducto());
		            	nuevoProductoMaper.setPrecioProducto(x.getPrecioProducto());
		            	productosService.saveDatos(nuevoProductoMaper);
		            });
		            System.out.print("DATOS EXTRAIDOS DE LA COLA FUERON ALMACENADOS EN BASE DE DATOS");  
	            }else {
	            	System.out.print("NO HAY DATOS"); 
	            }
	            
	        };
	        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
	}
}
