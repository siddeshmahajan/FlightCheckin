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
* This class will accept the source and destination of fligth and  
* check weither fligth are availabe and book the seats.
* Seats are booked according to classes.
* @version1.8.0_201 17 MAR 2019
* @author Siddesh Mahajan
*/
public class Booking {
	String source,destination;
	/**This constructor used to intialize the 
	 * data members of Booking class*/
	public Booking(String source,String destination) {
		this.source=source;
		this.destination=destination;
	}
	
	public Booking() {}
	ArrayList<Booking> ar=new ArrayList<Booking>();
	Scanner sc=new Scanner(System.in);
	
	//This method will ask for source and destination info
	ArrayList<Booking> ticketBooking (){
		System.out.println("Enter Source(From): ");
		source = sc.next();
		System.out.println("Enter Destination(To): ");
		destination=sc.next();
		ar.add(new Booking(source,destination));
		return ar;
	}
	
	FligthDetails fd=new FligthDetails();
	
	ArrayList<FligthDetails> ft= fd.addFligthDetails();
	
	/**This method will check weather fligth are available for given
	 * source and detination and display details 
	 * @param bk
	 */
	public void checkFligthAvailable(ArrayList<Booking> bk) {
		for(int i=0;i<ft.size();i++) {
			if(source.equalsIgnoreCase(ft.get(i).getSource()) && destination.equalsIgnoreCase(ft.get(i).getFligthDestination())) {
				System.out.println("Fligth No: "+ft.get(i).getFligthNo()+"\tSource: "+ source +"\t Destination: "+destination+
						"\tTime: "+ft.get(i).getFligthTime()+"\tDate: "
						+ft.get(i).getFligthDate());
			}else {
				System.out.println("No Fligth's Available....");
			}
		}
	}
	
	boolean[] seating = new boolean[11]; /* create 10 seat numbers (array[0] will not be used). Empty seat indicated by false*/
    Scanner input = new Scanner(System.in);

    /** This method will make reservation of seats and booking 
     * according user request for first class or economy.
     * @throws ParseException
     */
    public void makeReservation() throws ParseException
    {
        System.out.println("Please type 1 for First Class or 2 for Economy: ");
        int section = input.nextInt();
        if ( section == 1 )
        {
            firstClassSeat();
        }
        else
        {
            economySeat();
        }
    }

    public void firstClassSeat() throws ParseException // assign a first class seat
    {
        for ( int count = 1; count <= 5; count++ )
        {
            if ( seating[count] == false )  // if false, then a seat is available for assignment
            {
                seating[count] = true;  // assign seat
                System.out.printf("First Class. Seat# %d\n", count);
                break;
            }
            else if ( seating[5] == true ) // If seating[5] is true then first class is fully booked
            {
                if ( seating[10] == true) // If seating[10] is true then economy (and therefore whole flight) is fully booked
                {
                    System.out.println("Sorry, flight fully booked. Next flight is in 3 hours.");
                }
                else // ask passenger if they would like an economy ticket instead
                {
                    System.out.println("First Class is fully booked. Would you like Economy? 1 for Yes 2 for No");
                    int choice = input.nextInt();
                    if ( choice == 1 )
                    {
                        economySeat();
                        //MainClass.start();
                    }
                    else
                    {
                        System.out.println("Next flight is in 3 hours.");
                        System.exit(0);
                    }
                }
            }
        }
    }   
    
    public void economySeat() throws ParseException // assign an economy seat
    {
        for ( int count = 6; count <= 10; count++ )
        {
            if ( seating[count] == false ) // if false, then a seat is available for assignment
            {
                seating[count] = true; // assign seat
                System.out.printf("Economy. Seat# %d\n", count);
                break;
            }
            else if ( seating[10] == true ) // If seating[10] is true then economy is fully booked
            {
                if ( seating[5] == true) // If seating[5] is true then first class (and therefore whole flight) is fully booked
                {
                    System.out.println("Sorry, flight fully booked. Next flight is in 3 hours.");
                    System.exit(0);
                }
                else // ask if passenger would like a first class ticket instead
                {
                    System.out.println("Economy is fully booked. Would you like First Class? 1 for Yes 2 for No");
                    int choice = input.nextInt();
                    if ( choice == 1 )
                    {
                        firstClassSeat();
                       // MainClass.start();
                    }
                    else
                    {
                        System.out.println("Next flight is in 3 hours");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
