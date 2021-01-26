package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long educationDegreeId;
    private String educationDegreeName;
    @OneToMany(mappedBy = "education_degree")
    private List<Employee> employees;

    public EducationDegree() {
    }

    public Long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
