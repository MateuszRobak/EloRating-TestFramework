package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Navbar {

    public static By dashboard = By.xpath("//a[contains(text(),'Dashboard')]");

    public static By matchesLink = By.xpath("//a[contains(text(),'Matches')]");

    public static By playersLink = By.xpath("//a[contains(text(),'Players')]");

    public static By queueLink = By.xpath("//a[contains(text(),'Queue')]");

}
