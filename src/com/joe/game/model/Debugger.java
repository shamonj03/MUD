package com.joe.game.model;

import java.util.Date;

public class Debugger {

	public static final int NONE = 0x0;
	public static final int ERROR = 0x1;
	public static final int DEFF = 0x2;
	public static final int TEST = 0x4;
	
	private static final int GLOBAL_RIGHTS = ERROR | DEFF | TEST;
	
	public static void log(String message, int rights) {
		Date d = new Date();
		
		rights &= GLOBAL_RIGHTS;
		
		String header = "";
		
		if((rights & DEFF) == DEFF) {
			header = header + " " + "DEFF";
		}

		if((rights & TEST) == TEST) {
			header = header + " " + "TEST";
		}
		
		if((rights & ERROR) == ERROR) {
			header = header + " " + "ERROR";
		}
		
		message = d + header + ": " + message;
		
		if((rights & ERROR) == ERROR) {
			System.err.println(message);
		} else {
			System.out.println(message);			
		}
	}
}
