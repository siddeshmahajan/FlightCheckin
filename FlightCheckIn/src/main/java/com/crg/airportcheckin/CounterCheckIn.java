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

import java.util.ArrayList;
import java.util.Scanner;
/**
* This class will check the document like passport id and 
* fligth id and proceed for baggage process.
* @version1.8.0_201 17 MAR 2019
* @author Siddesh Mahajan
*/
public class CounterCheckIn {
		int passportId;
		String fligthNo;
		
		/**This constructor used to intialize the 
		 * data members of CounterCheckIn class*/
		public CounterCheckIn(int passportId,String fligthNo) {
			this.passportId=passportId;
			this.fligthNo=fligthNo;
		}
		
		public CounterCheckIn() {}
		
		FligthDetails fd=new FligthDetails();
		ArrayList<FligthDetails> ft= fd.addFligthDetails();
		
		Passengers p=new Passengers();
		ArrayList<Passengers> ps=p.addPassengers();
		
		Scanner sc = new Scanner(System.in);
		BaggageCheckIn bg=new BaggageCheckIn();
		/**This method will check weather passport id and fligth id is existing
		 * and redirect for baggage process.
		 */
		public void counterCheckIn() {
			System.out.println("Enter Passport Id: ");
			passportId=sc.nextInt();
			System.out.println("Enter Fligth Id: ");
			fligthNo=sc.next();
			
			for(int i=0;i<ps.size();i++) {
				if(passportId== ps.get(i).getPassportId() && fligthNo.equalsIgnoreCase(ft.get(i).getFligthNo())) {
					bg.baggageCheckIn();
				}
			}
		}
}
