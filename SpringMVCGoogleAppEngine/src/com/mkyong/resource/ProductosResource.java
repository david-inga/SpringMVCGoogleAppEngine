package com.mkyong.resource;

import com.mkyong.model.Producto;
import com.mkyong.resource.framework.ManageServiceListResource;

public class ProductosResource extends ManageServiceListResource<Producto>{
	
	public ProductosResource() {
		super(Producto.class, new ProductoSerializer());
	}

}
