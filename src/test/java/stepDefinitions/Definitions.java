package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;


import static utilities.BrowserUtils.waitFor;

public class Definitions extends BasePage {

    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();

    @Given("User goes to {string}")
    public void userGoesTo(String url) {
        Driver.get().get(ConfigurationReader.get(url));
    }

    @And("Enter {string}, {string} and click the login")
    public void enterValidAndClickTheLogin(String username, String password) {
        homePage.userName.sendKeys(username);
        waitFor(2);
        homePage.password.sendKeys(password);
        waitFor(2);
        homePage.login.click();
        waitFor(2);
    }

    @Then("add two items")
    public void addTwoItems() throws InterruptedException {
       homePage.randomSelect();
    }

    @And("Click the Shopping Cart")
    public void clickTheShoppingCart() {
        homePage.shoppingCart.click();
        waitFor(2);
    }

    @Then("Click the Checkout Button")
    public void clickTheCheckoutButton() {
        homePage.checkout.click();
        waitFor(2);
    }

    @And("Fill out the required info and click the continue")
    public void fillOutTheRequiredInfoAndClickTheContinue() {
        homePage.firstName.sendKeys("John");
        waitFor(2);
        homePage.lastName.sendKeys("Carter");
        waitFor(2);
        homePage.zipCode.sendKeys("123");
        waitFor(2);
        homePage.continueButton.click();
        waitFor(2);
    }

    @Then("Click the finish button and ensure that user can see {string}")
    public void clickTheFinishButtonAndEnsureThatUserCanSee(String str) {
        homePage.finishButton.click();
        waitFor(2);
        softAssert.assertEquals(homePage.thankYou.getText(), str);
        waitFor(2);
    }


    @Then("Ensure that user can see the alert {string}")
    public void ensureThatUserCanSeeTheAlert(String str) {
        softAssert.assertEquals(homePage.errorMessage.getText(), str);
        waitFor(2);

    }
}
