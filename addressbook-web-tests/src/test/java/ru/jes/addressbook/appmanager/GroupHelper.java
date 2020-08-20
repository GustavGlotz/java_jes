package ru.jes.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jes.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends BaseHelper {
    //коммит для задания №9
    public GroupHelper(WebDriver wd) {
        super(wd);
    }
    //коммит для задания №9
    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }
    //коммит для задания №9
    public void submitGroupCreation() {
        click(By.name("submit"));
    }
    //коммит для задания №9
    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }
    //коммит для задания №9
    public void initGroupCreation() {
        click(By.name("new"));
    }     //коммит для задания №9

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }          //коммит для задания №9

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }         //коммит для задания №9

    public void initGroupModification() {
        click(By.name("edit"));
    }
    //коммит для задания №9
    public void submitGroupModification() {
        click(By.name("update"));
    }
    //коммит для задания №9
    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }           //коммит для задания №9

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }          //коммит для задания №9

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }               //коммит для задания №9

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        //коммит для задания №9
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            //коммит для задания №9
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
            //коммит для задания №9
        }
        return groups;
    }      //коммит для задания №9
}
