package com.mkyong.dao;

import com.googlecode.objectify.util.DAOBase;


//@Controller
//@RequestMapping("/customer")
public class ManageServiceDAO<T> extends DAOBase {
	
	/*public static final Logger LOG = Logger.getLogger(ManageServiceDAO.class
			.getName());

	static {
		
		ObjectifyService.register(Customer.class);
	}
	
	
	@RequestMapping(value="/addCustomerPage", method = RequestMethod.GET)
	public String getAddCustomerPage(ModelMap model) {

		return "add";
	}
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, ModelMap model) {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
	    Key customerKey = KeyFactory.createKey("Customer", name);
	        
		Date date = new Date();
        Entity customer = new Entity("Customer", customerKey);
        customer.setProperty("name", name);
        customer.setProperty("email", email);
        customer.setProperty("date", date);

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(customer);
        
        return new ModelAndView("redirect:list");
        
	}
		

	
	//get all customers
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listCustomer(ModelMap model) {

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Customer").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> customers = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
	    
	    model.addAttribute("customerList",  customers);
	    
		return "list";

	}*/
	
}
