package com.iceze.service;

/**
 * Invalid task exception.
 * 
 * @author miroslav
 */
public class TaskException extends RuntimeException {
	private static final long serialVersionUID = -9096652951128464901L;

	public TaskException(final String e) {
		super(e);
	}
}
