package com.sapient.sterlingCourier.tester;

import java.util.Calendar;
import java.sql.Date;

import com.sapient.sterlingCourier.dao.SterlingDAO;

public class DistributionTester {

	SterlingDAO sterlingDAO;
	Calendar date;

	public void readDistributionListInfo(Date dateOfDistribution) {
		sterlingDAO = new SterlingDAO();
		sterlingDAO.saveDistribution(dateOfDistribution);
		displayDistributionDate(dateOfDistribution);
	}

	public void displayDistributionDate(Date dateOfDistribution) {

		System.out.println("");
		System.out.println("  Courier Dispatch Responsibility Generation");
		System.out.println("----------------------------------------------------");
		System.out.println("Date Of Distribution             :" + dateOfDistribution);

	}
}

/*DateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy");//set to current date
Date todaysDate = Calendar.getInstance().getTime();
String date = simpleDateFormat.format(todaysDate);*/