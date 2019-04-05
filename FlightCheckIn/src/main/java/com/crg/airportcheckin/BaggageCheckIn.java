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

import java.util.Scanner;

/**
* This class will check baggage weigth.If it exdent the baggage weigth the 
* passanger will be charged extra and given permission for boarding pass.
* @version1.8.0_201 17 MAR 2019
* @author Siddesh Mahajan
*/
public class BaggageCheckIn {
	Scanner sc=new Scanner(System.in);
	/**This method will check for baggage weigth and extra charges.
	 * Further it will proceed for boarding pass
	 */
	public void baggageCheckIn() {
		System.out.println("Enter Baggage Weigth: ");
		int baggageWeigth=sc.nextInt();
		if(baggageWeigth > 25) {
			System.out.println("Extra Charges Will Be Applied On Baggage..");
			System.out.println("1.Extra Charges Paid 2.Cancel The Baggage");
			int choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("Boarding Pass Has Been Generated..");
			}else {
				System.out.println("Extra Baggage Not Allowed..");
			}
			
		}else {
			System.out.println("Boarding Pass Has Been Generated..");
		}
	}
}
