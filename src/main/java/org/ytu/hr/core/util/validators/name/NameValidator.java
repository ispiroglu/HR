package org.ytu.hr.core.util.validators.name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {
    private Pattern pattern;
    private Matcher matcher;
    private final static String regex = "^[a-zA-Z0-9ğüşöçıİĞÜŞÖÇ ]+$";

    public NameValidator() {
        pattern = Pattern.compile(regex);
    }

    public boolean validate(String name) {
        matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
