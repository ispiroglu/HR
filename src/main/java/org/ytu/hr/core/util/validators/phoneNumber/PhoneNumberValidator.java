package org.ytu.hr.core.util.validators.phoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private Pattern pattern;
    private Matcher matcher;
    private final static String regex = "^\\\\d{10}$";
    public PhoneNumberValidator()
    {
        pattern = Pattern.compile(regex);
    }
    public boolean validate(String phoneNumber)
    {
        matcher = pattern.matcher(phoneNumber);
        System.out.println("Match sonucu -> " + matcher .matches());
        return matcher.matches() && phoneNumber.length() == 10 && phoneNumber.toCharArray()[0] == 5;
    }
}
