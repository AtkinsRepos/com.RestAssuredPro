package com.RestAssuredPro.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
	 //generating random string for fields that must change value at the point of data entry eg username, emails, pwd, DOB etc. a very useful utility.
	  public static String randomestring() {
			String generatedString = RandomStringUtils.randomAlphabetic(4);
			return ("peter"+ generatedString);
		}

		public static String randomeNum() {
			String generatedString = RandomStringUtils.randomNumeric(6);
			return (generatedString);
		}
		public static String randomeNum2() {
			String generatedString = RandomStringUtils.randomNumeric(2);
			return (generatedString);
		}
		public static String randomeAlphaNumeral() {
			String randomeAlphaNumera = RandomStringUtils.randomAlphanumeric(8);
			return (randomeAlphaNumera);
		}

}
