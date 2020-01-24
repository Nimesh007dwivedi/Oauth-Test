package com.api.postgress.main.files;

public class CommonUtility {


	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * Constant.ALPHA_NUMERIC_STRING.length());
			builder.append(Constant.ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
