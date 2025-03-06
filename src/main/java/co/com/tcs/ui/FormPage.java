package co.com.tcs.ui;

import net.serenitybdd.screenplay.targets.Target;

public class FormPage {

    public static final Target TXT_DATE = Target.the("text with date").locatedBy("//p[contains(text(),'Indique la fecha')]");
    public static final Target INPUT_DATE = Target.the("input date").locatedBy("//input[@name='date']");
    public static final Target TXT_STATEMENT = Target.the("text with the statement").locatedBy("//p[contains(text(),'Indique cuantos')]");
    public static final Target TXT_EMOJIS = Target.the("text with the emojis").locatedBy("//div[@class=\"w-9/12 space-y-4\"]/p[2]");
    public static final Target INPUT_NUMBER = Target.the("input emojis number").locatedBy("//input[@name='number']");
    public static final Target BTN_ENVIAR = Target.the("enviar button").locatedBy("//button[normalize-space()='Enviar']");

}
