package com.mkyong.resource;

import com.mkyong.model.Customer;
import com.mkyong.resource.framework.ManageServiceListResource;

public class CustomersResource extends ManageServiceListResource<Customer> {

	public CustomersResource() {
		super(Customer.class, new CustomerSerializer());
	}

}
