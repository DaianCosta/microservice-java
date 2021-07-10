package com.daian.crud.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -568688678579598690L;
	
	public ResourceNotFoundException(String exception) {
		super(exception);
	}

}
