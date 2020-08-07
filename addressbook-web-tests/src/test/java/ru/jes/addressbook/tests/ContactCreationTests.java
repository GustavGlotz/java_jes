package ru.jes.addressbook.tests;

import org.testng.annotations.*;
import ru.jes.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().addNewContact();
        app.getContactHelper().fillContactForm(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        app.getContactHelper().submitContactForm();
        app.getContactHelper().gotoHomePage();
    }


}
