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

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
* This class will add passengers details and also display.
* @version1.8.0_201 17 MAR 2019
* @author Siddesh Mahajan
*/
public class Passengers {
	String firstName;
	String middleName;
	String lastName;
	String gender;
	BigInteger phoneNumber;
	Date dateOfBirth;
	String address;
	String passengerFullName;
	int passportId;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
	
	/**This constructor used to intialize the 
	 * data members of passenger class*/
	public Passengers(String firstName,String middleName,String lastName,String gender,BigInteger phoneNumber,
					Date dateOfBirth,String address,int passportId) {
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.gender=gender;
		this.phoneNumber=phoneNumber;
		this.dateOfBirth=dateOfBirth;
		this.address=address;
		this.passportId=passportId;
		this.passengerFullName=firstName+" "+middleName+" "+lastName;
	}
	
	public Passengers() {}
	
	ArrayList<Passengers> passengersDetails = new ArrayList<Passengers>();
	Scanner sc=new Scanner(System.in);
	
	/** This method will add new passenger by taking input
	 * from user.
	 * @return
	 */
	ArrayList<Passengers> addNewPassengersDetails(){
		try {
			System.out.println("Enter First Name of Passenger(Only Alphabets): ");
			firstName=sc.next();
			boolean v1 = isAlphabet(firstName);
			System.out.println("Enter Middle Name of Passenger(Only Alphabets): ");
			middleName=sc.next();
			boolean v2 = isAlphabet(middleName);
			System.out.println("Enter Last Name of Passengers(Only Alphabets): ");
			lastName=sc.next();
			boolean v3 = isAlphabet(lastName);
			System.out.println("Enter Passenger Gender (Male or Female): ");
			gender=sc.next();
			System.out.println("Enter Contact Number of Passenger: ");
			phoneNumber=sc.nextBigInteger();
			System.out.println("Enter Date of Birth (yyyy-MMM-dd): ");
			String date=sc.next();
			dateOfBirth = dateFormat.parse(date);
			System.out.println("Enter address of Passenger: ");
			address=sc.next();
			System.out.println("Enter Passport Id: ");
			passportId=sc.nextInt();
			
			long phn = phoneNumber.longValue();
			double calc = phn/1000000000;
			
			Passengers ps=new Passengers(firstName,middleName,lastName,gender,phoneNumber,dateOfBirth,address,passportId);
			if((gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")) && calc>1&&calc<10){
				passengersDetails.add(ps);
				System.out.println("\nPassenger Details Added Succesfully...\n");
				return passengersDetails;
			}else {
				System.out.println("Invalid Data..");
				addNewPassengersDetails();
			}
		}catch(Exception e) {
			System.out.println("Invalid Data..");
			addNewPassengersDetails();
		}
		return passengersDetails;
	}
	
	/** This method will add existing passenger details
	 * @return
	 */
	public ArrayList<Passengers> addPassengers(){
		try {
			String date1="1994-MAR-07";
			dateOfBirth=dateFormat.parse(date1);
			String phno="987654321";
			BigInteger b=new BigInteger(phno);
			passengersDetails.add(new Passengers("Siddesh","Sanjay","Mahajan","Male",b,dateOfBirth,"Belgaum",11));
			passengersDetails.add(new Passengers("Majunath","R","K","Male",b,dateOfBirth,"Mysore",22));
			return passengersDetails;
		}catch(Exception e) {
			System.out.println("Invalid Date..");
		}
		return passengersDetails;
	}
	
	// This method will display passenger details 
	public ArrayList<Passengers> passengersInfo(ArrayList<Passengers> passengersDetails) {
		if(passengersDetails.size()>0) {
			System.out.println("Full Name\tContactNo\tGender");
			for(int i=0;i<passengersDetails.size();i++) {
				System.out.println((passengersDetails.get(i)).info());
			}
			return passengersDetails;
		}
		System.out.println("No Passengers..");
		return passengersDetails;
	}
	
	//This method will return passenger details
	String info() {
		return "\n"+passengerFullName+"\t"+phoneNumber+"\t"+gender+"\t";
	}
	
	//This method will return only passport id
	public int getPassportId() {
		return passportId;
	}
	
	//Method will check weather the given input is only alphabets
	public boolean isAlphabet(String word) {
		char[] ch=word.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>=65 && ch[i]<=89 || ch[i]>=97 && ch[i]<=121) {
					return true;
			}else {
				System.out.println("Enter only Alphabets..");
				addNewPassengersDetails();
			}
		}
		return false;
	}
}
