package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractId;
    private String contractStartDate;
    private String contractEndDate;
    private String contractDeposit;
    private String contractTotalMoney;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "emlpoyee_id" , nullable = false)
    private Employee employee;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_id" , nullable = false)
    private Service service;
    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contract_id) {
        this.contractId = contract_id;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contract_start_date) {
        this.contractStartDate = contract_start_date;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contract_end_date) {
        this.contractEndDate = contract_end_date;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contract_deposit) {
        this.contractDeposit = contract_deposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contract_total_money) {
        this.contractTotalMoney = contract_total_money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
