package org.ytu.hr.core.models.account;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountID;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Account()
    {

    }

    public Account(Integer employeeID, String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
