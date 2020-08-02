package ru.jes.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.gotoContactPage();
        app.fillContactForm(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        app.submitContactForm();
        app.gotoHomePage();
    }


}
