package ru.jes.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jes.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void ContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@name='update'][2]"));
    }


    public void createContact(ContactData contact) {
        addNewContact();
        fillContactForm(contact);
        submitContactForm();
        gotoHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> line = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : line) {
            List<WebElement> cell = element.findElements(By.tagName("td"));
            String firstname = cell.get(2).getText();
            String lastname = cell.get(1).getText();
            String id = wd.findElement(By.tagName("table")).findElement(By.tagName("input")).getAttribute("id");
            ContactData contact = new ContactData(id, firstname, lastname, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
