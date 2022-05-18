package org.ytu.hr.core.util.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ytu.hr.core.models.employee.Employee;


import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {
    private static final SessionFactory sessionFactory = new Configuration()
                        .configure()
                        .addAnnotatedClass(Employee.class)
                        .buildSessionFactory();
    private static Session session;

    public static List<Employee> getAllEmployees() {
        session = sessionFactory.openSession();
        return session.createQuery("select a FROM Employee a", Employee.class).getResultList();
    }
    public static Object[][] getAllEmployeesToSimpleMatrix() {
        List<Employee> list = getAllEmployees();
        System.out.println("list + " + list);
        Object[][] matrix = new Object[5][15];
        for (int i = 0; i < 5; i++)
            matrix[i] = new Object[15];

        for(int i = 0; i < list.size(); i++) {

            System.out.println(i + " + " + list.get(i));
            matrix[i][0] = list.get(i).getFirstName();
            matrix[i][1] = list.get(i).getLastName();
            matrix[i][2] = list.get(i).getEmail();
            matrix[i][3] = list.get(i).getGender();
            matrix[i][4] = list.get(i).getSalary();
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }
}
