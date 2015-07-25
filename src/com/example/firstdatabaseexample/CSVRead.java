package com.example.firstdatabaseexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVRead{

 public static void main(String[] arg) throws Exception {

  BufferedReader CSVFile = new BufferedReader(new FileReader("f:\\trekhunt Design and info\\dummy.csv"));
  

  String dataRow = CSVFile.readLine(); // Read first line.
  
  // The while checks to see if the data is null. If 
  // it is, we've hit the end of the file. If not, 
  // process the data.
  CSV_Parser parser = new CSV_Parser();
  ArrayList<String> data = new ArrayList<String>(); 
  while (dataRow != null){
   /*String[] dataArray = dataRow.split(",");
   for (String item:dataArray) { 
      System.out.print(item + "\t"); 
   }
   System.out.println(); // Print the data line.*/
   data = parser.extractFromCommas(dataRow);
   for(int i=0;i<data.size();i++)
   {
	   System.out.print(data.get(i)+"\t");
   }
   System.out.println();
   dataRow = CSVFile.readLine(); // Read next line of data.
  }
  // Close the file once all data has been read.
  CSVFile.close();

  // End the printout with a blank line.
  System.out.println();

 } //main()
} // CSVRead