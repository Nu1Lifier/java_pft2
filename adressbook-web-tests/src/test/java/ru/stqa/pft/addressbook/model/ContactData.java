package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String tel_home;
  private final String tel_mobile;
  private final String tel_work;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String tel_home, String tel_mobile, String tel_work, String fax, String email, String email2, String email3, String homepage) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.tel_home = tel_home;
    this.tel_mobile = tel_mobile;
    this.tel_work = tel_work;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getTel_home() {
    return tel_home;
  }

  public String getTel_mobile() {
    return tel_mobile;
  }

  public String getTel_work() {
    return tel_work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }
}
