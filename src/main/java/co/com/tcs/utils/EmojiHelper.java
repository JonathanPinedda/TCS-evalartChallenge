package co.com.tcs.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiHelper {


    private static final Pattern EMOJI_PATTERN = Pattern.compile("cuantos\\s+(\\p{So})\\s+hay");

    public static String extractEmoji(String EmojiBunch) {

        Matcher matcher = EMOJI_PATTERN.matcher(EmojiBunch);

        if(matcher.find()){

            return matcher.group(1);

        } else {

            throw new RuntimeException("Emoji extraction exception");
            
        }
    }

}
