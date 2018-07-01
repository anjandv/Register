package com.mycompanyname.register.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends IOException{

	 private String resourceName;
	    private String fieldName;
	    private Object fieldValue;

	    public BadRequestException( String resourceName, String fieldName, Object fieldValue) {
	        super(String.format("%s %s :'%s'", resourceName, fieldName, fieldValue));
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	        this.fieldValue = fieldValue;
	    }

	    public String getResourceName() {
	        return resourceName;
	    }

	    public String getFieldName() {
	        return fieldName;
	    }

	    public Object getFieldValue() {
	        return fieldValue;
	    }
}
