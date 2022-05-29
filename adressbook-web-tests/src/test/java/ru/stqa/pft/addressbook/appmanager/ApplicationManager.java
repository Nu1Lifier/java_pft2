package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final GroupHelper groupHelper = new GroupHelper();

  public boolean isAlertPresent() {
    try {
      groupHelper.wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    groupHelper.wd = new FirefoxDriver();
    groupHelper.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    groupHelper.wd.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  public void login(String username, String password) {
    groupHelper.wd.findElement(By.name("user")).sendKeys(username);
    groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
    groupHelper.wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void newContact() {
    groupHelper.wd.findElement(By.linkText("add new")).click();
  }

  public void fillContactForm(ContactData contactData) {
    groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    groupHelper.wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    groupHelper.wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    groupHelper.wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    groupHelper.wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    groupHelper.wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    groupHelper.wd.findElement(By.name("home")).sendKeys(contactData.getTel_home());
    groupHelper.wd.findElement(By.name("mobile")).sendKeys(contactData.getTel_mobile());
    groupHelper.wd.findElement(By.name("work")).sendKeys(contactData.getTel_work());
    groupHelper.wd.findElement(By.name("fax")).sendKeys(contactData.getFax());
    groupHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    groupHelper.wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    groupHelper.wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    groupHelper.wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
  }

  public void submitNewContact() {
    groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void goToHomePage() {
    groupHelper.wd.findElement(By.linkText("home page")).click();
  }

  public void logout() {
    groupHelper.wd.findElement(By.linkText("Logout")).click();
  }

  public void goToGroupPage() {
    groupHelper.wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
  }

  public void stop() {
    groupHelper.wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
