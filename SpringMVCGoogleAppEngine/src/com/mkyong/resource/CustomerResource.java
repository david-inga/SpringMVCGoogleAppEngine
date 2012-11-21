package com.mkyong.resource;

import com.mkyong.model.Customer;
import com.mkyong.resource.framework.ManageServiceEntityResource;

public class CustomerResource extends ManageServiceEntityResource<Customer> {

	
		public CustomerResource(){
			
			super(Customer.class, new CustomerSerializer());
		}
	
}
