package co.com.tcs.stepdefinitions;

import co.com.tcs.questions.TheTestWasCompleted;
import co.com.tcs.task.CountEmojis;
import co.com.tcs.task.WriteDate;
import co.com.tcs.task.Login;
import co.com.tcs.ui.FormPage;
import co.com.tcs.ui.LoginPage;
import co.com.tcs.utils.DateHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.tcs.ui.FormPage.TXT_DATE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;

public class FillFormStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("user");
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(LoginPage.URL));

        OnStage.theActorInTheSpotlight().attemptsTo(Login.in());
    }
    @When("the user fills the forms 10 times")
    public void theUserFillsTheForm() {

        for(int i = 0; i < 10; ++i){

            try {

                String dateStatement = OnStage.theActorInTheSpotlight().asksFor(Text.of(TXT_DATE));

                String newDate = DateHelper.calculateDate(dateStatement);


                OnStage.theActorInTheSpotlight().attemptsTo(WriteDate.of(newDate));

                OnStage.theActorInTheSpotlight().attemptsTo(CountEmojis.onSecuence());

                OnStage.theActorInTheSpotlight().attemptsTo(Click.on(FormPage.BTN_ENVIAR));

            } catch (Exception e) {
                i = 0;
            }

        }

    }
    @Then("validation hash-code should be shown")
    public void validationHashCodeShouldBeShown() {
        OnStage.theActorInTheSpotlight().should(seeThat("Felicidades, has terminado la prueba exitosamente", TheTestWasCompleted.isShowed(), is(true)));
    }
}
