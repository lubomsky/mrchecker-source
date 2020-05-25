package com.capgemini.mrchecker.selenium.core.tests.webElements;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.selenium.core.enums.PageSubURLsEnum;
import com.capgemini.mrchecker.selenium.core.newDrivers.elementType.NavigationBarElement;
import com.capgemini.mrchecker.test.core.BaseTest;

/**
 * Created by LKURZAJ on 07.03.2017.
 */
@Disabled
public class NavigationBarTest extends BaseTest {
	private NavigationBarElement	navigationBarElement;
	private final static By			navigationBarSelector	= By.cssSelector("ol#breadcrumbs");
	private final static By			childsSelector			= By.cssSelector("li");
	
	@AfterAll
	public static void tearDownAll() {
		
	}
	
	@Test
	public void testGets() {
		assertEquals("Home", this.navigationBarElement.getFirstItemText());
		assertEquals("Tabs", this.navigationBarElement.getActiveItemText());
	}
	
	@Test
	public void testClickByIndex() {
		this.navigationBarElement.clickItemByIndex(1);
		assertEquals("Tabs", this.navigationBarElement.getActiveItemText());
	}
	
	@Test
	public void testClickByText() {
		this.navigationBarElement.clickItemByText("Home");
		assertEquals("Home", this.navigationBarElement.getActiveItemText());
	}
	
	@Test
	public void testClickActiveItem() {
		String url = BasePage.getDriver()
				.getCurrentUrl();
		this.navigationBarElement.clickActiveItem();
		assertEquals(url, BasePage.getDriver()
				.getCurrentUrl());
	}
	
	@Test
	public void testClickFirstItem() {
		this.navigationBarElement.clickFirstItem();
		assertEquals(1, this.navigationBarElement.getDepth());
	}
	
	@Test
	public void testConstructor() {
		NavigationBarElement navBarElem = BasePage.getDriver()
				.elementNavigationBar(NavigationBarTest.navigationBarSelector, NavigationBarTest.childsSelector);
		assertEquals(Arrays.asList("Home", "Tabs"), navBarElem.getItemsTextList());
	}
	
	@Override
	public void setUp() {
		BasePage.getDriver()
				.get(PageSubURLsEnum.WWW_FONT_URL.subURL() + PageSubURLsEnum.TABS.subURL());
		this.navigationBarElement = BasePage.getDriver()
				.elementNavigationBar(NavigationBarTest.navigationBarSelector);
	}
	
	@Override
	public void tearDown() {
		
	}
}
