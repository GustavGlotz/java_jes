package ru.jes.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    private GroupHelper groupHelper;
    private ContactHelper contactHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        login("admin", "secret");
    }

    public void login(String username, String password) {
        groupHelper.wd.findElement(By.name("user")).click();
        groupHelper.wd.findElement(By.name("user")).clear();
        groupHelper.wd.findElement(By.name("user")).sendKeys(username);
        groupHelper.wd.findElement(By.name("pass")).clear();
        groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
        groupHelper.wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void gotoGroupPage() {
        groupHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        groupHelper.wd.quit();
    }

    public boolean isAlertPresent() {
        try {
            groupHelper.wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
