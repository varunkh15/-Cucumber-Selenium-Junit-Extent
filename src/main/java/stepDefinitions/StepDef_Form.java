package stepDefinitions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import resources.base;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class StepDef_Form extends base
{
	public static Logger log =LogManager.getLogger(base.class.getName());
	List<String> listOfErrors = new ArrayList<>();
	@Given("^user navigates to MRA form page after login$")
	public void user_navigates_to_MRA_form_page_after_login() throws Exception 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		driver = initializeDriver(options);
		webDriverWait = explicitWait();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Login with crendetials");
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("login"))));
		driver.findElement(By.xpath(prop1.getProperty("login"))).click();
		driver.findElement(By.name(prop1.getProperty("UID"))).clear();
		driver.findElement(By.name(prop1.getProperty("UID"))).sendKeys(prop.getProperty("NRIC"));
		driver.findElement(By.name(prop1.getProperty("Name"))).clear();
		driver.findElement(By.name(prop1.getProperty("Name"))).sendKeys(prop.getProperty("Name"));
		driver.findElement(By.name(prop1.getProperty("UEN"))).clear();
		driver.findElement(By.name(prop1.getProperty("UEN"))).sendKeys(prop.getProperty("UEN"));
		driver.findElement(By.xpath(prop1.getProperty("login2"))).click();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("grant"))));
		driver.findElement(By.xpath(prop1.getProperty("grant"))).click();
		implicitWait();
		List<WebElement> weblist1=driver.findElements(By.xpath(prop1.getProperty("sector")));
		for(WebElement a1 : weblist1)
		{
			if(a1.getText().equals("IT"))
			{
				a1.click();
				break;
			}
		}
		List<WebElement> weblist2=driver.findElements(By.xpath(prop1.getProperty("sector")));
		for(WebElement a2 : weblist2)
		{
			if(a2.getText().equals(prop.getProperty("String1")))
			{
				a2.click();
				break;
			}}
		List<WebElement> weblist3=driver.findElements(By.xpath(prop1.getProperty("sector")));
		for(WebElement a3 : weblist3)
		{
			if(a3.getText().equals(prop.getProperty("String2")))
			{
				a3.click();
			}} 
		implicitWait();
		driver.findElement(By.xpath(prop1.getProperty("Apply"))).click();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("Proceed"))));
		driver.findElement(By.xpath(prop1.getProperty("Proceed"))).click(); 

	}
	@When("^user validates questions in the form$")
	public void user_validates_questions_in_the_form() throws Exception 
	{
		implicitWait();
		List<WebElement> weblist4=driver.findElements(By.xpath(prop1.getProperty("Questions")));
		if (!(weblist4.size() == 4)) 
		{
			log.error("Error in number of question");
			listOfErrors.add("Number of questions does not not matched with User Story \n");
		}
	}

	@And("^user answers no to any question$")
	public void user_answers_no_to_any_question() throws Throwable
	{
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("Radiobutton"))));
		List<WebElement> weblist5=driver.findElements(By.xpath(prop1.getProperty("Radiobutton")));
		for(WebElement a3 : weblist5)
		{
			if(a3.getText().equals("No"))
			{
				a3.click();			
			}
		}
	}
	@When("^user click on link in Warning message a new tab opens$")
	public void user_click_on_link_in_warning_message_a_new_tab_opens() throws Throwable
	{
		implicitWait();
		log.info("Click on Warning message");
		List<WebElement> weblist7 = driver.findElements(By.linkText(prop1.getProperty("FAQ")));
		weblist7.get(0).click();    	
	}
	@When("^user select the answer to each mandatory question$")
	public void he_select_the_answer_to_each_mandatory_question() throws Throwable
	{
		Wait();
		log.info("Ansering yes to all mandatory questions");
		List<WebElement> weblist5=driver.findElements(By.xpath(prop1.getProperty("Radiobutton")));
		for(WebElement a3 : weblist5)
		{
			if(a3.getText().equals("Yes"))
			{
				a3.click();			
			}
		} 

	}
	@Then("^user should get a warning message as expected$")
	public void user_should_get_a_warning_message_as_expected() throws Throwable
	{	
		log.info("Validating warning message");
		List<WebElement> weblist6 = driver.findElements(By.xpath(prop1.getProperty("Warning")));
		for(WebElement a4 : weblist6)
		{
			Assert.assertEquals(a4.getText(),prop.getProperty("String3")); 		
		}
	}
	@When("^user switch new tab and validates the URL$")
	public void user_switch_new_tab_and_validates_the_URL() throws Exception 
	{
		log.info("Switching to child tab");
		Set<String>ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		String ur =	driver.getCurrentUrl();
		driver.switchTo().window(childid);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url12"));
		driver.navigate().to(ur);
	}
	@And("^user validates the text of question which should be as expected$")
	public void user_validates_the_text_of_question_which_should_be_as_expected() throws Throwable
	{
		Wait();
		List<WebElement> weblist5=driver.findElements(By.xpath((prop1.getProperty("Questions1"))));
		if (!(prop.getProperty("FirstQ").equals(weblist5.get(0).getText()))) 
		{
			log.error("Question 1 does not match");
			listOfErrors.add(" The expected question-"+prop.getProperty("FirstQ")+"-does not matched with-  "+ weblist5.get(0).getText() + "\n");

		}
		if (!(prop.getProperty("SecondQ").equals(weblist5.get(1).getText()))) 
		{
			log.error("Question 2 does not match");
			listOfErrors.add(" The expected question- "+prop.getProperty("SecondQ")+" -does not not matched with actual question-  "+ weblist5.get(1).getText() + "\n");
		}
		if (!(prop.getProperty("ThirdQ").equals(weblist5.get(2).getText()))) 
		{
			log.error("Question 3 does not match");
			listOfErrors.add(" The expected question-"+prop.getProperty("ThirdQ")+"-does not matched with actual question-  "+ weblist5.get(2).getText() + "\n");
		}
		if (!(weblist5.get(3).getText().contains(prop.getProperty("FourthQ")))) 
		{
			log.error("Question 4 does not match");
			listOfErrors.add(" The expected question-"+prop.getProperty("FourthQ") +" -does not matched with actual question-  "+ weblist5.get(3).getText() + "\n");
		}
		if (!listOfErrors.isEmpty())
			Assert.fail(listOfErrors.toString());
	}
	@And("^user save the form after click on the button$")
	public void he_save_the_form_after_click_on_the_button() throws Throwable 
	{
		List<WebElement> weblist6 = driver.findElements(By.xpath(prop1.getProperty("Save")));
		if(weblist6.get(0).getText().equals("Save"));
		{
			weblist6.get(0).click();
		}
	}
	@And("^user refresh the page$")
	public void user_refresh_the_page() throws Exception
	{
		driver.navigate().refresh();
		driver.switchTo().alert().accept();
		Wait();
	}
	@And("^user close the browser$")
	public void user_close_the_browser() throws Throwable
	{
		driver.quit();
	}
	@When("^user navigates to contact details sections$")
	public void user_navigates_to_contact_details_sections_after_sign_in() throws Throwable 
	{
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("Contact"))));
		driver.findElement(By.xpath(prop1.getProperty("Contact"))).click();  		
	}
	@When("^user validates Main contact person subsection with inputs$")
	public void user_validates_main_contact_person_subsection_with_inputs() throws Throwable 
	{
		Wait();	
		log.info("Provides Main contact person details");
		driver.findElement(By.id(prop1.getProperty("Contactname"))).sendKeys(prop.getProperty("Name"));
		driver.findElement(By.id(prop1.getProperty("Designation"))).sendKeys(prop.getProperty("Designation"));
		driver.findElement(By.id((prop1.getProperty("Phone")))).sendKeys(prop.getProperty("Phone"));
		driver.findElement(By.id(prop1.getProperty("Email"))).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.id(prop1.getProperty("Email1"))).sendKeys(prop.getProperty("Alternate_Email"));
		driver.findElement(By.id(prop1.getProperty("Postcode"))).sendKeys(prop.getProperty("Postcode"));
		driver.findElement(By.id(prop1.getProperty("Postcode"))).sendKeys(Keys.TAB);
		Wait();	
		driver.findElement(By.id(prop1.getProperty("Level"))).sendKeys(prop.getProperty("Level"));
		driver.findElement(By.id(prop1.getProperty("Level"))).sendKeys(Keys.TAB,(prop.getProperty("Unit")));	
	}
	@And("^user checks that Block House No and Street details auto populates with Valid postal code$")
	public void user_checks_that_block_house_no_and_street_details_auto_populates_with_valid_postal_code() throws Throwable
	{
		log.info("Validating auto population for postal code");
		String block = driver.findElement(By.id(prop1.getProperty("Block"))).getAttribute("value");
		Assert.assertEquals(block, prop.getProperty("Block"));
		String street = driver.findElement(By.xpath(prop1.getProperty("Street"))).getAttribute("value");
		Assert.assertEquals(street, prop.getProperty("Street"));
	}
	@And("^on clicking checkbox Same as registered address in Company Profile user validates auto population of Mailing address$")
	public void on_clicking_checkbox_same_as_registered_address_in_company_profile_user_validates_auto_population_of_mailing_address() throws Throwable 
	{
		log.info("Validating auto population for Mailing Address");
		driver.findElement(By.xpath(prop1.getProperty("Address_checkbox"))).click();
		String block = driver.findElement(By.id(prop1.getProperty("Block"))).getAttribute("value");
		Assert.assertEquals(block, prop.getProperty("Block1"));
		String street = driver.findElement(By.xpath(prop1.getProperty("Street"))).getAttribute("value");
		Assert.assertEquals(street, prop.getProperty("Street1"));   	
		String level = driver.findElement(By.id(prop1.getProperty("Level"))).getAttribute("value");
		Assert.assertEquals(level, prop.getProperty("Level"));
		String unit = driver.findElement(By.id(prop1.getProperty("Unit"))).getAttribute("value");
		Assert.assertEquals(unit, prop.getProperty("Unit1"));
	}

	@And("^user validates Letter of Offer Addressee subsection with input$")
	public void user_validates_letter_of_offer_addressee_subsection_with_input() throws Throwable 
	{
		log.info("Validating Letter of Offer Address");
		driver.findElement(By.xpath(prop1.getProperty("Offer_Name"))).sendKeys(prop.getProperty("Offer_Name"));
		driver.findElement(By.xpath(prop1.getProperty("Offer_Designation"))).sendKeys(prop.getProperty("Offer_Designation"));
		driver.findElement(By.xpath(prop1.getProperty("Offer_Email"))).sendKeys(prop.getProperty("Offer_Email"));	
	}

	@And("^user validates option for same as main contact person with auto populate$")
	public void user_validates_option_for_same_as_main_contact_person_with_auto_populate() throws Throwable {
		log.info("Validating auto population for main contact person");
		driver.findElement(By.xpath(prop1.getProperty("Contact_checkbox"))).click();
		Wait();
		String name = driver.findElement(By.xpath(prop1.getProperty("Offer_Name"))).getAttribute("value");
		Assert.assertEquals(name, prop.getProperty("Name"));
		String designation = driver.findElement(By.xpath(prop1.getProperty("Offer_Designation"))).getAttribute("value");
		Assert.assertEquals(designation, prop.getProperty("Designation"));
		String email = driver.findElement(By.xpath(prop1.getProperty("Offer_Email"))).getAttribute("value");
		Assert.assertEquals(email, prop.getProperty("Email"));
	}
	@And("^user validate the reloaded values$")
	public void user_validate_the_reloaded_values() throws Throwable 
	{
		log.info("Validating reloaded values");

		Wait();
		String p1 = driver.findElement(By.id(prop1.getProperty("Contactname"))).getAttribute("value");
		Assert.assertEquals(p1,prop.getProperty("Name"));
		String p2 = driver.findElement(By.id(prop1.getProperty("Designation"))).getAttribute("value");
		Assert.assertEquals(p2,prop.getProperty("Designation"));
		String p3 = driver.findElement(By.id(prop1.getProperty("Phone"))).getAttribute("value");
		Assert.assertEquals(p3,prop.getProperty("Phone"));
		String p4 = driver.findElement(By.id(prop1.getProperty("Email"))).getAttribute("value");
		Assert.assertEquals(p4,prop.getProperty("Email"));
		String p5 = driver.findElement(By.id(prop1.getProperty("Email1"))).getAttribute("value");
		Assert.assertEquals(p5,prop.getProperty("Alternate_Email"));
		String p6 = driver.findElement(By.id(prop1.getProperty("Address2"))).getAttribute("value");
		Assert.assertTrue(p6.contains("CHOA CHU KANG CENTRAL"));
		String p7 = driver.findElement(By.xpath(prop1.getProperty("Offer_Name"))).getAttribute("value");
		Assert.assertEquals(p7,prop.getProperty("Name"));
		String p8 = driver.findElement(By.xpath(prop1.getProperty("Offer_Designation"))).getAttribute("value");
		Assert.assertEquals(p8,prop.getProperty("Designation"));
		String p9 = driver.findElement(By.xpath(prop1.getProperty("Offer_Email"))).getAttribute("value");
		Assert.assertEquals(p9,prop.getProperty("Email"));      	
	}
	@And("^user fills information in all section but leaves one mandatory information unfilled$")
	public void user_fills_information_in_all_section_but_leaves_one_mandatory_information_unfilled() throws Throwable
	{
		log.info("Giving mandatory details to other sections");
		driver.findElement(By.xpath(prop1.getProperty("Proposal"))).click(); 
		Wait();
		driver.findElement(By.id(prop1.getProperty("Project"))).sendKeys(prop.getProperty("Project"));
		driver.findElement(By.id(prop1.getProperty("StartDate"))).sendKeys(prop.getProperty("StartDate"));
		driver.findElement(By.id(prop1.getProperty("EndDate"))).sendKeys(prop.getProperty("EndDate"));
		driver.findElement(By.xpath(prop1.getProperty("ProjectDesc"))).sendKeys(prop.getProperty("ProjectDesc"),Keys.TAB,"Market Entry",Keys.RETURN,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,"Singapore",Keys.RETURN);
		Wait();
		driver.findElement(By.xpath(prop1.getProperty("RadioButton1"))).click();
		List<WebElement> weblist7 = driver.findElements(By.xpath(prop1.getProperty("Save")));
		weblist7.get(0).click();    	
		weblist7.get(1).click();		
		Wait();
		s1 = driver.getCurrentUrl();
		driver.findElement(By.xpath(prop1.getProperty("FY_EndDate"))).sendKeys(prop.getProperty("FY_EndDate"));
		driver.findElement(By.id(prop1.getProperty("Sales0"))).sendKeys(prop.getProperty("Sales0"));
		driver.findElement(By.id(prop1.getProperty("Sales1"))).sendKeys(prop.getProperty("Sales1"));
		driver.findElement(By.id(prop1.getProperty("Sales2"))).sendKeys(prop.getProperty("Sales2"));
		driver.findElement(By.id(prop1.getProperty("Sales3"))).sendKeys(prop.getProperty("Sales3"));  
		driver.findElement(By.id(prop1.getProperty("Investment0"))).sendKeys(prop.getProperty("Investment0"));
		driver.findElement(By.id(prop1.getProperty("Investment1"))).sendKeys(prop.getProperty("Investment1"));
		driver.findElement(By.id(prop1.getProperty("Investment2"))).sendKeys(prop.getProperty("Investment2"));
		driver.findElement(By.id(prop1.getProperty("Investment3"))).sendKeys(prop.getProperty("Investment3"));
		driver.findElement(By.id(prop1.getProperty("Remarks"))).sendKeys(prop.getProperty("Remarks"));
		List<WebElement> weblist8 = driver.findElements(By.xpath(prop1.getProperty("Save")));
		weblist8.get(0).click();    	
		weblist8.get(1).click();	
		Wait();
		driver.findElement(By.id(prop1.getProperty("Office_Rental"))).click();
		Wait();
		driver.findElement(By.xpath(prop1.getProperty("Add_Item"))).click();
		Wait(); 
		driver.findElement(By.id(prop1.getProperty("Rental_Description"))).sendKeys(prop.getProperty("Rental_Description"));
		driver.findElement(By.id(prop1.getProperty("Rental_Duration"))).sendKeys(prop.getProperty("Rental_Duration"));
		driver.findElement(By.id(prop1.getProperty("Amount1"))).sendKeys(prop.getProperty("Amount1"));
		List<WebElement> weblist9 = driver.findElements(By.xpath(prop1.getProperty("Save")));
		weblist9.get(0).click();    	
		weblist9.get(1).click();
		Wait();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton2"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton3"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton4"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton5"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton6"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton7"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton8"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton9"))).click();
		driver.findElement(By.xpath(prop1.getProperty("Radiobutton10"))).click();
		driver.findElement(By.id(prop1.getProperty("Acknowledgement"))).click();
	}
	@And("^user saves and click on Review after which user validates the error and validates the page redirected to$")
	public void user_saves_and_click_on_review_after_which_user_validates_the_error_and_validates_the_page_redirected_to() throws Throwable
	{
		log.info("Validating error message for mandatory field after review");
		List<WebElement> weblist10 = driver.findElements(By.xpath(prop1.getProperty("Save")));
		weblist10.get(0).click();    	
		weblist10.get(1).click();	
		Wait();
		implicitWait();
		WebElement we =	driver.findElement(By.xpath(prop1.getProperty("Error_mesg")));
		Assert.assertTrue(we.getText().contains("There are errors in your application."));
		Assert.assertTrue(we.getText().contains("Please rectify."));
		Assert.assertEquals(driver.getCurrentUrl(),s1);
	}
	@And("^user fills all mandatory details and click on Review button in Declare and Review section$")
	public void user_fills_all_mandatory_details_and_click_on_review_button_in_declare_and_review_section() throws Throwable
	{
		Wait();
		driver.findElement(By.id(prop1.getProperty("Benefits"))).sendKeys(prop.getProperty("Benefits"));
		List<WebElement> weblist4 = driver.findElements(By.xpath(prop1.getProperty("Save")));
		weblist4.get(0).click(); 
		driver.findElement(By.xpath(prop1.getProperty("Review"))).click(); 
		Wait();
		List<WebElement> weblist5 = driver.findElements(By.xpath(prop1.getProperty("Save")));
		weblist5.get(1).click(); 
	}
	@And("^user is navigated to read only summary page and he validates the page values$")
	public void user_is_navigated_to_read_only_summary_page_and_he_validates_the_page_values() throws Throwable
	{
		try
		{
		Wait();
		log.info("Validating read only summary page");
		String p13 = driver.findElement(By.id(prop1.getProperty("Eligibility1"))).getText();
		Assert.assertEquals(p13,prop.getProperty("Radiobutton3"));
		String p15 = driver.findElement(By.id(prop1.getProperty("Eligibility2"))).getText();
		Assert.assertEquals(p15,prop.getProperty("Radiobutton3"));
		String p16 = driver.findElement(By.id(prop1.getProperty("Eligibility3"))).getText();
		Assert.assertEquals(p16,prop.getProperty("Radiobutton3"));
		String p17 = driver.findElement(By.id(prop1.getProperty("Eligibility4"))).getText();
		Assert.assertEquals(p17,prop.getProperty("Radiobutton3"));
		String p18 = driver.findElement(By.id(prop1.getProperty("Eligibility5"))).getText();
		Assert.assertEquals(p18,prop.getProperty("Radiobutton3"));
		String p19 = driver.findElement(By.id(prop1.getProperty("Contactname"))).getText();
		Assert.assertEquals(p19,prop.getProperty("Name"));
		String p20 = driver.findElement(By.id(prop1.getProperty("Designation"))).getText();
		Assert.assertEquals(p20,prop.getProperty("Designation"));
		String p21 = driver.findElement(By.id(prop1.getProperty("Phone"))).getText();
		Assert.assertEquals(p21,prop.getProperty("Phone"));
		String p22 = driver.findElement(By.id(prop1.getProperty("Email"))).getText();
		Assert.assertEquals(p22,prop.getProperty("Email"));
		String p23 = driver.findElement(By.id(prop1.getProperty("Email1"))).getText();
		Assert.assertEquals(p23,prop.getProperty("Alternate_Email"));
		String p25 = driver.findElement(By.id(prop1.getProperty("Address1"))).getText();
		Assert.assertTrue(p25.contains("45 CHOA CHU KANG CENTRAL,"));
		Assert.assertTrue(p25.contains("#03-19,"));
		Assert.assertTrue(p25.contains("SINGAPORE 453123"));
		String p26 = driver.findElement(By.xpath(prop1.getProperty("Offer_Name1"))).getText();
		Assert.assertEquals(p26,prop.getProperty("Name"));
		String p27 = driver.findElement(By.xpath(prop1.getProperty("Offer_Designation1"))).getText();
		Assert.assertEquals(p27,prop.getProperty("Designation"));
		String p28 = driver.findElement(By.xpath(prop1.getProperty("Offer_Email1"))).getText();
		Assert.assertEquals(p28,prop.getProperty("Email"));
		String p29 = driver.findElement(By.id(prop1.getProperty("Project"))).getText();
		Assert.assertEquals(p29,prop.getProperty("Project"));
		String p30 = driver.findElement(By.id(prop1.getProperty("StartDate"))).getText();
		Assert.assertEquals(p30,prop.getProperty("StartDate"));
		String p31 = driver.findElement(By.id(prop1.getProperty("EndDate"))).getText();
		Assert.assertEquals(p31,prop.getProperty("EndDate"));
		String p32 = driver.findElement(By.id(prop1.getProperty("Duration"))).getText();
		Assert.assertEquals(p32,prop.getProperty("Duration"));
		String p33 = driver.findElement(By.id(prop1.getProperty("Description"))).getText();
		Assert.assertEquals(p33,prop.getProperty("Description"));
		String p34 = driver.findElement(By.id(prop1.getProperty("Project_Activity"))).getText();
		Assert.assertEquals(p34,prop.getProperty("Project_Activity"));
		String p35 = driver.findElement(By.id(prop1.getProperty("Project_type"))).getText();
		Assert.assertEquals(p35,"nil");
		String p36 = driver.findElement(By.id(prop1.getProperty("Share"))).getText();
		Assert.assertEquals(p36,prop.getProperty("Share"));
		String p37 = driver.findElement(By.id(prop1.getProperty("Market"))).getText();
		Assert.assertEquals(p37,prop.getProperty("Market"));
		String p38 = driver.findElement(By.id(prop1.getProperty("Expand"))).getText();
		Assert.assertEquals(p38,prop.getProperty("Radiobutton3"));
		String p39 = driver.findElement(By.id(prop1.getProperty("Sales0"))).getText();
		Assert.assertEquals(p39,prop.getProperty("Sales0"));
		String p40 = driver.findElement(By.id(prop1.getProperty("Sales1"))).getText();
		Assert.assertEquals(p40,prop.getProperty("Sales1"));
		String p41 = driver.findElement(By.id(prop1.getProperty("Sales2"))).getText();
		Assert.assertEquals(p41,prop.getProperty("Sales2"));
		String p42 = driver.findElement(By.id(prop1.getProperty("Sales3"))).getText();
		Assert.assertEquals(p42,prop.getProperty("Sales3"));
		String p43 = driver.findElement(By.id(prop1.getProperty("Investment0"))).getText();
		Assert.assertEquals(p43,prop.getProperty("Investment0"));
		String p44 = driver.findElement(By.id(prop1.getProperty("Investment1"))).getText();
		Assert.assertEquals(p44,prop.getProperty("Investment1"));
		String p45 = driver.findElement(By.id(prop1.getProperty("Investment2"))).getText();
		Assert.assertEquals(p45,prop.getProperty("Investment2"));
		String p46 = driver.findElement(By.id(prop1.getProperty("Investment3"))).getText();
		Assert.assertEquals(p46,prop.getProperty("Investment3"));
		String p47 = driver.findElement(By.id(prop1.getProperty("Remarks"))).getText();
		Assert.assertEquals(p47,prop.getProperty("Remarks"));
		String p48 = driver.findElement(By.id(prop1.getProperty("Benefits"))).getText();
		Assert.assertEquals(p48,prop.getProperty("Benefits"));
		String p49 = driver.findElement(By.xpath(prop1.getProperty("Cost"))).getText();
		Assert.assertEquals(p49,prop.getProperty("Cost"));
		String p50 = driver.findElement(By.xpath(prop1.getProperty("Description1"))).getText();
		Assert.assertEquals(p50,prop.getProperty("Description1"));
		String p64 = driver.findElement(By.xpath(prop1.getProperty("Duration1"))).getText();
		Assert.assertEquals(p64,prop.getProperty("Duration1"));
		String p51 = driver.findElement(By.xpath(prop1.getProperty("Billing_Rent"))).getText();
		Assert.assertEquals(p51,prop.getProperty("Rent"));
		String p52 = driver.findElement(By.id(prop1.getProperty("Monthly_Rent"))).getText();
		Assert.assertEquals(p52,prop.getProperty("Rent"));
		String p53 = driver.findElement(By.id(prop1.getProperty("Estimated"))).getText();
		Assert.assertEquals(p53,prop.getProperty("Estimated"));
		String p54 = driver.findElement(By.xpath(prop1.getProperty("Total"))).getText();
		Assert.assertEquals(p54,prop.getProperty("Total"));
		String p55 = driver.findElement(By.id(prop1.getProperty("Criminal"))).getText();
		Assert.assertEquals(p55,prop.getProperty("Criminal"));
		String p56 = driver.findElement(By.id(prop1.getProperty("Civil"))).getText();
		Assert.assertEquals(p56,prop.getProperty("Criminal")); 	
		String p57 = driver.findElement(By.id(prop1.getProperty("Insolvency"))).getText();
		Assert.assertEquals(p57,prop.getProperty("Criminal"));
		String p58 = driver.findElement(By.id(prop1.getProperty("Incentives"))).getText();
		Assert.assertEquals(p58,prop.getProperty("Criminal"));
		String p59 = driver.findElement(By.id(prop1.getProperty("Incentives1"))).getText();
		Assert.assertEquals(p59,prop.getProperty("Criminal"));
		String p60 = driver.findElement(By.id(prop1.getProperty("declaration"))).getText();
		Assert.assertEquals(p60,prop.getProperty("Criminal"));
		String p61 = driver.findElement(By.id(prop1.getProperty("Safe"))).getText();
		Assert.assertEquals(p61,prop.getProperty("Radiobutton3"));
		String p62 = driver.findElement(By.id(prop1.getProperty("Safe1"))).getText();
		Assert.assertEquals(p62,prop.getProperty("Radiobutton3"));
		String p63 = driver.findElement(By.id(prop1.getProperty("Acknowledge"))).getText();
		Assert.assertEquals(p63,prop.getProperty("Radiobutton3"));
		}
		catch(Exception e)
		{
			log.error("Exception occured in Read only summary page"+e.getMessage());
		}
	}
	@And("^user clicks on Consent and Acknowledgement checkbox and he gets a message of submission$")
	public void user_clicks_on_consent_and_acknowledgement_checkbox_and_he_gets_a_message_of_submission() throws Throwable 
	{
		driver.findElement(By.id(prop1.getProperty("Truthful"))).click();
		driver.findElement(By.id(prop1.getProperty("Submit"))).click(); 
		Wait();
		String p1 = driver.findElement(By.xpath(prop1.getProperty("Submit_Mesg"))).getText();
		Assert.assertEquals(prop.getProperty("Submit_Mesg"), p1);	    	
	}
	@And("^user validates the details in submission message like Ref Id,Status etc$")
	public void user_validates_the_details_in_submission_message_like_ref_idstatus_etc() throws Throwable
	{
		log.info("Validating details in submission message");
		Boolean b1 = driver.findElement(By.xpath(prop1.getProperty("RefId"))).isDisplayed();
		Assert.assertEquals(b1,"True");
		String p1 = driver.findElement(By.xpath(prop1.getProperty("Submitted"))).getText();
		Assert.assertEquals(p1,"Submitted");
		Boolean b2 = driver.findElement(By.xpath(prop1.getProperty("Date"))).isDisplayed();
		Assert.assertEquals(b2,"True");
		String p2 = driver.findElement(By.xpath(prop1.getProperty("Submitted"))).getText();
		Assert.assertEquals(p2,"Submitted");
		String p3 = driver.findElement(By.xpath(prop1.getProperty("Agency"))).getText();
		Assert.assertEquals(p3,"Enterprise Singapore");
	}

	@And("^user checks if his application is under Processing tab in Grants dashboard$")
	public void user_checks_if_his_application_is_under_processing_tab_in_grants_dashboard() throws Throwable
	{
		driver.navigate().to(prop.getProperty("Url1"));
		WebDriverWait w =new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop1.getProperty("grant"))));
		driver.findElement(By.xpath("//a[contains(text(),'Processing')]")).click();
		WebElement mytable = driver.findElement(By.xpath(prop1.getProperty("Table"))); 
		List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row = 0; row < rows_count; row++) 
		{
			List <WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);
			for (int column = 0; column < columns_count; column++)
			{
				String celtext = Columns_row.get(column).getText();
				System.out.println(celtext);
			}
		}
	}
}