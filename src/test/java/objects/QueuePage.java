package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class QueuePage extends BaseObjects{
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add match to queue')]")
    private WebElement addMatchToQueue;

    public QueuePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MatchesPage addMatchToQueue(){
        clickElement(addMatchToQueue);
        return new MatchesPage(driver);
    }
}
