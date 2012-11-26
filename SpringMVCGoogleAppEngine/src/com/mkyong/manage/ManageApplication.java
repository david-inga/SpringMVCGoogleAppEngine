package com.mkyong.manage;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.mkyong.resource.CustomerResource;
import com.mkyong.resource.CustomerSerializer;
import com.mkyong.resource.CustomersResource;
import com.mkyong.resource.ProductoResource;
import com.mkyong.resource.ProductoSerializer;
import com.mkyong.resource.ProductoVentaResource;
import com.mkyong.resource.ProductoVentaSerializer;
import com.mkyong.resource.ProductoVentasResource;
import com.mkyong.resource.ProductosResource;

public class ManageApplication extends Application {

	
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		router.attach("/productos", ProductosResource.class);
		router.attach("/productos/{" + ProductoSerializer.CODE_ELEMENT + "}",
				ProductoResource.class);
		
		router.attach("/students", CustomersResource.class);
		router.attach("/students/{" + CustomerSerializer.CODE_ELEMENT + "}",
				CustomerResource.class);
		
		router.attach("/reservations", ProductoVentasResource.class);
		router.attach("/reservations/{"
				+ ProductoVentaSerializer.CODE_ELEMENT + "}",
				ProductoVentaResource.class);
		
		return router;
	}
	
}
