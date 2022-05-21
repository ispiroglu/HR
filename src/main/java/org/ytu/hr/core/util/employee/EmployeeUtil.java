package org.ytu.hr.core.util.employee;

import org.hibernate.Session;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;
import java.util.List;

public class EmployeeUtil {
    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private static List<Employee> allEmployees = session.createQuery("select a FROM Employee a", Employee.class).getResultList();
    private static void updateEmployeeList() {
        allEmployees = session.createQuery("select a FROM Employee a", Employee.class).getResultList();
    }
    public static List<Employee> getAllEmployees() {
        if (allEmployees == null)
            updateEmployeeList();
        return allEmployees;
    }
    public static Object[][] getAllEmployeesToSimpleMatrix() {
            updateEmployeeList();
        Object[][] matrix = new Object[5][allEmployees.size()];
        for (int i = 0; i < allEmployees.size(); i++)
            matrix[i] = new Object[15];

        for(int i = 0; i < allEmployees.size(); i++) {

            System.out.println(i + " + " + allEmployees.get(i));
            matrix[i][0] = allEmployees.get(i).getFirstName();
            matrix[i][1] = allEmployees.get(i).getLastName();
            matrix[i][2] = allEmployees.get(i).getEmail();
            matrix[i][3] = allEmployees.get(i).getGender();
            matrix[i][4] = allEmployees.get(i).getSalary();
        }
        return matrix;
    }
    public static void addEmployeeToList(Employee employee) {
        allEmployees.add(employee);
    }
}
