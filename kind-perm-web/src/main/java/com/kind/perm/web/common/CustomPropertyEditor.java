package com.kind.perm.web.common;

import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.web.bind.annotation.InitBinder;

public class CustomPropertyEditor implements PropertyEditorRegistrar {

	@Override
	@InitBinder
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new DateTypeEditor());
	}

}
