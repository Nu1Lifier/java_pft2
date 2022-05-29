package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().newContact();
    app.getContactHelper().fillContactForm(new ContactData("namef", "nameM", "nameL", "nick", "title", "company", "address", "tel home", "mobile", "work", "fax", "email", "email2", "email3", "homepage"));
    app.getContactHelper().submitNewContact();
    app.goToHomePage();
    app.logout();
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
//
//  }