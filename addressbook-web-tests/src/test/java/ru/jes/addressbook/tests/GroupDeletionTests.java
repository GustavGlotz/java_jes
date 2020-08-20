package ru.jes.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.jes.addressbook.model.GroupData;
import java.util.List;

public class GroupDeletionTests extends TestBase {
    //коммит для задания №9

    @Test
    public void testGroupDeletion() throws Exception {
        //коммит для задания №9
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        //коммит для задания №9
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        //коммит для задания №9
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
//коммит для задания №9
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }

}
