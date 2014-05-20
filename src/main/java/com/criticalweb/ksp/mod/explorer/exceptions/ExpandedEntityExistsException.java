package com.criticalweb.ksp.mod.explorer.exceptions;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
public class ExpandedEntityExistsException extends EntityExistsException {

	private List<String> fields = new ArrayList<>();

	public ExpandedEntityExistsException() {
		super();
	}

	public ExpandedEntityExistsException(String message) {
		super(message);
	}

	public ExpandedEntityExistsException(String message, List<String> fields) {
		super(message);
		addAllFields(fields);
	}

	public ExpandedEntityExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExpandedEntityExistsException(Throwable cause) {
		super(cause);
	}

	public void addField(String field) {
		fields.add(field);
	}

	public void addAllFields(List<String> fields) {
		this.fields.addAll(fields);
	}

	public List<String> getFields() {
		return fields;
	}

}
