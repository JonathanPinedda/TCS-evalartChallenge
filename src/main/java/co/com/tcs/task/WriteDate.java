package co.com.tcs.task;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static co.com.tcs.ui.FormPage.INPUT_DATE;

@AllArgsConstructor
public class WriteDate implements Task {

    private final String newDate;

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.setAttribute('type', 'text');", "//input[@name='date']");

        actor.attemptsTo(
                Enter.theValue(newDate).into(INPUT_DATE)
        );


        js.executeScript("document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.setAttribute('type', 'date');", "//input[@name='date']");

    }

    public static WriteDate of(String dateToEnter) {
        return new WriteDate(dateToEnter);
    }
}
