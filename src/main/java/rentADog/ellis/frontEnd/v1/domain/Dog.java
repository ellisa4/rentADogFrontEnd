package rentADog.ellis.frontEnd.v1.domain;


import java.util.ArrayList;

public class Dog {
    private ArrayList<String> personality;
    private int idNumber;
    private int age;
    private String gender;
    private String breed;
    private String name;

    public Dog(int idNumber, String name, String gender, String breed, int age)
    {
        personality= new ArrayList<String>();
        this.idNumber = idNumber;
        this.age=age;
        this.gender=gender.toLowerCase();
        this.breed=breed.toLowerCase();
        this.name=name.toLowerCase();
    }

    public int getIdNumber()
    {
        return idNumber;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public ArrayList<String> getPersonality()
    {
        return personality;
    }

    public void addPersonality(String trait)
    {
        personality.add(trait.toLowerCase());
    }

    public void removePersonality(String trait)
    {
        int i=0;
        while(i < personality.size())
        {
            if(trait.toLowerCase()==personality.get(i))
            {
                personality.remove(i);
                i=personality.size(); //break loop
            }
            i++;
        }
    }

    public String getGender()
    {
        return gender;
    }

    public String getBreed()
    {
        return breed;
    }

    public String toString()
    {
        return "" +
                getIdNumber() + ", "
                + getAge() + ", "
                + getGender() + ", "
                + getBreed() + ", "
                + getName();
    }

}
