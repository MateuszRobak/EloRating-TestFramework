package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;;
import org.openqa.selenium.support.How;

public class Selectors {




    public static String url = "https://elo-rating.herokuapp.com/leagues";
    public static String passwordUser = "eloratingsprite";
    public static String username = "eloratingtest@gmail.com";






    public static By leagueList(String league){
        return By.xpath("//a[contains(text(),'" +league+"')]");
    }


}
