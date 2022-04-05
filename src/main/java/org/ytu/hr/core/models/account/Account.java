package org.ytu.hr.core.models.account;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private final Integer candidateID;
    @Column(name = "username")
    private final String username;
    @Column(name = "password")
    private String password;

    public Account(Integer employeeID, String username, String password) {
        this.candidateID = employeeID;
        this.username = username;
        this.password = password;
    }

    public Integer getCandidateID() {
        return candidateID;
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
