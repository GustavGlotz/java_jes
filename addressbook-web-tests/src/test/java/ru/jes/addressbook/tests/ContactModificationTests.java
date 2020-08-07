package ru.jes.addressbook.tests;

import org.testng.annotations.Test;
import ru.jes.addressbook.appmanager.BaseHelper;
import ru.jes.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().ContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().gotoHomePage();
    }
}
