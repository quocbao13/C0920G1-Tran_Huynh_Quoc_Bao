package vn.codegym.Model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    private String contract_detail_id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "contract_id" ,  nullable = false)
    private Contract contract;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "attach_service_id" ,  nullable = false)
    private AttachService attachService;

    public ContractDetail() {
    }

    public String getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(String contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
