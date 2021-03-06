package pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    protected static WebDriver driver;
    private final WebDriverWait wait;

    static {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
    }

    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    }

    public static void closeBrowser() {
        driver.quit();
    }

    public void navigateTo(String url) {

        driver.get(url);
    }

    public void goToLinkText(String linkText) {


        driver.findElement(By.linkText(linkText)).click();
    }

    private WebElement find(String locator) {


        return driver.findElement(By.xpath(locator));
    }

    public void clickElement(String locator) {

        find(locator).click();
    }

    public void submitElement(String locator) {

        find(locator).submit();
    }

    public void write(String locator, String textToWrite) {

        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {

        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {

        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

/*    public void getScreenshot(String locator, nameFile) throws IOException {

        File file = find(locator).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(nameFile+".png"));
    }*/

    public String textFromElement(String locator) {

        find(locator);
        return locator;
    }

}
