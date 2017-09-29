package com.sapient.sterlingCourier.tester;

import java.sql.Date;

import com.sapient.sterlingCourier.dao.SterlingDAO;
import com.sapient.sterlingCourier.entity.Delivery;

public class DeliveryTester {
	Delivery delivery;
	SterlingDAO sterlingDAO;

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void readDeliveryInfo(int orderId, Date deliveryDate, String remarks, char status) {

		sterlingDAO = new SterlingDAO();
		delivery = new Delivery();
    	delivery.setDeliveryDate(deliveryDate);
		delivery.setOrderId(orderId);
		delivery.setRemarks(remarks);
		/*delivery.setStatus(status);
		delivery.setEmployeeID(1001);// hard-coded
*/	
		sterlingDAO.saveDelivery(delivery,status);
		displayDeliveryInfo(delivery);

	}

	public void displayDeliveryInfo(Delivery delivery) {

		System.out.println("");
		System.out.println("Courier Delivery");
		System.out.println("------------------------------------- ");
		//System.out.println("Employee Id		       :" + delivery.getEmployeeID());
		System.out.println("Assigned Courier�s             :2001, 2002, 2003");// hard-coded 
		System.out.println("Order Id                       :" + delivery.getOrderId());
		System.out.println("Date Of Delivery               :" + delivery.getDeliveryDate());
		//System.out.println("Status (P, R, D)               :" + delivery.getStatus());
		System.out.println("Remarks                	       :" + delivery.getRemarks());

	}

}
