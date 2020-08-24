package ru.jes.addressbook.tests;

import org.testng.annotations.Test;
import ru.jes.addressbook.model.ContactData;
import ru.jes.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        app.contact().addNewContact();
        ContactData contact = new ContactData().withFirstname("Джордани").withLastname("Йованович").withEmail("BabaYaga@mail.com").withPhone("375291234567");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }


}
