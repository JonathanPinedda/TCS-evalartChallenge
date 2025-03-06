package co.com.tcs.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateHelper {


    private static final Pattern PATTERN = Pattern.compile(".*?(\\d+)\\s*dias.*?:\\s*(\\d{2}/\\d{2}/\\d{4}).*");

    public static String calculateDate(String textoEnunciado) {

        Matcher matcher = PATTERN.matcher(textoEnunciado);

        if (matcher.find()) {

            int days = Integer.parseInt(matcher.group(1));
            String statementDate = matcher.group(2);
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate baseDate = LocalDate.parse(statementDate, inputFormatter);
            LocalDate dateCalculated;


            if (textoEnunciado.contains("desde antes de")) {
                dateCalculated = baseDate.minusDays(days);
            } else if (textoEnunciado.contains("desde el")) {
                dateCalculated = baseDate.plusDays(days);
            } else {
                throw new RuntimeException("Date format exception");
            }
            DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return dateCalculated.format(isoFormatter);
        } else {
            throw new RuntimeException("Date extraction exception");
        }
    }
}
