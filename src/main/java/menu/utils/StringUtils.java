package menu.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import menu.exception.CustomIllegalArgumentException;
import menu.exception.ErrorMessage;

public class StringUtils {

    private static final String OR = "|";

    private StringUtils() {
    }

    public static String[] split(String regex, String input, Integer fieldCount) {
        if (regex == null || input == null || input.isBlank() || input.endsWith(regex)) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }

        String[] split = input.split(regex);
        if (fieldCount != null && split.length != fieldCount) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return split;
    }

    public static String regexSeparators(List<String> separators) {
        StringJoiner regex = new StringJoiner(OR);

        for (String separator : separators) {
            regex.add(Pattern.quote(separator));
        }

        return regex.toString();
    }

    public static String regexSeparators(String separator, String... separators) {
        StringJoiner regex = new StringJoiner(OR);
        regex.add(separator);

        for (String sep : separators) {
            regex.add(Pattern.quote(sep));
        }

        return regex.toString();
    }

    public static String numberFormat(long number) {
        DecimalFormat format = new DecimalFormat("#,###");

        return format.format(number);
    }

}
