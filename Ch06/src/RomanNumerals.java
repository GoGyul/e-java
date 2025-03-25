import java.util.regex.Pattern;

public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "(^?=.M*(C[MD]|D?C{0,3})?)"
    );
    static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }
}