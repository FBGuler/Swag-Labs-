package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@placeholder='Username']")
    public WebElement userName;

    @FindBy(xpath = "//*[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement login;

    @FindBy(xpath = "//*[@class='inventory_item']")
    public WebElement items;
    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//*[@id='checkout']")
    public WebElement checkout;

    @FindBy(xpath = "//*[@id='first-name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='last-name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='postal-code']")
    public WebElement zipCode;

    @FindBy(xpath = "//*[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id='finish']")
    public WebElement finishButton;

    @FindBy(xpath = "//*[text()='Thank you for your order!']")
    public WebElement thankYou;

    @FindBy(xpath = "//*[text()='Epic sadface: Sorry, this user has been locked out.']")
    public WebElement errorMessage;


    public void randomSelect() throws InterruptedException {
        Random random = new Random();
        List<WebElement> list = Driver.get().findElements(By.xpath("//*[text()='Add to cart']"));
        int index1 = random.nextInt(list.size());
        int index2;
        do {
            index2 = random.nextInt(list.size());
        } while (index2 == index1);

        list.get(index1).click();
        Thread.sleep(3000);
        list.get(index2).click();

    }



}
