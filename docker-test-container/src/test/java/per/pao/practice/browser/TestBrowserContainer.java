package per.pao.practice.browser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testable
@Testcontainers
public class TestBrowserContainer
{
    @Container
    public static final BrowserWebDriverContainer container =
            new BrowserWebDriverContainer()
                    .withCapabilities(new ChromeOptions());

    @Test
    public void getHeading()
    {
        RemoteWebDriver driver = container.getWebDriver();
        driver.get("http://example.com");
        String heading = driver.findElement(By.xpath("/html/body/div/h1"))
                .getText();
        Assertions.assertEquals("Example Domain", heading);
    }
}
