package com.mkyong.manage;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.mkyong.resource.CustomerResource;
import com.mkyong.resource.CustomerSerializer;
import com.mkyong.resource.CustomersResource;

public class ManageApplication extends Application {

	
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		router.attach("/students", CustomersResource.class);
		router.attach("/students/{" + CustomerSerializer.CODE_ELEMENT + "}",
				CustomerResource.class);
		
		return router;
	}
	
}
