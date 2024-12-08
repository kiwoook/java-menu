package menu.utils;

import menu.exception.CustomIllegalArgumentException;
import menu.exception.ErrorMessage;

public class StringUtils {


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

    public static String formatString(String value) {
        return " " + value + " ";
    }

}
