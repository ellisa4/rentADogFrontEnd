package rentADog.ellis.frontEnd.v1.domain;

import rentADog.ellis.frontEnd.v1.drivers.Encrypter;
import rentADog.ellis.frontEnd.v1.drivers.sqlConnector;
import rentADog.ellis.frontEnd.v1.domain.Client;

import java.sql.*;

public class ClientDatabase {
	private sqlConnector sql;
	private Connection conn;
	private Statement stmt;
	private Encrypter encrypter;
	
	public ClientDatabase()
	{
		sql = new sqlConnector();
		conn = sql.openConnection();
		encrypter = new Encrypter();
		
		try
		{
			//use the spca database
			stmt = conn.createStatement();
			stmt.executeQuery("USE spca;");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addClient(String firstName, String lastName, int monthBorn, int dayBorn, int yearBorn, String licenseNum, String street, String city, String state, int zipCode)
	{
		int age = new Client(firstName, lastName, monthBorn, dayBorn, yearBorn, licenseNum, street, city, state, zipCode).getAge();
		int id = (int) ((Math.random()*900000)+100000);
		
		//query will be to find the unique id
		String query = "SELECT * FROM clients WHERE id = " + id + ";";
		
		try
		{
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				id = (int) ((Math.random()*900000)+100000);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		
		//change query to the insert
		query = "INSERT INTO clients VALUES ("
				+ id + ","
				+ "'" + firstName.toLowerCase() + "',"
				+ "'" + lastName.toLowerCase() + "',"
				+ monthBorn + ","
				+ dayBorn + ","
				+ yearBorn + ","
				+ age + ","
				+ "'" + encrypter.encrypt(licenseNum) + "',"
				+ "'" + street.toLowerCase() + "',"
				+ "'" + city.toLowerCase() + "',"
				+ "'" + state.toLowerCase() +"',"
				+ zipCode + ");";

		try
		{
			stmt.executeQuery(query);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Client getClient(int id)
	{
		Client returnMe = null;
		try
		{
			String query = "SELECT * FROM clients WHERE id = " + id +";";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				returnMe = new Client(
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getInt("dayBorn"),
						rs.getInt("monthBorn"),
						rs.getInt("yearBorn"),
						encrypter.decrypt(rs.getString("licenseNum")),
						rs.getString("street"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("zipcode")
						);
			} else
			{
				System.out.println("No user found");
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return returnMe;
	}
	
	public String getFirstName(int id)
	{
		return getClient(id).getFirstName();
	}
	
	public String getLastName(int id)
	{
		return getClient(id).getLastName();
	}
	
	public int getMonthBorn(int id)
	{
		return getClient(id).getMonthBorn();
	}
	
	public int getDayBorn(int id)
	{
		return getClient(id).getDayBorn();
	}
	
	public int getAge(int id)
	{
		return getClient(id).getAge();
	}
	
	public String getLicenseNumber(int id)
	{
		return getClient(id).getLicense();
	}
	
	public String getStreet(int id)
	{
		return getClient(id).getStreet();
	}
	
	public String getCity(int id)
	{
		return getClient(id).getCity();
	}
	
	public String getState(int id)
	{
		return getClient(id).getState();
	}
	
	public int getZipCode(int id)
	{
		return getClient(id).getZipCode();
	}
	
}
