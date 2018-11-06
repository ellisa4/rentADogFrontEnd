package rentADog.ellis.frontEnd.v1.formHandling;

import java.util.ArrayList;

public class addDog {
    private ArrayList<String> personality;
    private int idNumber;
    private int age;
    private String gender;
    private String breed;
    private String name;

    public int getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(int id)
    {
        idNumber = id;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getBreed()
    {
        return breed;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

}
