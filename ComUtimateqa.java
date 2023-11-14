import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Project-5 - ProjectName : com-utimateqa
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class ComUtimateqa
{
    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // 1. Setup chrome browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        // Open URL
        driver.get(baseUrl);
        Thread.sleep(4000);

        // Maximize the browser
        driver.manage().window().maximize();

        // 3. Print the title of the page.
        String title = driver.getTitle();
        System.out.println(title);

        // 4. Print the current url.
        System.out.println("The current Url " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println(driver.getPageSource());

        // 6. Click on ‘Sign In’ link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();
        Thread.sleep(4000);

        System.out.println(driver.getCurrentUrl());

        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("Prime123@gmail.com");
        Thread.sleep(4000);

        WebElement pwd = driver.findElement(By.id("user[password]"));
        pwd.sendKeys("Prime123");
        Thread.sleep(4000);

        WebElement signInButton = driver.findElement(By.xpath("(//button[@type='submit'])"));
        signInButton.click();
        Thread.sleep(4000);

        //driver.navigate().to("https://courses.ultimateqa.com/");
        driver.navigate().to( baseUrl);
        Thread.sleep(4000);

        driver.navigate().forward();
        Thread.sleep(4000);

        driver.navigate().back();
        Thread.sleep(4000);

        driver.navigate().refresh();
        Thread.sleep(4000);

        driver.quit();

    }
}

