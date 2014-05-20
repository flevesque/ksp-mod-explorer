package com.criticalweb.ksp.mod.explorer.forms.validation;

/**
 * @author: Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */

import org.mvel.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MustMatchValidator implements ConstraintValidator<MustMatch, Object>
{

	private String firstField;
	private String secondField;

	private static final Logger LOG = LoggerFactory.getLogger(MustMatchValidator.class);

	@Override
	public void initialize(MustMatch mustMatch)
	{
		firstField = mustMatch.first();
		secondField = mustMatch.second();
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext)
	{
		boolean matches;

		Object firstFieldObj = MVEL.getProperty(firstField, o);
		Object secondFieldObj = MVEL.getProperty(secondField, o);

		if (firstFieldObj == null && secondFieldObj == null) {
			return true;
		}

		matches = (firstFieldObj != null) && (firstFieldObj.equals(secondFieldObj));

		return matches;
	}
}