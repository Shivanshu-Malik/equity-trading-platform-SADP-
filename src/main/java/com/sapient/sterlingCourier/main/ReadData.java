package com.sapient.sterlingCourier.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

import com.sapient.sterlingCourier.tester.CustomerTester;
import com.sapient.sterlingCourier.tester.DeliveryTester;
import com.sapient.sterlingCourier.tester.DistributionTester;
import com.sapient.sterlingCourier.tester.InvoiceTester;
import com.sapient.sterlingCourier.tester.OrderTester;

public class ReadData {

	/*
	 * public static int acceptString() { package
	 * com.sapient.sterlingCourier.main; Scanner sc = new Scanner(System.in);
	 * String choice; choice = sc.next(); System.out.println(
	 * "the choice entered is" + choice); sc.close(); return choice;
	 * 
	 * }
	 */

	/*public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CustomerTester customerTester = new CustomerTester();
		OrderTester orderTester = new OrderTester();
		DeliveryTester deliveryTester = new DeliveryTester();
		DistributionTester distributionTester = new DistributionTester();
		InvoiceTester invoiceTester = new InvoiceTester();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		char ch;

		do {
			System.out.println("=======================================");
			System.out.println("      Sterling Courier Company         ");
			System.out.println("=======================================");
			System.out.println("   1.	Customer Registration");
			System.out.println("   2.	Courier Order Booking");
			System.out.println("   3.	Courier Dispatch Responsibility Generation");
			System.out.println("   4.	Courier Delivery");
			System.out.println("   5.	Invoice Generation");
			System.out.println("   6.   Reports");
			System.out.println("   7.	Exit");
			System.out.println("   Enter your choice :");

			
			 * String choice = acceptString(); int value =
			 * Integer.parseInt(choice);
			 

			int value = in.nextInt();

			switch (value) {
			case 1:

				do {
					System.out.println("=======================================");
					System.out.println("      Customer Registration            ");
					System.out.println("=======================================");
					System.out.println("   1.	Add New Customer ");
					System.out.println("   2.	Check Customer Details ");
					System.out.println("   Enter your choice :");

					int val1 = in.nextInt();

					switch (val1) {
					case 1:
						String customerName;
						String address;
						String city;
						String pin;
						String telephoneNo;
						String emailId;

						System.out.println("Enter Customer Details");

						System.out.println("Enter Customer Name");
						customerName = in.next();

						System.out.println("Enter address");
						address = in.next();

						System.out.println("Enter city");
						city = in.next();
						System.out.println("Enter pin");
						pin = in.next();

						System.out.println("Enter telephone No.");
						telephoneNo = in.next();

						System.out.println("Enter emailId");
						emailId = in.next();

						System.out.println("Enter Registration Date(yyyy-MM-dd-hh.mm.ss)");
						String date = in.next();
						Date dateOfRegistration = null;
						try {
							// Parsing the String

							dateOfRegistration = new java.sql.Date(dateFormat.parse(date).getTime());
						} catch (ParseException e) {
							e.printStackTrace();
						}

						customerTester.readCustomerInfo(customerName, address, dateOfRegistration, city, pin,
								telephoneNo, emailId);

						break;

					case 2:
						int customerid;
						System.out.println("Enter Customer ID");
						customerid = in.nextInt();
						customerTester.getCustomerData(customerid);

					default:
						System.out.println("Enter a valid option (1-2)");
						break;
					}
					System.out.println("Do you wish to continue? (y/n)");

					ch = in.next().charAt(0);
					System.out.println(ch);

				} while (ch == 'y' || ch == 'Y');

				break;

			case 2:
				do {
					System.out.println("=======================================");
					System.out.println("      Courier Order Booking            ");
					System.out.println("=======================================");
					System.out.println("   1.	Create New Order ");
					System.out.println("   2.	Check Order Status ");
					System.out.println("   3.	Retrieve Orders Not Closed");
					System.out.println("   4.	Get Order Information ");

					System.out.println("   Enter your choice :");
					
					 * String choice = acceptString(); int value =
					 * Integer.parseInt(choice);
					 

					int val = in.nextInt();

					switch (val) {
					case 1:
						String recipientName;
						String recipientAddress;
						char recipientCity;
						float courierWeight;
						String description;
						int customerId;

						System.out.println("Enter Order Details");

						System.out.println("Enter Recipient Name");
						recipientName = in.next();

						System.out.println("Enter Recipient address");
						recipientAddress = in.next();

						System.out.println("Enter Recipient city (D, P, B, C) ");
						recipientCity = in.next().charAt(0);

						System.out.println("Enter Customer ID (>=1001)");
						customerId = in.nextInt();

						System.out.println("Enter Courier Weight (1-5 Kg)");
						courierWeight = in.nextFloat();

						System.out.println("Enter Description");
						description = in.next();

						System.out.println("Enter Date of Order(yyyy-MM-dd-hh.mm.ss)");
						String date1 = in.next();
						Date orderDate = null;
						try {
							// Parsing the String

							orderDate = new java.sql.Date(dateFormat.parse(date1).getTime());
						} catch (ParseException e) {
							e.printStackTrace();
						}

						try {
							orderTester.readOrderInfo(recipientName, recipientAddress, recipientCity, orderDate,
									courierWeight, description, customerId);
						} catch (SQLException e1) {

							e1.printStackTrace();
						}
						break;

					case 2:
						int orderID;
						System.out.println("Enter Order ID to check its status");
						orderID = in.nextInt();
						System.out.println(orderID);

						orderTester.checkOrderStatus(orderID);
						break;

					case 3:
						int employeeId;
						System.out.println("Enter Employee ID");
						employeeId = in.nextInt();
						orderTester.getOrdersNotClosed(employeeId);
						break;
					case 4:
						int orderId;
						System.out.println("Enter Order ID");
						orderId = in.nextInt();
						orderTester.getOrderInfo(orderId);
						break;

					default:
						System.out.println("Enter a valid option (1-4)");
						break;
					}
					System.out.println("Do you wish to continue? (y/n)");

					ch = in.next().charAt(0);
					System.out.println(ch);

				} while (ch == 'y' || ch == 'Y');
				break;

			case 3:

				System.out.println("Enter Distribution Date (yyyy-MM-dd-hh.mm.ss)");
				String date2 = in.next();
				Date dateOfDistribution = null;
				try {
					dateOfDistribution = new java.sql.Date(dateFormat.parse(date2).getTime());
				} catch (ParseException e) {

					e.printStackTrace();
				}

				distributionTester.readDistributionListInfo(dateOfDistribution);
				break;
			case 4:

				int orderId;
				String remarks;
				char status;

				System.out.println("Enter Delivery Details");

				System.out.println("Enter Order Id");
				orderId = in.nextInt();

				System.out.println("Enter Remarks");
				remarks = in.next();

				System.out.println("Enter status (P, R, D)");
				status = in.next().charAt(0);

				System.out.println("Enter Date of Delivery(yyyy-MM-dd-hh.mm.ss)");
				String date3 = in.next();
				Date deliveryDate = null;
				try {
					// Parsing the String
					deliveryDate = new java.sql.Date(dateFormat.parse(date3).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				deliveryTester.readDeliveryInfo(orderId, deliveryDate, remarks, status);

				break;
			case 5:
				int customerId;
				int invoiceMonth;
				int invoiceYear;
				String invoiceDescription;

				System.out.println("Enter Invoice Details");

				System.out.println("Enter Customer Id");
				customerId = in.nextInt();

				System.out.println("Enter Invoice Month");
				invoiceMonth = in.nextInt();

				System.out.println("Enter Invoice Year");
				invoiceYear = in.nextInt();

				System.out.println("Enter Description");
				invoiceDescription = in.next();

				invoiceTester.readInvoiceInfo(customerId, invoiceMonth, invoiceYear, invoiceDescription);

				break;

			case 6:
				do {
					System.out.println("=======================================");
					System.out.println("         REPORT GENERATION            ");
					System.out.println("=======================================");
					System.out.println("   1.	Check Status of Order ");
					System.out.println("   2.	Retrieve Orders with Status as Accepted or Pending");

					System.out.println("   Enter your choice :");

					int val = in.nextInt();

					switch (val) {
					case 1:
						int orderID;
						System.out.println("Enter Order ID to check its status");
						orderID = in.nextInt();
						System.out.println(orderID);

						orderTester.checkOrderStatus(orderID);
						break;

					case 2:
						orderTester.getListOfOpenOrders();

						break;

					default:
						System.out.println("Enter a valid option (1-2)");
						break;
					}
					System.out.println("Do you wish to continue? (y/n)");

					ch = in.next().charAt(0);
					System.out.println(ch);

				} while (ch == 'y' || ch == 'Y');
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid option (1-6)");
				break;
			}
			System.out.println("Do you wish to continue? (y/n)");

			ch = in.next().charAt(0);
			System.out.println(ch);

		} while (ch == 'y' || ch == 'Y');

		in.close();
	}*/
}
