package rentADog.ellis.frontEnd.v1.domain;

import java.util.Calendar;

public class Client {
	private String firstName;
	private String lastName;
	private int yearBorn;
	private int monthBorn;
	private int dayBorn;
	private int age;
	private String licenseNum;
	private String street;
	private String city;
	private String state;
	private int zipCode;

	public Client(String firstName, String lastName, int monthBorn, int dayBorn, int yearBorn, String licenseNum, String street, String city, String state, int zipCode)
	{
		this.firstName=firstName.toLowerCase();
		this.lastName=lastName.toLowerCase();
		this.dayBorn=dayBorn;
		this.yearBorn=yearBorn;
		this.monthBorn=monthBorn;
		this.age=setAge(monthBorn, dayBorn, yearBorn);
		this.licenseNum=licenseNum.toLowerCase();
		this.street=street.toLowerCase();
		this.city=city.toLowerCase();
		this.state=state.toLowerCase();
		this.zipCode=zipCode;
	}
	
	private int setAge(int month, int day, int year)
	{
		String age = "";
		String currentDay = "";
		currentDay = currentDay + Calendar.getInstance().get(Calendar.YEAR);

		//01 , 02, 03, etc. do not exist in integers so January would be 1 instead of 01
		//using String instead of int to preserve 0s
		if(Calendar.getInstance().get(Calendar.MONTH) < 10)
		{
			currentDay = currentDay + "0" + Calendar.getInstance().get(Calendar.MONTH);
		} else 
		{
			currentDay = currentDay + Calendar.getInstance().get(Calendar.MONTH);
		}
		
		if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < 10)
		{
			currentDay = currentDay + "0" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		} else 
		{
			currentDay = currentDay + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		}
		
		
		String birthday = "" + year;
		if(month < 10)
		{
			birthday = birthday + "0" + month;
		} else
		{
			birthday = birthday + month;
		}
		
		if(day < 10)
		{
			birthday = birthday + "0" + day;
		} else
		{
			birthday = birthday + day;
		}
		
		int currentT = Integer.parseInt(currentDay);
		int birthT = Integer.parseInt(birthday);

		//age is a 6 digit number where 
		age = "" + (currentT - birthT);
		
		return Integer.parseInt(age.substring(0,2));
	}
	public int getyearBorn()
	{
		return yearBorn;
	}
	
	public int getMonthBorn()
	{
		return monthBorn;
	}
	
	public int getDayBorn()
	{
		return dayBorn;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getLicense()
	{
		return licenseNum;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public int getZipCode()
	{
		return zipCode;
	}
}
