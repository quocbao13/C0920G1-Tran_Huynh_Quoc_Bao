package com.codegym.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    @Pattern(regexp = "^([A-Z][a-z]*( [A-Z][a-z]*)*)", message = "Wrong format. Ex: Tran Bao")
    private String employeeName;
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
            "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|" +
            "[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|" +
            "(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "Wrong format. Ex: 25/12/2021")
    private String employeeBirthday;
    @Pattern(regexp = "[0-9]{9}", message = "Wrong format. Ex: 2092xxxxx")
    private String employeeIdCard;
    @Pattern(regexp = "([1-9][0-9]{2,})", message = "Wrong format. Ex: 123,1300,66000")
    private String employeeSalary;
    @Pattern(regexp = "((07)|(09)|(03)|(06))[0-9]{8}")
    private String employeePhone;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]" +
            "*[a-z0-9])?\\.)+(?:[A-Z]{2}|com|org|net|gov|mil|biz|info|mobi|name|aero|jobs|museum)\\b"
            , message = "Wrong format. Ex: trxx.bxx@gmail.com")
    private String employeeEmail;
    @Pattern(regexp = "\\d{1,5}\\s\\w.\\s(\\b\\w*\\b\\s){1,2}\\w*", message = "Wrong format. Ex: 2xx Nguyen Van A")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id" , nullable=false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id" , nullable=false)
    private EducationDegree education_degree;

    @ManyToOne
    @JoinColumn(name = "division_id" ,nullable=false)
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username" , nullable = false)
    private User user;
    public Employee() {
    }
    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(EducationDegree education_degree) {
        this.education_degree = education_degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
