package br.com.wine.utils;

import java.util.Scanner;

public class ConsoleScanner {
	
	public static String getConsoleInput(String mensagem) {
		System.out.println(mensagem);
		Scanner lerResp = new Scanner(System.in);
		return lerResp.nextLine();
	}
}
