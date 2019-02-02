package com.wallethub.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.openqa.selenium.By;

public class HomePage extends PageBase{
	
	By Home_Rating_Options = By.xpath("//span[contains(@class,'wh-rating rating')]");
	By Rating4_Option = By.xpath("//div[contains(@class,'rating-choices-holder')]/a[text()='4']");
	By CloseAd = By.xpath("//span[contains(@class,'arrow down')]/i[contains(@class,'icon-cross')]");

	private void hoverHomeRatingAndClick(){
		mouseHover(Home_Rating_Options, Rating4_Option);
	}

	private void cloaseWHAd(){
		try {
			TimeUnit.SECONDS.sleep(5);
			waitTillElementVisible(CloseAd);
			waitUntilElementIsClickable(CloseAd);
			click(CloseAd);
		} catch (InterruptedException e) {
			s_logs.log(Level.ERROR, "Unable to close ad");
		}
	}
	////////////////Consolidate functions//////////////

	public void selectRatings(){
		cloaseWHAd();
		hoverHomeRatingAndClick();
//		waitTillElementVisible(Rating4_Option);
//		click(Rating4_Option);
	}
}