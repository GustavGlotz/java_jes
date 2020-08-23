package ru.jes.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.jes.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Джордани").withLastname("Йованович").withEmail("BabaYaga@mail.com").withPhone("375291234567"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData deleteContact = before.iterator().next();
        app.contact().delete(deleteContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deleteContact);
        Assert.assertEquals(before, after);


    }

   
}
