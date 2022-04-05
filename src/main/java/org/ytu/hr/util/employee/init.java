package org.ytu.hr.util.employee;

import org.ytu.hr.models.employee.Employee;
import org.ytu.hr.util.adress.Address;
import org.ytu.hr.util.gender.Gender;

import java.util.Date;

public class init {
    public static void main(String[] args) {
        Employee evren = new Employee(1, 1,1,"evren", "Ispiroglu",
                "ispiroglu", Gender.Male, new Address(), new Date(),new Date(), 1);

        System.out.println(evren.getGender());
    }

}
