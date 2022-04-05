package org.ytu.hr.core.services;

public interface ILoginService {
    String getEmployeeID();
    String getUsername();
    String getPassword();

    Boolean isCorrectUser();
}
