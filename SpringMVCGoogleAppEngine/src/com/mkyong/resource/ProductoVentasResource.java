package com.mkyong.resource;

import com.mkyong.model.ProductoVenta;
import com.mkyong.resource.framework.ManageServiceListResource;

public class ProductoVentasResource extends ManageServiceListResource<ProductoVenta>{

	public ProductoVentasResource(){
		super(ProductoVenta.class, new ProductoVentaSerializer());
	}
}
