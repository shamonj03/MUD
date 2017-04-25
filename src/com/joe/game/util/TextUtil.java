package com.joe.game.util;

import java.util.Scanner;

public class TextUtil {

	private static final Scanner scanner = new Scanner(System.in);

	private static String getInput() {
		String input = scanner.nextLine();
		input = input.trim();
		return input;
	}

	public static String promptInput(String prompt) {
		System.out.print(prompt);
		return getInput();
	}

	public static int promptInputInt(String prompt) {
		int optInt = Integer.MIN_VALUE;

		while (optInt == Integer.MIN_VALUE) {
			String option = promptInput(prompt);

			try {
				optInt = Integer.parseInt(option);
			} catch (Exception e) {
				System.out.println("Invalid input, try again.");
				optInt = Integer.MIN_VALUE;
			}
		}
		return optInt;
	}

	public static char promptInputChar(String prompt) {
		String option = null;

		boolean run = true;
		while (run) {
			option = promptInput(prompt);
			if (option == null || option.length() > 1 || option.isEmpty()) {
				System.out.println("Invalid input, try again.");
			} else {
				run = false;
				break;
			}
		} 
		
		return option.charAt(0);
	}

	public static void scrollText(String... lines) {
		for (int line = 0; line < lines.length; line++) {
			for (int pos = 0; pos < lines[line].length(); pos++) {
				char c = lines[line].charAt(pos);
				System.out.print(c);

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}
	}
}
