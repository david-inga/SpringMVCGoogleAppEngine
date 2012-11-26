package com.mkyong.resource;

import org.restlet.data.Form;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mkyong.model.BaseSerializer;
import com.mkyong.model.Producto;

public class ProductoSerializer extends BaseSerializer<Producto>{

	private static final String PRODUCTO_ELEMENT = "producto";
	public static final String CODE_ELEMENT = "codigo";
	private static final String TIPO_ELEMENT = "tipo";
	public static final String NOMBRE_ELEMENT = "nombre";
	private static final String PRECIO_ELEMENT = "precio";
	private static final String STOCK_ELEMENT = "stock";
	private static final String STOCK_OPTIMO_ELEMENT = "stockOptimo";
	private static final String GARANTIA_ELEMENT = "garantia";
	private static final String MARGEN_ELEMENT = "margen";
	public static final String LIST_ROOT_ELEMENT = "productos";

	private Producto entity;

	public ProductoSerializer(){
		
	}
	
	public ProductoSerializer(Producto entity){
			this.entity=entity;
	}
	
	@Override
	public void intializeProperties(Form form) {
		if (form.getFirstValue(CODE_ELEMENT) != null) {
			entity.setId(Long.parseLong(form.getFirstValue(CODE_ELEMENT)));
		}
		entity.setTipo(form.getFirstValue(TIPO_ELEMENT));
		entity.setNombre(form.getFirstValue(NOMBRE_ELEMENT));
		entity.setPrecio(Integer.parseInt(form.getFirstValue(PRECIO_ELEMENT)));
		entity.setStock(Integer.parseInt(form.getFirstValue(STOCK_ELEMENT)));
		entity.setStockOptimo(Integer.parseInt(form.getFirstValue(STOCK_OPTIMO_ELEMENT)));
		entity.setGarantia(Integer.parseInt(form.getFirstValue(GARANTIA_ELEMENT)));
		entity.setMargen(Integer.parseInt(form.getFirstValue(MARGEN_ELEMENT)));
		
	}
	
	@Override
	public Element toXml(Document document) {
		Element productoElement = document.createElement(PRODUCTO_ELEMENT);
		
		Element productoIdElement = document.createElement(CODE_ELEMENT);
		productoIdElement.appendChild(document.createTextNode(entity.getId()
				.toString()));
		productoElement.appendChild(productoIdElement);
		
		Element tipoElement = document.createElement(TIPO_ELEMENT);
		tipoElement.appendChild(document.createTextNode(entity.getTipo()));
		productoElement.appendChild(tipoElement);
		
		Element nombreElement = document.createElement(NOMBRE_ELEMENT);
		nombreElement.appendChild(document.createTextNode(entity.getNombre()));
		productoElement.appendChild(nombreElement);
		
		Element precioElement = document.createElement(PRECIO_ELEMENT);
		precioElement.appendChild(document.createTextNode(String
				.valueOf(entity.getPrecio())));
		productoElement.appendChild(precioElement);
		
		Element stockElement = document.createElement(STOCK_ELEMENT);
		stockElement.appendChild(document.createTextNode(String
				.valueOf(entity.getStock())));
		productoElement.appendChild(stockElement);
		
		Element stockOptimoElement = document.createElement(STOCK_OPTIMO_ELEMENT);
		stockOptimoElement.appendChild(document.createTextNode(String
				.valueOf(entity.getStockOptimo())));
		productoElement.appendChild(stockOptimoElement);
		
		Element garantiaElement = document.createElement(GARANTIA_ELEMENT);
		garantiaElement.appendChild(document.createTextNode(String
				.valueOf(entity.getGarantia())));
		productoElement.appendChild(garantiaElement);
		
		Element margenElement = document.createElement(MARGEN_ELEMENT);
		margenElement.appendChild(document.createTextNode(String
				.valueOf(entity.getMargen())));
		productoElement.appendChild(margenElement);
		
		return productoElement;
	}
	
	public Producto getEntity() {
		return entity;
	}

	public void setEntity(Producto entity) {
		this.entity = entity;
	}

	@Override
	public String getRootListElement() {
		return LIST_ROOT_ELEMENT;
	}

	@Override
	public void setId(Long id) {
		entity.setId(id);
	}

	@Override
	public String getCodeElement() {
		return CODE_ELEMENT;
	}
}
