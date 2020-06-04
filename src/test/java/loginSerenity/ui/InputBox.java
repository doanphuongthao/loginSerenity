package loginSerenity.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InputBox {
    //public static Target SEARCH_FIELD = Target.the("search field").located(By.name("q"));
    public static Target EMAIL_FIELD = Target.the("Email field").located(By.cssSelector("input#user_email"));
    public static Target PASSWORD_FIELD = Target.the("Password field").located(By.cssSelector("input#user_password"));
    public static Target LOGIN_BUTTON = Target.the("button Login").located(By.cssSelector("input[class=\"ht-btn--main-action\"]"));
    public static Target projectPage = Target.the("project page").located(By.cssSelector(".page-content-header__title-section__title"));

}
