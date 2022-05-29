package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {



  protected WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }





  private void login(String username, String password) {
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  protected void newContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  protected void fillContactForm(ContactData contactData) {
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

  protected void submitNewContact() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void goToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  protected void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  protected void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  protected void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  protected void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  protected void goToGroupPage() {
    wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
  }


  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  protected void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  protected void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }


}
