package ru.jes.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jes.addressbook.model.ContactData;
import ru.jes.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("email"), contactData.getEmail());
        type(By.name("mobile"), contactData.getPhone());
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }


    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void ContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();

    }

    public void submitContactModification() {
        click(By.xpath("//input[@name='update'][2]"));
    }

    public void create(ContactData contact) {
        addNewContact();
        fillContactForm(contact);
        submitContactForm();
        contactCache = null;
        gotoHomePage();
    }

    public void modify(ContactData contact) {
        ContactModification(0);
        fillContactForm(contact);
        submitContactModification();
        contactCache = null;
        gotoHomePage();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> line = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : line) {
            List<WebElement> cell = element.findElements(By.tagName("td"));
            String firstname = cell.get(2).getText();
            String lastname = cell.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return new Contacts(contactCache);
    }


}

