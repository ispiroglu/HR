package org.ytu.hr.util.employee;

import org.ytu.hr.util.employee.adress.Address;
import org.ytu.hr.util.employee.gender.Gender;

import java.util.Date;

public class init {
    public static void main(String[] args) {
        Employee evren = new Employee(1,1,"evren", "Ispiroglu",
                "ispiroglu", Gender.Male, new Address(), new Date(),new Date(), 1);

        System.out.println(evren.getGender());
    }

}
