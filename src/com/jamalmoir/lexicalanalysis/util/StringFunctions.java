package com.jamalmoir.lexicalanalysis.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringFunctions {
	
	public static String strip(final String str) {
		final Pattern urlPattern = Pattern.compile(
				"/^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$/");
		final Pattern emailPattern = Pattern.compile(
				"/^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$/");
		final Pattern stripPattern = Pattern.compile(
				"^[\\.,-\\/#!$%\\^&\\*;:{}=\\-_`~()\\?]*([a-zA-Z-]*)[\\.,-\\/#!$%\\^&\\*;:{}=\\-_`~()\\?]*$");
		
		Matcher urlMatcher = urlPattern.matcher(str);
		Matcher emailMatcher = emailPattern.matcher(str);
		Matcher stripMatcher = stripPattern.matcher(str);
		
		String result = ".";
		
		if ((!urlMatcher.matches() || !emailMatcher.matches()) 
				&& stripMatcher.find()) {
			result = stripMatcher.group(0);
		}
		
		return result;
	}

}
