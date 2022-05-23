package org.ytu.hr.core.util.validators.salary;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalaryValidator {
    public boolean validate(String salaryText) {
        if (Objects.equals(salaryText, ""))
            return false;
        int salary;
        try {
            salary = Integer.parseInt(salaryText);
        }catch (Exception e) {
            return false;
        }
        int maxSalary = 50000;
        return salary < maxSalary && salary > 0;
    }
}
