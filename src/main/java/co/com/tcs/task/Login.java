package co.com.tcs.task;

import lombok.AllArgsConstructor;
import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.tcs.ui.LoginPage.BTN_ENVIAR;
import static co.com.tcs.ui.LoginPage.INPUT_USER;
import static co.com.tcs.ui.LoginPage.INPUT_PASSWORD;


@AllArgsConstructor
public class Login implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(ConfiguredEnvironment.getEnvironmentVariables().getProperty("serenity.login.username")).into(INPUT_USER),
                Enter.theValue(ConfiguredEnvironment.getEnvironmentVariables().getProperty("serenity.login.password")).into(INPUT_PASSWORD),
                Click.on(BTN_ENVIAR)
        );
    }

    public static Login in(){return new Login();}
}
