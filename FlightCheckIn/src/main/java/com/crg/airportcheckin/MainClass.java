/*
* Siddesh Mahajan
*
* Copyright (c) 2019 CRG Solution. All Rights Reserved.
*
* This software is the confidential and proprietary information of CRG
* Solution, Pvt. Ltd. ("Confidential Information"). You shall not
* disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Sun.
*
* CRG MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
* THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
* TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
* PARTICULAR PURPOSE, OR NON-INFRINGEMENT. CRG SHALL NOT BE LIABLE FOR
* ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
* DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/
package com.crg.airportcheckin;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This is main class where the program start its execution.
* This class ask user for ther choice and make further procedure.
* Class will redirect to add passanger ,fligth details and checkin process.
* @version1.8.0_201 17 MAR 2019
* @author Siddesh Mahajan
*/
public class MainClass {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
		start();
	}
	
	/** 
	 * This method will ask for user choice and redirect the page according to 
	 * there choice*/
	static void start() throws ParseException {
		System.out.println("Welcome to Bangalore Airport");
		System.out.println("1. Passenger");
		System.out.println("2. Flight Details");
		System.out.println("3. Check-In\n");
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter your choice: ");
		int choice=sc.nextInt();
		
		Passengers ps=new Passengers();
		FligthDetails fd=new FligthDetails();
		Booking b=new Booking();
		CounterCheckIn cc=new CounterCheckIn();
		
		switch(choice) {
			case 1: System.out.println("Enter Passengers Details\n");
					ArrayList<Passengers> details=ps.addNewPassengersDetails();
					ps.passengersInfo(details);
					System.out.println("Make Reservation??? (Yes:1 or No:0)");
					int ch=sc.nextInt();
					if(ch == 1) {
						System.out.println("Book Your Tickets: ");
						ArrayList<Booking> bk= b.ticketBooking();
						b.checkFligthAvailable(bk);
						System.out.println("Enter Fligth No: ");
						String fNo=sc.nextLine(); 
						make:{
							while ( true )
							{
							   b.makeReservation();
							   System.out.println("Do you want more seats?? (Yes:1 or No:0)");
							   int ch1=sc.nextInt();
							   if(ch1 == 1) {
								   b.makeReservation();
							   	   break make;
							   } 
							   else {
								   break make;
							   }
							} 
						} 
					
					}else {
						start();
					}
					break;
			case 2: boolean auth = flightLoginAuth();
					if(auth) {
						System.out.println("Enter Flight Details");
						ArrayList<FligthDetails> fligthDetails=fd.addFligthDetails();
						fd.fligthInfo(fligthDetails);
						System.out.println("Do you want to eneter new fligth detals? (1:Yes,2:No): ");
						int n=sc.nextInt();
						if(n == 1) {
							ArrayList<FligthDetails> fligthDetails1=fd.addNewFligthDetails();
							fd.fligthInfo(fligthDetails1);
							start();
						}else {
							start();
						}
					}else {
						System.out.println("Invalid Username/Password..");
						start();
					}
					break;
			case 3: System.out.println("Check-In Process...");
					cc.counterCheckIn();
					break;
			default: System.out.println("Invalid Input");
					break;
		}
	}
	//Login authentication of flight
	private static boolean flightLoginAuth() {
		System.out.print("Enter UserName : ");
		String uName = sc.next();
		System.out.print("\nEnter Password : ");
		String uPassword = sc.next();
		if(uName.equalsIgnoreCase("siddesh")&&uPassword.equals("1234")) {
			return true;
		}
		return false;
	}
	
}
