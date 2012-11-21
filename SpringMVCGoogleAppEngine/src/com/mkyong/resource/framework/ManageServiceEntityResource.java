package com.mkyong.resource.framework;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;

import com.googlecode.objectify.Key;
import com.mkyong.dao.ManageServiceDAO;
import com.mkyong.model.BaseSerializer;

/**
 * @author cgavidia
 * 
 */
public class ManageServiceEntityResource<T> extends ServerResource {

	public static final Logger LOG = Logger
			.getLogger(ManageServiceEntityResource.class.getName());
	private static final String GENERIC_ERROR_CODE = "0";
	private static final String GENERIC_ERROR_MSG = "Ocurrió un error inesperado";

	private T currentEntity;
	private String currentId;

	private ManageServiceDAO<T> dao;
	protected Class<T> clazz;
	private BaseSerializer<T> serializer;

	public ManageServiceEntityResource(Class<T> clazz,
			BaseSerializer<T> serializer) {
		this.dao = new ManageServiceDAO<T>(clazz);
		this.clazz = clazz;
		this.serializer = serializer;
	}

	@Override
	protected void doInit() throws ResourceException {
		currentId = (String) getRequest().getAttributes().get(serializer.getCodeElement());
		currentEntity = getEntity(currentId);
		setExisting(currentEntity != null);
	}

	@Delete
	public void removeEntity() {
		if (currentEntity != null) {
			removeEntity(currentId);
		}
		setStatus(Status.SUCCESS_NO_CONTENT);
	}

	@Put
	public void storeEntity(Representation entity) {
		try {
			currentEntity = clazz.newInstance();
			serializer.setEntity(currentEntity);
			serializer.intializeProperties(new Form(entity));
			serializer.setId(Long.parseLong(currentId));
			dao.add(currentEntity);
			setStatus(Status.SUCCESS_OK);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error in PUT", e);
			setStatus(Status.SERVER_ERROR_INTERNAL);
		}

	}

	@Get("xml")
	public Representation toXml() {
		try {
			DomRepresentation representation = new DomRepresentation(
					MediaType.TEXT_XML);
			Document document = representation.getDocument();
			serializer.setEntity(currentEntity);
			document.appendChild(serializer.toXml(document));
			return representation;
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Error in GET", e);
			setStatus(Status.SERVER_ERROR_INTERNAL);
			return ManageServiceListResource
					.generateErrorRepresentation(GENERIC_ERROR_MSG + ": "
							+ e.toString(), GENERIC_ERROR_CODE);
		}
	}

	private void removeEntity(String id) {
		dao.delete(Key.create(clazz, Long.parseLong(id)));
	}

	private T getEntity(String id) {
		try {
			return dao.get(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
