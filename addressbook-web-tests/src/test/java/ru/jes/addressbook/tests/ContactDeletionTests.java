package ru.jes.addressbook.tests;

import org.testng.annotations.*;
import ru.jes.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();

    }
}
