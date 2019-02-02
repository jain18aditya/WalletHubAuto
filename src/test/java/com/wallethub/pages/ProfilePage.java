package com.wallethub.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class ProfilePage extends PageBase{
	By Feeds_Text = By.xpath("//div[@class='feed-content']/p[@class='feeddesc']");

	public List<String> getFeeds(){
		List<String> feeds = new ArrayList<String>();
		feeds = getTexts(Feeds_Text);
		return feeds;
	}
}
