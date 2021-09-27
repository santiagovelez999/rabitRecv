package com.rabitrecv.rabitrecv.pojos;

public class Productos {

private Integer idProducto;
	
	
	private String nombreProducto;
	
	
	private Integer precioProducto;

	
	/*public Productos(Integer idProducto, String nombreProducto, Integer precioProducto) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
	}*/

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Integer precioProducto) {
		this.precioProducto = precioProducto;
	}
}
