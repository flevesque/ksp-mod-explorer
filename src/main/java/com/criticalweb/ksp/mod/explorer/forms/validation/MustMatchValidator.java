package com.criticalweb.ksp.mod.explorer.forms.validation;

 /*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */

 /*
 * Author: flevesque
 *
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