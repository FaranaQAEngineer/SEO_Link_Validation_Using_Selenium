package test1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SEOTestingprogram {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		
		//404 error found - broken link 
		//200 to 399 - valid link
		//200 is valid response code 
		
		HttpURLConnection htp=null;
		//HttpURLConnection is predefined class from java.net package 
		//it is used to generate the response code of URL of the website 
		String testurl="";
		String homeurl="https://biodataking.com/";
		
	//	https://biodataking.com/  - 200
	//	https://biodataking.com/signup - 200

		WebDriver d=new ChromeDriver();
		d.get(homeurl);
		Thread.sleep(2000);
		//a means anchor tag 
		//anchor tag is tagname used for buttons and links 
		List<WebElement> sel=d.findElements(By.tagName("a"));
		
		//Here we are storing all the URLs in the List through the anchor tag (a)
		
		Iterator<WebElement> iter= sel.iterator();
		//Iterator is predefined Interface from java.util package 
		//it is used to execute all the URLs data from the List 
		
		while(iter.hasNext()) //hasNext is predefined method of Iterator used to check 
		{	                  //whether iterator have data for not
		
			testurl=iter.next().getAttribute("href");
			
			//only those URL will get stored inside the testurl variable which is having
			//href attribute in html (a) tag
			
			//1.Whether that URL is having anchor tag or not 
			//2.Domain Testing 
			//3.Broken/Valid Links test 
			
			
			//Anchor tag test
			if(testurl==null || testurl.isEmpty())
			{
				System.out.println(testurl+" anchor tag is not given");
				continue;
			}
			
			
			//domain testing - if else
			
	//		https://biodataking.com - main domain of website 
	//		https://biodataking.com/marriage-bureau - valid domain
	//		https://marriage-bureau.biodataking.com // invalid domain 
			//! - not 
			
			if(!testurl.startsWith(homeurl))
			{
				System.out.println(testurl+" is not having correct domain");
			}
			
			
			
			//broken/valid link - if else 
			
			htp=(HttpURLConnection)(new URL(testurl)).openConnection();
			
		//	1.We connected HttpURLconnection with the URL which is predefined method
			  //URL is used to help to generate the response code 
		//	2.Then we had given openConnection predefined method 
			//openConnection method is used to open the connection between HttpURLConnection and URL
		//	3.Mouse hover on red line and click on  "add throws declaration" link
			
			htp.setRequestMethod("HEAD");//
			htp.connect();
		int res= htp.getResponseCode();
			
			if(res>=400)
			{
				System.out.println(testurl+" is broken link");
			}
			else
			{
				System.out.println(testurl+" is valid link");
			}
			
		}
		
		
		
		
		
	}

}
