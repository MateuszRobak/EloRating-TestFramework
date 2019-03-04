package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PlayersPage extends BaseObjects{
    WebDriver driver;

    public PlayersPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    };

    public PlayersPage addPlayer(){

        return this;
    }
}
