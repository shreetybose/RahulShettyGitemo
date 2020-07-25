package TestScript;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DriverScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		driver.get("http://localhost:100");		
		driver.manage().window().maximize();
		
		//System.out.println(System.getProperty("user.dir"));
		
		//that below path is taken from test cases/test data- /src/TestCases/TestData.xlsx
		
		Xls_Reader xr=new Xls_Reader(System.getProperty("user.dir")+"/src/TestCases/TestData.xlsx");
		int rownum=xr.getRowCount("Sheet1");
		System.out.println(rownum);
		for(int i=2;i<=rownum;i++)
		{
			String vRun=xr.getCellData("Sheet1", "Run", i).trim();
			if(vRun.equalsIgnoreCase("ON"))
			{
				String vTCName=xr.getCellData("Sheet1", "TCName", i).trim();
				//System.out.println(vTCName);
				
				switch(vTCName)
				{
				case "vTiger_login_verifyAppUrl_TC001":
					String actualTitle=driver.getTitle().trim();
					String expectedTitle="vtiger CRM - Commercial Open Source CRM";
					if(actualTitle.equals(expectedTitle))
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");
						xr.setCellData("Sheet1", "ActualOutput", i, actualTitle);
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");
						xr.setCellData("Sheet1", "ActualOutput", i, actualTitle);
					}					
					break;
				case "vTiger_login_verifyAppTitle_TC002":
					String actualTitle1=driver.getTitle().trim();
					String expectedTitle1="vtiger CRM - Commercial Open Source CRM123";
					if(actualTitle1.equals(expectedTitle1))
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");
						xr.setCellData("Sheet1", "ActualOutput", i, actualTitle1);
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");
						xr.setCellData("Sheet1", "ActualOutput", i, actualTitle1);
					}	
					break;
				case "vTiger_login_verifyAppLogo_TC003":					
					if(driver.findElements(By.xpath("//img[@src='include/images/vtiger-crm1.gif']")).size()==1)
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_login_verifyText_KeyModule_TC004":					
					if(driver.findElement(By.xpath("//font[text()='Key Modules']")).isDisplayed())
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "Vtiger_login_verifyLink_vtigerCustomerPortal_TC05":					
					if(driver.findElement(By.linkText("vtiger Customer Portal")).isDisplayed())
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_login_verifyTextBoxEditble_TC006":	
					driver.findElement(By.name("user_name")).sendKeys("admin");
					String val=driver.findElement(By.name("user_name")).getAttribute("value");					
					if(val.equals("admin"))
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_login_verifywithInvalidCredentials_TC007":	
					driver.findElement(By.name("user_name")).clear();
					driver.findElement(By.name("user_name")).sendKeys("kuchbhi");
					driver.findElement(By.name("user_password")).sendKeys("Nachiket");
					driver.findElement(By.name("Login")).click();									
					if(driver.findElement(By.xpath("//td[contains(text(),'You must specify a valid username and password.')]")).isDisplayed())
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_login_verifywithValidCredentials_TC008":	
					driver.findElement(By.name("user_name")).clear();
					driver.findElement(By.name("user_name")).sendKeys("admin");
					driver.findElement(By.name("user_password")).clear();
					driver.findElement(By.name("user_password")).sendKeys("admin");
					driver.findElement(By.name("Login")).click();									
					if(driver.findElement(By.xpath("//a[@class='currentTab'][text()='Home']")).isDisplayed() && driver.findElement(By.linkText("Logout")).isDisplayed())
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_Leads_verifyLeadCreationMandatoryfields_TC09":	
					driver.findElement(By.linkText("New Lead")).click();
					driver.findElements(By.name("button")).get(0).click();
					
					Alert alt=driver.switchTo().alert();
					String errmsglastname=alt.getText().trim();
					System.out.println(errmsglastname);
					alt.accept();
					driver.findElement(By.name("lastname")).sendKeys("Modi");
					driver.findElements(By.name("button")).get(0).click();
					
					Alert alt1=driver.switchTo().alert();
					String errmsgcomp=alt1.getText().trim();
					System.out.println(errmsgcomp);
					alt1.accept();
					driver.findElement(By.name("company")).sendKeys("BJP");
					driver.findElements(By.name("button")).get(0).click();
					
					if(errmsglastname.equals("Last Name cannot be empty") && errmsgcomp.equals("Company cannot be empty"))
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_Leads_verifyLeadCreationData_TC10":					
					if((driver.findElements(By.xpath("//td[@class='moduleTitle'][text()='Lead:   Modi']")).size()==1) && (driver.findElements(By.xpath("//td[@class='dataLabel' and text()='Last Name:']/following::td[@class='dataField' and text()='Modi']")).size()==1) && (driver.findElements(By.xpath("//td[@class='dataLabel' and text()='Company:']/following::td[@class='dataField' and text()='BJP']")).size()==1))
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
					
				case "vTiger_Leads_DeleteCancellation_TC11":	
					driver.findElement(By.xpath("//input[@name='Delete']")).click();
					Alert alt2=driver.switchTo().alert();
					String deleteconfirmsg=alt2.getText().trim();
					System.out.println(deleteconfirmsg);
					alt2.dismiss();
					if((driver.findElements(By.xpath("//td[@class='moduleTitle'][text()='Lead:   Modi']")).size()==1) && (driver.findElements(By.xpath("//td[@class='dataLabel' and text()='Last Name:']/following::td[@class='dataField' and text()='Modi']")).size()==1) && (driver.findElements(By.xpath("//td[@class='dataLabel' and text()='Company:']/following::td[@class='dataField' and text()='BJP']")).size()==1) &&(deleteconfirmsg.equals("Are you sure you want to delete this record?")))
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
					
				case "vTiger_Leads_DeletedSuccessfully_TC12":	
					driver.findElement(By.xpath("//input[@name='Delete']")).click();
					Alert alt3=driver.switchTo().alert();
					alt3.accept();	
					Thread.sleep(5000);
					driver.findElements(By.name("lastname")).get(0).sendKeys("Modi");
					driver.findElements(By.name("company")).get(0).sendKeys("BJP");
					driver.findElements(By.name("button")).get(0).click();
					Thread.sleep(4000);					
					if(driver.findElement(By.xpath("//td[contains(text(),'Showing 0 - 0 of 0')]")).isDisplayed())
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_MouseActions_TC13":	
					Actions act=new Actions(driver);
					act.moveToElement(driver.findElement(By.id("showSubMenu"))).build().perform();
					Thread.sleep(3000);
					driver.findElement(By.linkText("New Vendor")).click();					
					if(driver.findElement(By.xpath("//td[text()='Vendor Name:']")).isDisplayed())
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_MouseActions_DragnDrop_TC14":	
					driver.findElement(By.linkText("My Account")).click();
					driver.findElement(By.name("Customise")).click();					
					Actions ac=new Actions(driver);
					WebElement source=driver.findElement(By.id("cl2"));
					WebElement target=driver.findElement(By.id("cl6"));
					ac.dragAndDrop(source, target).build().perform();					
					Thread.sleep(3000);									
					if(driver.findElement(By.xpath("//td[@id='cl6'][text()='Calendar']")).isDisplayed())
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
				case "vTiger_WindowHandlers_TC15":	
					driver.findElement(By.linkText("New Product")).click();
					driver.findElement(By.name("productname")).sendKeys("Product");	
					driver.findElements(By.xpath("//input[@title='Change']")).get(0).click();									
					Thread.sleep(5000);	
					
					Set<String> set=driver.getWindowHandles();
					Iterator<String> iter=set.iterator();
					String firstWindow=iter.next();
					System.out.println(firstWindow);
					String SecondWindow=iter.next();
					System.out.println(SecondWindow);
					
					driver.switchTo().window(SecondWindow);					
					driver.findElement(By.linkText("Mary Smith")).click();
					driver.switchTo().window(firstWindow);
					driver.findElement(By.name("productcode")).sendKeys("P007");
					
					String Contactval=driver.findElement(By.name("contact_name")).getAttribute("value");		
					
					if(Contactval.equals("Mary Smith"))
					{
						System.out.println(vTCName + "= PASSED");
						xr.setCellData("Sheet1", "Status", i, "PASSED");							
					}
					else
					{
						System.out.println(vTCName + "= FAILED");
						xr.setCellData("Sheet1", "Status", i, "FAILED");						
					}	
					break;
					
				/*	
					 //for drop down
					WebElement elm=driver.findElement(By.name("login_theme"));
					Select sel=new Select(elm);
					//2 ways i can try either by using the WebElement
					Select sel1=new Select(driver.findElement(By.name("login_theme")));
					sel1.selectByIndex(2);
					sel1.selectByValue("Aqua");
					sel1.selectByVisibleText("orange"); */
				}
			}
		}
		
		
	driver.close();
	driver.quit();

	}

}
