package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {

    AmazonSearchPage amazon = new AmazonSearchPage();

    @Given("user navigate to Amazon Webpage")
    public void userNavigateToAmazonWebpage() {

        amazon.navigateToAmazon();
    }

    @And("^search (.+)$")
    public void searchProduct(String criteria) {

        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("navigate to second page")
    public void navigateToSecondPage() {

        amazon.goToPage("2");
    }

    @And("select the third item")
    public void selectTheThirdItem() {
        amazon.pickThirdItem();
    }

    @Then("user is able to add it to the cart")
    public void userIsAbleToAddItToTheCart() {

        amazon.addToCart();
        Assert.assertEquals("Agregado al Carro:" , amazon.addedToCartMessage());
    }

}
