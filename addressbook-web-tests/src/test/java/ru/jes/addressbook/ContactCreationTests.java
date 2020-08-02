package ru.jes.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        gotoContactPage();
        fillContactForm(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        submitContactForm();
        gotoHomePage();
    }


}
