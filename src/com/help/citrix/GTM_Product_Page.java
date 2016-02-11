package com.help.citrix;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GTM_Product_Page {
	WebDriver driver;
	WebDriverWait wait;
	static int WAIT_TIME = 30;
	
	public GTM_Product_Page(WebDriver driver){
		this.driver = driver;
	
		
	}

	
	//define the product search component
	
	//define the article categories
	
	//define the community component
	
	//define the Live Training component
	
	//define the Contact Us component
	
	//Unity Nav -- Support For Other Products link
	@FindBy(how = How.CSS, using = "div [class='secondaryLinkSet link-group'] >ul>li[class='more expand']>a")
		WebElement suppOthProdsDropDownMenu;
	
		
	//define articles
	
	
	
	//method to click on the Unity Nav -- Support For Other Products Menu
	public void clickSuppOthProds(){
		System.out.println("Inside the clickSuppOthProds()");
		System.out.println("WebElement Text Attrib value: " + suppOthProdsDropDownMenu.getText());
		suppOthProdsDropDownMenu.click();
		
	}
	
	
	
	
}
