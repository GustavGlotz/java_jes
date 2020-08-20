package ru.jes.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jes.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    //коммит для задания №9
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Джордани", "Йованович", "BabaYaga@mail.com", "375291234567"));
        }
        //коммит для задания №9
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().ContactModification();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Джордани", "Йованович", "BabaYaga@mail.com", "375291234567");
        //коммит для задания №9
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().gotoHomePage();
        //коммит для задания №9
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        //коммит для задания №9
        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        //коммит для задания №9
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
