package co.com.tcs.task;

import co.com.tcs.utils.EmojiHelper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.tcs.ui.FormPage.TXT_STATEMENT;
import static co.com.tcs.ui.FormPage.TXT_EMOJIS;
import static co.com.tcs.ui.FormPage.INPUT_NUMBER;

public class CountEmojis implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String statement = OnStage.theActorInTheSpotlight().asksFor(Text.of(TXT_STATEMENT));
        String emojiToBeFound = EmojiHelper.extractEmoji(statement);

        String emojiBunch = OnStage.theActorInTheSpotlight().asksFor(Text.of(TXT_EMOJIS));

        long emojiCounter = emojiBunch.codePoints()
                .filter(ch -> new String(Character.toChars(ch)).equals(emojiToBeFound))
                .count();

        actor.attemptsTo(
                Enter.theValue(String.valueOf(emojiCounter)).into(INPUT_NUMBER)
        );

    }

    public static CountEmojis onSecuence() { return new CountEmojis(); }
}
