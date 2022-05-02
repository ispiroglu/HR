package org.ytu.hr.core.services;

public interface ILoginService {
    Integer getEmployeeID();
    String getUsername();
    String getPassword();
    Boolean isCorrectUser();
}
