package com.project.assignment.utils.exceptions;

public enum ApiErrorCodeEnum {
	BUSINESS_CONSTRAINT_VIOLATION, FOREIGN_KEY_CONSTRAINT_VIOLATION, UNIQUE_KEY_CONSTRAINT_VIOLATION, BAD_REQUEST,
	MEDIA_TYPE_NOT_ACCEPTED, MEDIA_TYPE_NOT_SUPPORTED, INTERNAL_SERVER_ERROR, METHOD_NOT_ALLOWED, ACCESS_IS_DENIED,
	BUSINESS_CONSTRAINT_WARNING;

	private ApiErrorCodeEnum() {
	}
}
