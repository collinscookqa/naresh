package com.ece.com;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Home {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "www.thomascook.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    driver.get("http://ww1.thomascook.com/");
    
    String select=Keys.chord(Keys.TAB);
    driver.findElement(By.id("destinationDisplay")).clear();
    driver.findElement(By.id("destinationDisplay")).sendKeys("Canary Islands, Any");
    driver.findElement(By.id("srchWhereFrom")).clear();
    driver.findElement(By.id("srchWhereFrom")).sendKeys("Any London");
    driver.findElement(By.id("departureDate")).clear();
    driver.findElement(By.id("departureDate")).sendKeys("23-Oct-2014");
    driver.findElement(By.id("srchDuration")).click();
    new Select(driver.findElement(By.id("srchDuration"))).selectByVisibleText("7 Nights");
    driver.findElement(By.id("search-btn")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
