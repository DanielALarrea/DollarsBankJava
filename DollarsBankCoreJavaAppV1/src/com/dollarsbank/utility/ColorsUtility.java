package com.dollarsbank.utility;

public class ColorsUtility {
	
	public static void printRed(String string) {
		System.out.println("\u001b[31m" + string + "\u001b[0m");
	}
	
	public static void printGreen(String string) {
		System.out.println("\u001b[32m" + string + "\u001b[0m");
	}
	
	public static void printYellow(String string) {
		System.out.println("\u001b[33m" + string + "\u001b[0m");
	}
	
	public static void printBlue(String string) {
		System.out.println("\u001b[34m" + string + "\u001b[0m");
	}
	
	public static void startColorText(int colorCode) {
		System.out.print("\u001b[" + colorCode + "m");
	}
	
	public static void endColorText() {
		System.out.print("\u001b[0m");
	}

}
