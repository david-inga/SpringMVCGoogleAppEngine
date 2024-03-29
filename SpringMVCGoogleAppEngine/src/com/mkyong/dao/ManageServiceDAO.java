package com.mkyong.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.QueryResultIterable;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.util.DAOBase;
import com.mkyong.model.Customer;
import com.mkyong.model.Producto;
import com.mkyong.model.ProductoVenta;



public class ManageServiceDAO<T> extends DAOBase {
	
	public static final Logger LOG = Logger.getLogger(ManageServiceDAO.class
			.getName());

	static {
		
		ObjectifyService.register(Customer.class);
		ObjectifyService.register(Producto.class);
		ObjectifyService.register(ProductoVenta.class);
		
	}
	
	protected Class<T> clazz;

	public ManageServiceDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Key<T> add(T book) {
		Key<T> key = ofy().put(book);
		return key;
	}

	public void delete(Key<T> key) {
		ofy().delete(key);
	}

	public T get(Long id) throws NotFoundException {
		return ofy().get(clazz, id);
	}

	public T get(Key<T> key) {
		return ofy().get(key);
	}

	public List<T> listByProperty(String propertyName, String propertyValue) {
		Query<T> query = ofy().query(clazz);
		if (propertyName != null && propertyValue != null) {
			query.filter(propertyName, propertyValue);

		}
		return asList(query.fetch());
	}

	private List<T> asList(QueryResultIterable<T> fetch) {
		ArrayList<T> list = new ArrayList<T>();
		for (T t : fetch) {
			list.add(t);
		}
		return list;

	}
	

	
	
}
