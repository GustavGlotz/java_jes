package ru.jes.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.jes.addressbook.model.ContactData;

public class ContactHelper {

    public WebDriver wd;

    public ContactHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void gotoHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void submitContactForm() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
    }

    public void gotoContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void selectContactDelete() {
        wd.findElement(By.id("19")).click();
    }

    public void confirmDeletion() {
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }
}
