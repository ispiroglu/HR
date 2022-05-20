package org.ytu.hr.core.util.validators.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {
    private Pattern pattern;
    private Matcher matcher;
    private final static String regex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";

    public NameValidator() {
        pattern = Pattern.compile(regex);
    }

    public boolean validate(String name) {
        matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
