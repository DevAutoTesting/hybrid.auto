package testCases;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonMethods {

	
	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
		
	}
	

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
		
		
	}
	public String randomAlphaNumaric() {
		String generatedNumber = RandomStringUtils.randomAlphabetic(8);
		System.out.println(generatedNumber);
		return generatedNumber;
		
		
	}
}
