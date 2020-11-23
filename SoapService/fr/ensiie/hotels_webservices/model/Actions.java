package fr.ensiie.hotels_webservices.model;

import java.rmi.RemoteException;
import java.util.Scanner;

import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.CancelReservationRequest;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.CancelReservationResponse;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetHotelRequest;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetHotelResponse;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetMyReservationRequest;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetMyReservationResponse;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetUserRequest;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.GetUserResponse;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.Hotel;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.PostReservationRequest;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.PostReservationResponse;
import fr.ensiie.hotels_webservices.model.HotelbookingindicatorServiceStub.Reservation;

public class Actions {
	public static Scanner scanner = new Scanner(System. in);
	//Function to display the menu
	public static int consoleMenu(Scanner in) {
	        
	        int decision;
	
	        String menu = "\n**** MENU ****\n" +
	                "-- [0] to exit \n" +
	                "-- [1] to check hotels.\n" +
	                "-- [2] to make a reservation(s).\n" +
	                "-- [3] to cancel a reservation.\n" +
	                "-- [4] to display your reservations.\n";
	        
	        System.out.println(menu);
	        decision = Integer.parseInt(in.nextLine());
	       	
	        return decision;
	    }
//function to connect 
	public static void connect(HotelbookingindicatorServiceStub stub) throws RemoteException {
		Scanner scanner = new Scanner(System. in);
		String cnx = "false";
		while(cnx=="false") {
			System.out.println("Enter your name : ");
	        
	        String name = scanner. nextLine();
	        System.out.println("Enter your password : ");
	        String password = scanner. nextLine();
			GetUserRequest user = new GetUserRequest();
			if(name.isEmpty() || password.isEmpty()) {
				cnx="false";
				System.out.println("Login or password incorrect");
			}
			else {
			user.setUsername(name);
			user.setUserpassword(password);
			//GetUserResponse response = new GetUserResponse();
			stub.getUser(user);
			GetUserResponse res = stub.getUser(user);
			String result = res.getReponse();
				if (result.equals("cnx")){
					cnx="true";	
				}
				else {
					cnx="false";
					System.out.println("Login or password incorrect");
				}
			}		
		}
	}
	public static void checkHotel(HotelbookingindicatorServiceStub stub) throws RemoteException {
		Scanner scanner = new Scanner(System. in);
		System.out.println("Enter the arrival date (yyyy-mm-dd) : ");
		String datein = scanner. nextLine();
		System.out.println("Enter the departure date (yyyy-mm-dd) : ");
		String dateout = scanner. nextLine();
		System.out.println("Enter number of rooms: ");
		long nbrroom= scanner.nextInt();
		GetHotelRequest hotel = new GetHotelRequest();
		hotel.setDate_in(datein);
		hotel.setDate_out(dateout);
		hotel.setNbrRooms(nbrroom);
		GetHotelResponse res1 = stub.getHotel(hotel);
        Hotel[] result2 = res1.getHotel();
        
        for (int i=0; i<result2.length; i++) {
        	System.out.println("Hotel ID : "+result2[i].getId()+"\n");
        	System.out.println("    Name : "+result2[i].getName()+"\n");
        	System.out.println("    Description : "+result2[i].getDescription()+"\n");
        		
		}	
	}
	//User reservations
	public static void checkUserReservation(HotelbookingindicatorServiceStub stub) throws RemoteException {
		
		System.out.println("Enter your ID: ");
		long userid= scanner.nextInt();
		GetMyReservationRequest reservationrequest = new GetMyReservationRequest();
		reservationrequest.setIdUser(userid);
		GetMyReservationResponse res4= stub.getMyReservation(reservationrequest);
		Reservation[] result4 = res4.getReservation();
        
        for (int i=0; i<result4.length; i++) {
        	System.out.println("------Reservation ID---- : "+result4[i].getIdBooking()+"\n");
        	System.out.println("Room Description : "+result4[i].getRoom().getDescription()+"\n");
        	System.out.println("Client First Name : "+result4[i].getUser().getFirstname()+"\n");
        	System.out.println("Client Last Name : "+result4[i].getUser().getLastname()+"\n");
        	System.out.println("Hotel Name : "+result4[i].getRoom().getHotel().getName()+"\n");
        		
		}	
	}
	public static void makeReservation(HotelbookingindicatorServiceStub stub) throws RemoteException {
		Scanner scannerreserve = new Scanner(System. in);
     	System.out.println("Enter the arrival date of reservation (yyyy-mm-dd) : ");
		String dateinreservation = scannerreserve. nextLine();
		System.out.println("Enter the departure date of reservation (yyyy-mm-dd)  : ");
		String dateoutreservation = scannerreserve. nextLine();
        System.out.println("Enter ID Hotel: ");
        int idhotel = scanner.nextInt();
        System.out.println("Enter number of rooms: ");
		long nbrroomreservation= scanner.nextInt();
		System.out.println("Enter ID User: ");
        int  iduser = scanner.nextInt();
			
        PostReservationRequest reservation = new PostReservationRequest();
         reservation.setDate_in(dateinreservation);
         reservation.setDate_out(dateoutreservation);
         reservation.setIdHotel(idhotel);
         reservation.setIdUser(iduser);
         reservation.setNbrRooms(nbrroomreservation);
         
        PostReservationResponse postreservation = stub.postReservation(reservation);
        String result3 = postreservation.getReponse();
        System.out.println(result3);
		
	}
	public static void cancelReservation(HotelbookingindicatorServiceStub stub) throws RemoteException {
      System.out.println("Enter ID Reservation: ");
      int idreservation = scanner.nextInt();
      CancelReservationRequest cancel = new CancelReservationRequest();
      cancel.setNoReservation(idreservation);
      CancelReservationResponse cancelreponse =stub.cancelReservation(cancel);
      String rslt = cancelreponse.getReponse();
      System.out.println(rslt);
	
	}
	
	public static void execOption(int opt, HotelbookingindicatorServiceStub stub) throws RemoteException {
		if(opt==1) checkHotel(stub);
		if(opt==2) makeReservation(stub);
		if(opt==3) cancelReservation(stub);
		if(opt==4) checkUserReservation(stub);
	}
}