package ru.jes.addressbook.tests;

import org.testng.annotations.Test;
import ru.jes.addressbook.appmanager.BaseHelper;
import ru.jes.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getContactHelper().selectContactDelete();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().gotoHomePage();
    }
}