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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
* This class will add fligth details
* and also display the fligth details.
* @version1.8.0_201 17 MAR 2019
* @author Siddesh Mahajan
*/
public class FligthDetails {
	String flightNo;
	String fligthName;
	String fligthSource;
	String fligthDestination;
	Date departureDate;
	String departureTime;
	String arrivalTime;
	int fligthCharges;
	
	/**This constructor used to intialize the 
	 * data members of FligthDetails class*/
	public FligthDetails(String fligthNo,String fligthName,String fligthSource,String fligthDestination,
					Date departureDate,String departureTime,String arrivalTime,int fligthCharges) {
		this.flightNo=fligthNo;
		this.fligthName=fligthName;
		this.fligthSource=fligthSource;
		this.fligthDestination=fligthDestination;
		this.departureDate=departureDate;
		this.departureTime=departureTime;
		this.arrivalTime=arrivalTime;
		this.fligthCharges=fligthCharges;
	}
	public FligthDetails() {}
	
	ArrayList<FligthDetails> ar=new ArrayList<FligthDetails>();
	Scanner sc=new Scanner(System.in);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
	
	//This method will add fligth details
	ArrayList<FligthDetails> addFligthDetails() {
		
		try{
			String date1="2018-MAR-17";
			departureDate=dateFormat.parse(date1);
			ar.add(new FligthDetails("f1","Indigo","Bangalore","Mumbai",departureDate,"2.00pm","6.00pm",10000));
			ar.add(new FligthDetails("f2","Jet Airways","Bangalore","Mumbai",departureDate,"12.00am","6.00pm",15000));
			return ar;
		}catch(Exception e) {
			System.out.println("Invalid Input..");
		}
		return ar;
	}
	
	//This method will add new passenger details and take input from the user
	ArrayList<FligthDetails> addNewFligthDetails(){
		try {
			System.out.println("Enter Fligth No: ");
			flightNo=sc.next();
			System.out.println("Enter Fligth Name(in alphabets): ");
			fligthName=sc.next();
			boolean v1=isAlphabet(fligthName);
			System.out.println("Enter Fligth Source(From)(in alphabets): ");
			fligthSource=sc.next();
			boolean v2=isAlphabet(fligthSource);
			System.out.println("Enter Fligth Destination(To)(in alphabets): ");
			fligthDestination=sc.next();
			boolean v3=isAlphabet(fligthDestination);
			System.out.println("Enter Departure Date(yyyy-MMM-dd): ");
			String date=sc.next();
			departureDate=dateFormat.parse(date);
			System.out.println("Enter Fligth Departure Time(tt.ss am)/(tt.ss pm): ");
			departureTime=sc.next();
			System.out.println("Enter Fligth Arrival Time(tt.ss am)/(tt.ss pm): ");
			arrivalTime=sc.next();
			System.out.println("Enter Fligth Charges: ");
			fligthCharges=sc.nextInt();
			
			ar.add(new FligthDetails(flightNo,fligthName,fligthSource,fligthDestination,departureDate,departureTime,arrivalTime,fligthCharges));
			System.out.println("Fligth Details Added Successfully..");
			return ar;
		}catch(Exception e) {
			System.out.println("Invalid Details..");
		}
		return ar;
	}
	
	//This method will dispaly fligth details
	public ArrayList<FligthDetails> fligthInfo(ArrayList<FligthDetails> fligthDetails) {
		if(ar.size()>0) {
			System.out.println("Fligth Name\tFligth Source\tFligth Destination\tDeparture Date\tDeparture Time\tArrival Date");
			for(int i=0;i<ar.size();i++) {
				System.out.println((ar.get(i)).info());
			}
			return ar;
		}
		System.out.println("No Fligths");
		return ar;
	}
	
	//This method will return fligth details
	String info() {
		return "\n"+fligthName+"\t"+fligthSource+"\t"+fligthDestination+"\t"+departureDate+"\t"+departureTime;
	}
	
	//This method will return figth source
	public String getSource() {
		return fligthSource;
	}
	
	//This method will return fligth destination
	public String getFligthDestination() {
		return fligthDestination;
	}
	
	//This method will return fligth timing
	public String getFligthTime() {
		return departureTime;
	}
	
	//This method will return flight dates
	public Date getFligthDate() {
		return departureDate;
	}
	
	//This method will return fligth no
	public String getFligthNo() {
		return flightNo;
	}
	
	//Method will check weather the given input is only alphabets
	public boolean isAlphabet(String word) {
		char[] ch=word.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>=65 && ch[i]<=89 || ch[i]>=97 && ch[i]<=121) {
					return true;
			}else {
				System.out.println("Enter only Alphabets..");
				addNewFligthDetails();
			}
		}
		return false;
	}
}
