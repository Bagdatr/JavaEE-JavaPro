import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница входа в кабинет cabinet.preprod.prosperpay.kz
 */

public class AuthPage {

    private final SelenideElement loginInput = $x("//input[@id='login']");

    public void openSite(String url){
        Selenide.open(url);
    }

}
