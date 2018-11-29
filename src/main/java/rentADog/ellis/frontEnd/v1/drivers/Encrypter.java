package rentADog.ellis.frontEnd.v1.drivers;

public class Encrypter {	
	public String encrypt(String id)
	{
		String idLetters = "";
		long idNums = 0;

		if(id.substring(0, 1).matches(".*[a-zA-Z]+.*"))
		{//this tests if the first item is a letter
			//make idLetters = letters of the id
			//make idNums = numbers of the id
			for(int i =0; i < id.length(); ++i)
			{
				String c = id.substring(i,i+1);
				
				if("1234567890".contains(c))
				{//you hit the first number and got all the chars
					i=id.length();
				} else
				{//you got another char
					idLetters += c;
				}
			}
			idNums = Long.parseLong( id.substring( idLetters.length() ) );
		} else
		{//there are no numbers in the id
			idNums = Long.parseLong(id);
		}
		
		/**
		 * By now:
		 * id was split longo a number and longerger(s)
		 * idNum = numbers
		 * idLetters = the starting chars of ids
		 **/
		
		long randomMultiplier = (long)(Math.random()*900)+100; //generate a random 3 digit number
		
		//idNums *= randomMultiplier;
		long temp = idNums * randomMultiplier;
		while(temp<0)
		{
			randomMultiplier = (long)(Math.random()*900)+100; //generate a random 3 digit number
			temp = idNums * randomMultiplier;
		}
		idNums = temp;
		
		return idLetters + idNums + randomMultiplier;
	}
	
	public String decrypt(String id)
	{
		String idLetters = "";
		long idNums = 0;

		if(id.substring(0, 1).matches(".*[a-zA-Z]+.*"))
		{//this tests if the first item is a letter
			//make idLetters = letters of the id
			//make idNums = numbers of the id
			for(int i =0; i < id.length(); ++i)
			{
				String c = id.substring(i,i+1);
				
				if("1234567890".contains(c))
				{//you hit the first number and got all the chars
					i=id.length();
				} else
				{//you got another char
					idLetters += c;
				}
			}
			idNums = Long.parseLong( id.substring( idLetters.length() ) );
		} else
		{//there are no numbers in the id
			idNums = Long.parseLong(id);
		}
		
		/**
		 * By now:
		 * id was split long a number and longerger(s)
		 * idNum = numbers
		 * idLetters = the starting chars of ids
		 **/
		
		long[] splitableId={0,0}; 
		String temp = "" + idNums;

		splitableId[0] = Long.parseLong( temp.substring( 0, temp.length()-3 ) );
		splitableId[1] = Long.parseLong( temp.substring(temp.length()-3) );
		
		idNums = splitableId[0] / splitableId[1];
		
		
		
		return idLetters + idNums;
	}
}
