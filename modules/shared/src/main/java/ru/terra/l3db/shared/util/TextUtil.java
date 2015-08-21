package ru.terra.l3db.shared.util;

/**
 * Date: 21.08.15
 * Time: 17:42
 */
public class TextUtil {
    public static String getNonEmptyString(String in) {
        return in != null ? in : "";
    }
}
