package ru.jes.addressbook.tests;

import org.testng.annotations.*;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.selectContactDelete();
        app.confirmDeletion();

    }
}
