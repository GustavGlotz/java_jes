package ru.jes.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jes.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {
    //коммит для задания №9

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        //коммит для задания №9
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        //коммит для задания №9
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        //коммит для задания №9
        GroupData group = new GroupData(before.get(before.size() - 1).getId(),"test1", "test2", "test3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        //коммит для задания №9
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
        //коммит для задания №9
        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        //коммит для задания №9
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }   //коммит для задания №9
}
