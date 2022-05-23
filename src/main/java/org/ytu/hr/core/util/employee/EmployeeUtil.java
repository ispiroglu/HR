package org.ytu.hr.core.util.employee;

import org.hibernate.Session;
import org.ytu.hr.core.dayoff.DayOff;
import org.ytu.hr.core.models.employee.Employee;
import org.ytu.hr.core.util.db.HibernateUtil;
import java.util.List;
import java.util.Optional;

public class EmployeeUtil {
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private static List<Employee> allEmployees = session.createQuery("select a FROM Employee a", Employee.class).getResultList();
    private static void updateEmployeeList() {
        session = HibernateUtil.getSessionFactory().openSession();
        allEmployees = session.createQuery("select a FROM Employee a", Employee.class).getResultList();
        session.close();
    }
    public static List<Employee> getAllEmployees() {
        session = HibernateUtil.getSessionFactory().openSession();
        if (allEmployees == null)
            updateEmployeeList();
        session.close();
        return allEmployees;
    }
    public static Object[][] getAllEmployeesToSimpleMatrix() {
        updateEmployeeList();
        Object[][] matrix = new Object[allEmployees.size()][5];
        for (int i = 0; i < allEmployees.size(); i++)
            matrix[i] = new Object[15];

        for(int i = 0; i < allEmployees.size(); i++) {
            matrix[i][0] = allEmployees.get(i).getFirstName();
            matrix[i][1] = allEmployees.get(i).getLastName();
            matrix[i][2] = allEmployees.get(i).getEmail();
            matrix[i][3] = allEmployees.get(i).getGender();
            matrix[i][4] = allEmployees.get(i).getSalary();
        }
        return matrix;
    }
    public static void saveEmployee(Employee employee) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        session.close();
    }
    public static void addEmployeeToList(Employee employee) {
        allEmployees.add(employee);
    }
    public static void updateEmployeeList(Employee employee) {
        allEmployees.set(employee.getEmployeeID(), employee);
    }
    public static void updateDayOffs() {
        for (Employee employee : allEmployees) {
            DayOff.isAbsentToday(employee);
        }
    }
}
