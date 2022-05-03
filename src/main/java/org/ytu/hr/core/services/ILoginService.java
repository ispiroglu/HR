package org.ytu.hr.core.services;

public interface ILoginService {
    String getUsername();
    String getPassword();
    Boolean isCorrectUser();
}
