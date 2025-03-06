package co.com.tcs.ui;

import net.serenitybdd.screenplay.targets.Target;

public class FinishPage {

    public static final Target TXT_FINISHED = Target.the("finished text").locatedBy("//h1[normalize-space()='Felicidades, has terminado la prueba exitosamente']");
}
