package basepages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPageObject extends PageClasses{
	
	@FindBy(xpath = "//*[@id='contact_form_fname']")
	WebElement FirstName;
  	
	
	@FindBy(xpath = "//*[@id='contact_form_lname']")
	WebElement LastName;
	
	@FindBy(xpath = "//*[@id='contact_form_email']")
	WebElement Email;
	
	@FindBy(xpath = "//*[@id='contact_form_phone']")
	WebElement Phone;
	
	@FindBy(xpath = "//*[@id='contact_form_company']")
	WebElement CompanyName;
	
	@FindBy(xpath = "//*[@id='contact_form_enquiry']")
	WebElement Message;
	
	@FindBy(xpath = "//*[@id='contact_form_submit']")
	WebElement Send;
	
	
	
	
    public ContactUsPageObject(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
    public void Tell_Us_About_Your_Project() throws InterruptedException
	{
    	FirstName.sendKeys("Nitin");
    	LastName.sendKeys("Nitin");
    	Email.sendKeys("Nitin@arkenea.com");
    	Phone.sendKeys("9503193642");    	
    	CompanyName.sendKeys("arkenea");
    	Message.sendKeys("connect with me tommorow");
    	
    	
    	;
	}
    
    public void fillForm() throws InterruptedException, IOException {
    	
    	 // 2. Read Excel File
        FileInputStream fis = new FileInputStream("C:/Users/Admin/Desktop/contact.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int totalRows = sheet.getPhysicalNumberOfRows();

        // 3. Loop for first 5 rows (skip header at row 0)
        for (int i = 3; i <= 8 && i < totalRows; i++) {
        	
            XSSFRow row = sheet.getRow(i);
            String fname   = row.getCell(0).toString();
            String lname   = row.getCell(1).toString();
            String email   = row.getCell(2).toString();
            String phone   = row.getCell(3).toString();
            String company = row.getCell(4).toString();
            String message = row.getCell(5).toString();

            
            driver.get("https://arkenea.com/contact-us/");
            
            Thread.sleep(5000);
            // Fill Form
            FirstName.sendKeys(fname);
  
            LastName.sendKeys(lname);
         
            Email.sendKeys(email);
          
            Phone.sendKeys(phone);
      
            CompanyName.sendKeys(company);
           
            Message.sendKeys(message);
   
           

            System.out.println("✅ Submitted form for Row " + i + ": " + fname + " " + lname);

            // Small wait so you can see it happen
            Send.click();
            
            
            Thread.sleep(5000);
            
        }

        

        
    }
    
}
