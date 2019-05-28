package samplepackage;

import java.io.IOException;

import utility.Xls_Reader;

public class Readdata {

	public static void main(String[] args) throws IOException 
	{
		Xls_Reader xl=new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\TestData1.xls");
		
		//user.dir--workspace path
		//System.out.println(System.getProperty("user.dir"));
		
		int rows=xl.getrowcount("Sheet2");
		int cols=xl.getColumncount("Sheet2");
		System.out.println("Rows="+ rows);
		System.out.println("columns="+cols);
		
		

	}

}
