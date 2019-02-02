package com.wallethub.pages;

import org.openqa.selenium.By;

public class ReviewPage extends PageBase {
	By Value_Dropdown = By.xpath("//span[@class='val']");
	By Health_Value = By.xpath("//ul[@class='drop-el']//a[@data-target='Health']");
	By Overall4_Rating = By.xpath("//a[contains(@class,'star-empty star bstar')]//span[text()='4']//parent::a");
	By Review_Content = By.xpath("//textarea[@id='review-content']");
	By submit_button = By.xpath("//input[@value='Submit'][@type='submit']");
	By Review_Confirmation = By.xpath("//div[@id='review']//span/a[contains(text(),'has been posted.')]");
	By User_Option = By.xpath("//nav[contains(@class,'loggedIn')]/a[@class='user']");
	By Profile_Tab = By.xpath("//nav[@id='m-user']/ul//a[text()='Profile']");
	By Loading_Image = By.xpath("//span[@class='loading-image']");

	
	///////////////consolidate functions//////////////////
	public void selectPolicy(String policy){
		waitTillElementVisible(Value_Dropdown);
		click(Value_Dropdown);
		click(By.xpath("//ul[@class='drop-el']//a[@data-target='"+policy+"']"));
		waitUntilElementInvisible(Loading_Image);
	}

	public void postReview(String message){
		click(Overall4_Rating);
		enter(Review_Content, message);
		click(submit_button);
	}
	
	public boolean getResult(){
		return isDisplayed(Review_Confirmation);
	}
	
	public void navigateToProfilePage(){
		click(User_Option);
		waitTillElementVisible(Profile_Tab);
		click(Profile_Tab);
	}
}
