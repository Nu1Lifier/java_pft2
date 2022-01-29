package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreation {
  private WebDriver driver;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/group.php");
    login("admin", "secret");

  }

  @Test
  public void testContactCreation() throws Exception {
    newContact();
    fillContactForm(new ContactData("namef", "nameM", "nameL", "nick", "title", "company", "address", "tel home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
    submitNewContact();
    goToHomePage();
    logout();
  }

  private void login(String username, String password) {
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  private void newContact() {
    driver.findElement(By.linkText("add new")).click();
  }

  private void fillContactForm(ContactData contactData) {
    driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    driver.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
    driver.findElement(By.name("company")).sendKeys(contactData.getCompany());
    driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
    driver.findElement(By.name("home")).sendKeys(contactData.getTel_home());
    driver.findElement(By.name("mobile")).sendKeys(contactData.getTel_mobile());
    driver.findElement(By.name("work")).sendKeys(contactData.getTel_work());
    driver.findElement(By.name("fax")).sendKeys(contactData.getFax());
    driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    driver.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    driver.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    driver.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
  }

  private void submitNewContact() {
    driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void goToHomePage() {
    driver.findElement(By.linkText("home page")).click();
  }

  private void logout() {
    driver.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
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
}
