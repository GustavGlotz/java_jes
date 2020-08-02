package ru.jes.addressbook.tests;

import org.testng.annotations.*;
import ru.jes.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.gotoContactPage();
        app.fillContactForm(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        app.submitContactForm();
        app.gotoHomePage();
    }


}
