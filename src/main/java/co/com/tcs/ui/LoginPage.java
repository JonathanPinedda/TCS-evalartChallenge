package co.com.tcs.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final String URL = "https://tasks.evalartapp.com/automatization/";
    public static final Target INPUT_USER = Target.the("user input").located(By.name("username"));
    public static final Target INPUT_PASSWORD = Target.the("password input").located(By.name("password"));
    public static final Target BTN_ENVIAR = Target.the("enviar button").locatedBy("//button[contains(text(), \"Enviar\")]");

}
