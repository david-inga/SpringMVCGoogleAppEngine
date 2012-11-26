package com.mkyong.resource;

import com.mkyong.model.ProductoVenta;
import com.mkyong.resource.framework.ManageServiceEntityResource;

public class ProductoVentaResource extends ManageServiceEntityResource<ProductoVenta>{

	public ProductoVentaResource(){
		super(ProductoVenta.class, new ProductoVentaSerializer());
	}
}
