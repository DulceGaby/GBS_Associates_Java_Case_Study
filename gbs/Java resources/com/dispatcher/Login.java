package com.dispatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
	
	public static void main(String[] args) {
		// Check if it is a correct email
	    Pattern pattern = Pattern
	            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    
	    String email = "dulce.gmaron@gmail";

	    Matcher mather = pattern.matcher(email);

	    if (mather.find() == true) {
	        System.out.println("El email ingresado es válido.");
	    } else {
	        System.out.println("El email ingresado es inválido.");
	    }
	}
	

}
