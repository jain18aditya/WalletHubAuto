package com.wallethub.stepdefinition;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;

import com.wallethub.pages.HomePage;
import com.wallethub.pages.LoginPage;
import com.wallethub.pages.ProfilePage;
import com.wallethub.pages.ReviewPage;
import com.wallethub.utils.ConfigUtil;
import com.wallethub.utils.LoggerUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WHStep {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	ReviewPage reviewPage = new ReviewPage();
	ProfilePage profilePage = new ProfilePage();
	Logger s_logs = LoggerUtil.logger();

	@Given("^Launch browser with url \"([^\"]*)\"$")
	public void launchBrowser(String url) throws Throwable {
		loginPage.launchApplication(ConfigUtil.getProperty(url));
	}

	@When("^User log in with UserName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void logIn(String userName, String password) throws Throwable {
		loginPage.login(ConfigUtil.getProperty(userName), ConfigUtil.getProperty(password));
	}

	@Then("^select review ratings and Post review$")
	public void selectRatings() throws Throwable {
		homePage.selectRatings();
		reviewPage.selectPolicy("Health");
		reviewPage.postReview(ConfigUtil.getProperty("review.message"));
	}

	@Then("^validate if review posted successfully$")
	public void validateReviewConfirmation(){
		Assert.assertEquals("Review posting failed", true, reviewPage.getResult());		
	}

	@Then("^User navigates to profile page$")
	public void navigateToProfilePage(){
		reviewPage.navigateToProfilePage();		
	}

	@Then("^review should be posted in feeds section of profile page$")
	public void verifyReviewOnProfilePage(){
		Assert.assertEquals("Review not present on profile page", true, profilePage.getFeeds().contains(ConfigUtil.getProperty("review.message")));		
		s_logs.log(Level.INFO, "Your review is posted successfully");
	}
	
	@Then("^close the browser$")
	public void terminateBrowser() throws Throwable {
		loginPage.cleanUP();
	}
}
