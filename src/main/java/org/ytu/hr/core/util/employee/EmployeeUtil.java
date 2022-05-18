package org.ytu.hr.core.util.employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;


import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {
    public static List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("select a FROM Employee a", Employee.class).getResultList();
    }
    public static void adar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String firstName = "Evren";
        Query query1 = session.createQuery("from Employee where firstName=:first_name");
        query1.setParameter("first_name", firstName);

        Employee e = (Employee)query1.uniqueResult();

        System.out.println(e.toString());
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
