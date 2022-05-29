package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    newContact();
    fillContactForm(new ContactData("namef", "nameM", "nameL", "nick", "title", "company", "address", "tel home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
    submitNewContact();
    goToHomePage();
    logout();
  }
}



//  private boolean isElementPresent(By by) {
//    try {
//      wd.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      wd.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }