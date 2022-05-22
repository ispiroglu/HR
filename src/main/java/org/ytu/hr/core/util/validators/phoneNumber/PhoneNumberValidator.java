package org.ytu.hr.core.util.validators.phoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private Pattern pattern;
    private Matcher matcher;
    private final static String regex = "^/^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$/";
    public PhoneNumberValidator()
    {
        pattern = Pattern.compile(regex);
    }
    public boolean validate(String phoneNumber)
    {
        return phoneNumber.length() == 10 && phoneNumber.toCharArray()[0] == '5';
    }
}
