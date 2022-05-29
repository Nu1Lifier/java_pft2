package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private WebDriver wd;


  private GroupHelper groupHelper;

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    login("admin", "secret");
  }

  public void login(String username, String password) {
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void newContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("home")).sendKeys(contactData.getTel_home());
    wd.findElement(By.name("mobile")).sendKeys(contactData.getTel_mobile());
    wd.findElement(By.name("work")).sendKeys(contactData.getTel_work());
    wd.findElement(By.name("fax")).sendKeys(contactData.getFax());
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
    wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
    wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
  }

  public void submitNewContact() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void goToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void goToGroupPage() {
    wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
