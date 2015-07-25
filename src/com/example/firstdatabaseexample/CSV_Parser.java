package com.example.firstdatabaseexample;
import java.util.ArrayList;

public class CSV_Parser 
{
	
	
	public ArrayList<String> extractFromCommas(String dataLine) 
	{
		ArrayList<String> data = new ArrayList<String>();
		String theString = "";

		boolean doubleQuoteEnable=false;
		
		for (int i = 0; i < dataLine.length(); i++)
		 {
			
			if (dataLine.charAt(i) == '"')
			{
				if(!doubleQuoteEnable)
					doubleQuoteEnable=true;
				else
					doubleQuoteEnable=false;
			}
			if (dataLine.charAt(i) == ',' && !doubleQuoteEnable) //this means that the next comma has been reached
			{
				if (i == 0) {}
				else
				{
					data.add(theString);
					theString = "";		
				}
			} 
			else			
				theString = theString + dataLine.charAt(i);
			
		 }
		
		if (!theString.equalsIgnoreCase(""))//only if the last position is not occupied with nothing then add the end on
		{
			data.add(theString);
		}
		return data;
	}

}
