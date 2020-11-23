package fr.ensiie.hotels_webservices.model;

import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		HotelbookingindicatorServiceStub stub = new HotelbookingindicatorServiceStub();
		
		Scanner scanner = new Scanner(System. in);
		Actions action = new Actions();
		
		System.out.println("**********Welcome to Hotel Booking***********");
		action.connect(stub);
		int option = -1;
		while(option !=0) {
			option = action.consoleMenu(scanner);
			action.execOption(option, stub);
		}
	}

}
