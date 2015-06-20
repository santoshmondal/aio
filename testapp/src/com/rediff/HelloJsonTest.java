package com.rediff;

import org.apache.commons.lang3.StringEscapeUtils;

public class HelloJsonTest {

	public static void main(String[] args) {
		String str = "dafncd'+dfaf'";
		
		System.out.println(StringEscapeUtils.escapeEcmaScript(str));
	}
}
