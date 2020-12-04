package project3.backend.helper.helper;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Regex {
    public static final String EMAIL_REGEX = "\\w+[.]\\w+@\\w+[.]\\w+";
    public static final String INTEGER_REGEX = "\\d";
    public static  final String PHONE_REGREX = "^0[98753]{1}\\d{8}";
    public static  final String PRICE_REGREX = "[0-9]\\d";

    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
}
