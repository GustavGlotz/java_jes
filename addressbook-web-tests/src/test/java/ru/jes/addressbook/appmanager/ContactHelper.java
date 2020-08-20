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
    //коммит для задания №9

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    //коммит для задания №9
    public void gotoHomePage() {
        click(By.linkText("home page"));
    }
    //коммит для задания №9
    public void submitContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }
    //коммит для задания №9
    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("email"), contactData.getEmail());
        type(By.name("mobile"), contactData.getPhone());
    }        //коммит для задания №9

    public void addNewContact() {
        click(By.linkText("add new"));
    }     //коммит для задания №9

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }     //коммит для задания №9

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }        //коммит для задания №9

    public void ContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }         //коммит для задания №9

    public void submitContactModification() {
        click(By.xpath("//input[@name='update'][2]"));
    }       //коммит для задания №9

    //коммит для задания №9
    public void createContact(ContactData contact) {
        addNewContact();
        fillContactForm(contact);
        submitContactForm();
        gotoHomePage();
    }          //коммит для задания №9

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }        //коммит для задания №9

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }         //коммит для задания №9
    //коммит для задания №9
    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> line = wd.findElements(By.xpath("//tr[@name='entry']"));
        //коммит для задания №9
        for (WebElement element : line) {
            List<WebElement> cell = element.findElements(By.tagName("td"));
            String firstname = cell.get(2).getText();
            //коммит для задания №9
            String lastname = cell.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactData contact = new ContactData(id, firstname, lastname, null, null);
            //коммит для задания №9
            contacts.add(contact);
        }
        return contacts;
    }   //коммит для задания №9
}
