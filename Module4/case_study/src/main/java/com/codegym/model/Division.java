package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long divisionId;
    private String divisionName;
    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Division() {
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
