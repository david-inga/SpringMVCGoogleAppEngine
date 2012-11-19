package com.mkyong.resource;

import org.restlet.data.Form;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



import com.google.appengine.api.datastore.Email;
import com.mkyong.model.BaseSerializer;
import com.mkyong.model.Customer;

public class CustomerSerializer extends BaseSerializer<Customer>{
	
	public static final String CODE_ELEMENT = "codigo";
	private static final String FIRST_NAME_ELEMENT = "nombres";
	private static final String LAST_NAME_ELEMENT = "apellidos";
	private static final String EMAIL_ELEMENT = "email";
	public static final String LIST_ROOT_ELEMENT = "customers";
	private static final String CUSTOMER_ELEMENT = "customer";

	public Customer entity;

	public CustomerSerializer() {

	}

	public CustomerSerializer(Customer entity) {
		this.entity = entity;
	}

	@Override
	public Customer getEntity() {
		return entity;
	}

	@Override
	public String getRootListElement() {
		return LIST_ROOT_ELEMENT;
	}

	@Override
	public void intializeProperties(Form form) {
		if (form.getFirstValue(CODE_ELEMENT) != null) {
			entity.setId(Long.parseLong(form.getFirstValue(CODE_ELEMENT)));
		}
		entity.setFirstName(form.getFirstValue(FIRST_NAME_ELEMENT));
		entity.setLastName(form.getFirstValue(LAST_NAME_ELEMENT));
		entity.setEmail(new Email(form.getFirstValue(EMAIL_ELEMENT)));
	}

	@Override
	public void setEntity(Customer entity) {
		this.entity = entity;
	}

	@Override
	public void setId(Long id) {
		entity.setId(id);
	}

	@Override
	public Element toXml(Document document) {
		Element studentElement = document.createElement(CUSTOMER_ELEMENT);

		Element studentIdElement = document.createElement(CODE_ELEMENT);
		studentIdElement.appendChild(document.createTextNode(entity.getId()
				.toString()));
		studentElement.appendChild(studentIdElement);

		Element firstNameElement = document.createElement(FIRST_NAME_ELEMENT);
		firstNameElement.appendChild(document.createTextNode(entity
				.getFirstName()));
		studentElement.appendChild(firstNameElement);

		Element lastNameElement = document.createElement(LAST_NAME_ELEMENT);
		lastNameElement.appendChild(document.createTextNode(entity
				.getLastName()));
		studentElement.appendChild(lastNameElement);

		Element emailElement = document.createElement(EMAIL_ELEMENT);
		emailElement.appendChild(document.createTextNode(entity.getEmail()
				.getEmail()));
		studentElement.appendChild(emailElement);

		return studentElement;
	}

	@Override
	public String getCodeElement() {
		return CODE_ELEMENT;
	}

}
