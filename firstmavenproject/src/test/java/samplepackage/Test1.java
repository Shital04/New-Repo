package  samplepackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Xls_Reader;

public class Test1 
{
	@Test(dataProvider="getdata")
	public void login(String username,String password)
	{
		
		System.setProperty("webdriver.chrome.driver", "F:\\Shital\\Set up\\chromedriver.exe");
		ChromeDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://newtours.demoaut.com/");
		dr.findElement(By.xpath("//Input[@name='userName']")).sendKeys(username);
		dr.findElement(By.xpath("//Input[@name='password']")).sendKeys(password);
		dr.findElement(By.xpath("//Input[@name='login']")).click();
		
		//verify next page is opened so verify one word from next page
		int count=dr.findElements(By.xpath("//b[contains(text(),'Passengers')]")).size();
		Assert.assertEquals(count, 1);
		
		}
	@DataProvider

	public String [][] getdata() throws IOException
	{
		Xls_Reader xl=new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\TestData1.xls");
		int rows=xl.getrowcount("Sheet2");
		int cols=xl.getColumncount("Sheet2");
		
		//3-account 2-fields are UN and Pw
		String [][] data=new String[rows-1][cols]; 
		/*
		//Row1
		data[0][0]="mercury";
		data[0][1]="mercury";
		
		//Row2
		data[1][0]="shital";
		data[1][1]="shital123";
		//row3
		data[2][0]="Sel_user1";
		data[2][1]="mercury";*/
		
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				data[r-2][c-1]=xl.getCellData("Sheet2",r,c);
			}
		}
		
		
		return data;
		
	}

}
