package com.mkyong.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.Form;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.googlecode.objectify.Key;
import com.mkyong.dao.ManageServiceDAO;
import com.mkyong.model.BaseSerializer;
import com.mkyong.model.Customer;
import com.mkyong.model.Producto;
import com.mkyong.model.ProductoVenta;

public class ProductoVentaSerializer extends BaseSerializer<ProductoVenta>{

	
	public static final Logger LOG = Logger
			.getLogger(ProductoVentaSerializer.class.getName());
	
	
	public static final String CODE_ELEMENT = "codigo";
	private static final String LIST_ROOT_ELEMENT = "ventas";
	private static final String CUSTOMER_ID_ELEMENT = "codigoCustomer";
	private static final String PRODUCTO_ID_ELEMENT = "codigoProducto";

	// YYYY-MM-DDThh:mmTZD (eg 1997-07-16T19:20+01:00)
	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'-05:00'";
	private static final String DATE_ELEMENT = "fechaHora";

	private static final String VENTA_ELEMENT = "venta";
	
	private ProductoVenta entity;

	private SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
	
	@Override
	public ProductoVenta getEntity() {
		return entity;
	}

	@Override
	public String getRootListElement() {
		return LIST_ROOT_ELEMENT;
	}
	
	@Override
	public void intializeProperties(Form form) {
		
		if (form.getFirstValue(CODE_ELEMENT) != null) {
			entity.setId(Long.parseLong(form.getFirstValue(CODE_ELEMENT)));
		}
		entity.setCustomer(new Key<Customer>(Customer.class, Long.parseLong(form
				.getFirstValue(CUSTOMER_ID_ELEMENT))));
		entity.setProducto(new Key<Producto>(Producto.class, Long.parseLong(form
				.getFirstValue(PRODUCTO_ID_ELEMENT))));
		try {
			entity.setDate(formatter.parse(form.getFirstValue(DATE_ELEMENT)));
		} catch (ParseException e) {
			LOG.log(Level.SEVERE, "Error parsing", e);
			entity.setDate(null);
		}
		
	}
	
	public Element toXml(Document document) {
		Element reservationElement = document
				.createElement(VENTA_ELEMENT);
		
		Element codeElement = document.createElement(CODE_ELEMENT);
		codeElement.appendChild(document.createTextNode(entity.getId()
				.toString()));
		reservationElement.appendChild(codeElement);
		
		Customer customer = new ManageServiceDAO<Customer>(Customer.class)
				.get(entity.getCustomer());
		Producto producto = new ManageServiceDAO<Producto>(Producto.class)
				.get(entity.getProducto());
		reservationElement.appendChild(new CustomerSerializer(customer).toXml(document));
		reservationElement.appendChild(new ProductoSerializer(producto).toXml(document));
		
		Element dateElement = document.createElement(DATE_ELEMENT);
		dateElement.appendChild(document
				.createTextNode(entity.getDate() != null ? formatter
						.format(entity.getDate()) : ""));
		reservationElement.appendChild(dateElement);
		
		return reservationElement;
	}
	
	@Override
	public void setEntity(ProductoVenta entity) {
		this.entity = entity;
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
