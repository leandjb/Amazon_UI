package pages;

public class AmazonSearchPage extends MainPage{

    //Locators of WebElements
    private String searchBox = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String thirdResult = "(//span[text()='Más opciones de compra'])[3]";
    private String addToCartButton = "//span[text()[normalize-space()='Carrito']]";
    private String addedMessageText = "//*[contains(text(), 'Agregado al carrito')]";

    public AmazonSearchPage(){
        super(driver);
    }

    public void navigateToAmazon() {
        navigateTo("https://www.amazon.com/");
    }

    public void enterSearchCriteria(String criteria){

        write(searchBox,criteria);
    }

    public void clickSearch() {

        clickElement(searchButton);
    }

    public void goToPage(String pageNumber) {

        goToLinkText(pageNumber);
    }

    public void pickThirdItem(){

        clickElement(thirdResult);
    }

    public void addToCart() {

        clickElement(addToCartButton);
    }

    public String addedToCartMessage() {
        return textFromElement(addedMessageText);
    }
}
