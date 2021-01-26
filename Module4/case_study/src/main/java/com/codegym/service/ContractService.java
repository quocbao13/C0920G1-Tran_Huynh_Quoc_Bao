package vn.codegym.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import vn.codegym.Model.Contract;
import vn.codegym.Model.Employee;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(String id);

    void update(Contract contract);

    Contract findById(String id);

    Page<Contract> findAllByContractIdContaining(Pageable pageable, String nameSearch);
}
