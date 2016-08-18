package com.kind.perm.web.common;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateTypeEditor extends PropertyEditorSupport {

	private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private static final DateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private DateFormat dateFormat;

	private boolean allowEmpty = true;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			setValue(null);
		} else {
			try {
				if (this.dateFormat != null) {
					setValue(this.dateFormat.parse(text));
					return;
				}
				if (text.contains(":")) {
					setValue(TIMEFORMAT.parse(text));
				} else {
					setValue(DATEFORMAT.parse(text));
				}
			} catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
			}
		}
	}

	/**
	 * Format the Date as String, using the specified DateFormat.
	 */
	@Override
	public String getAsText() {
		Date value = (Date) getValue();
		DateFormat dateFormat = this.dateFormat;
		if (dateFormat == null) {
			dateFormat = TIMEFORMAT;
		}
		return (value != null ? dateFormat.format(value) : "");
	}

}
