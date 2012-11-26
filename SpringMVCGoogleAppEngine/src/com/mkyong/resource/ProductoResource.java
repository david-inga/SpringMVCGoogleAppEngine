package com.mkyong.resource;

import com.mkyong.model.Producto;
import com.mkyong.resource.framework.ManageServiceEntityResource;

public class ProductoResource extends ManageServiceEntityResource<Producto>{
	
	public ProductoResource(){
		
		super(Producto.class, new ProductoSerializer());
	}

}
