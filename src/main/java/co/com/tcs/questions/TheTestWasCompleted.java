package co.com.tcs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tcs.ui.FinishPage.TXT_FINISHED;

public class TheTestWasCompleted implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return TXT_FINISHED.resolveFor(actor).isVisible();
    }

    public static TheTestWasCompleted isShowed(){ return new TheTestWasCompleted();}
}
