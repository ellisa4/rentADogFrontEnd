package rentADog.ellis.frontEnd.v1.domain;

import java.sql.ResultSet;
import java.sql.*;
import rentADog.ellis.frontEnd.v1.drivers.sqlConnector;
import rentADog.ellis.frontEnd.v1.domain.Dog;

public class DogDatabase {
    private Connection conn;
    private sqlConnector sql;
    private Statement stmt;

    public DogDatabase()
    {
        sql = new sqlConnector();
        conn = sql.openConnection();

        try {
            stmt = conn.createStatement();
            stmt.executeQuery("USE spca;");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addDog(int idNumber, String name, String gender, String breed, int age)
    {
        String query = "INSERT INTO dogs VALUES ("
                + idNumber + ", "
                + age + ", "
                + "'" + gender + "', "
                + "'" +breed + "', "
                + "'" +name + "');";

        try
        {
            stmt.executeQuery(query);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void removeDog(int idNumber)
    {
        String query = "DELETE FROM dogs WHERE idNumber = " + idNumber + ";";

        try
        {
            stmt.executeQuery(query);
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Dog getDog(int idNumber)
    {
        Dog returnMe = null;
        String query = "SELECT * FROM dogs WHERE idNumber = " + idNumber + ";";

        try
        {
            ResultSet result = stmt.executeQuery(query);

            //.next moves to the next (in this case, first) result
            if(result.next())
            {
                //result.getX returns the variable matching the sql column
                //for example result.getInt"idNumber" searches for the column named "idNumber" in sql
                //then returns what idNumber holds
                int id = result.getInt("idNumber");
                int age = result.getInt("age");
                String gender = result.getString("gender");
                String breed = result.getString("breed");
                String name = result.getString("name");

                returnMe = new Dog(id, name, gender, breed, age);
            } else
            {
                System.out.println("No match found");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return returnMe;

    }

    /**
     * WILL ADD PERSONALITY TO FUTURE IMPLIMENTATIONS
     public void addPersonality(int idNumber, String trait)
     {
     int i=0;
     while(i<database.size())
     {
     if(database.get(i).getIdNumber()==idNumber)
     {
     database.get(i).addPersonality(trait);
     i=database.size();
     }
     ++i;
     }
     }

     public void deletePersonality(int idNumber, String trait)
     {
     int i=0;
     while(i<database.size())
     {
     if(database.get(i).getIdNumber()==idNumber)
     {
     int y=0;
     while (y<database.get(i).getPersonality().size())
     {
     if(database.get(i).getPersonality().get(y).equals(trait))
     {
     database.get(i).getPersonality().remove(y);
     y = database.get(i).getPersonality().size();
     }
     ++y;
     }
     i = database.size();
     }
     ++i;
     }
     }
     **/

    public String getBreed(int idNumber)
    {
        return getDog(idNumber).getBreed();
    }

    public int getAge(int idNumber)
    {
        return getDog(idNumber).getAge();
    }

    public String getName(int idNumber)
    {
        return getDog(idNumber).getName();
    }

    public String getGender(int idNumber)
    {
        return getDog(idNumber).getGender();
    }

}
