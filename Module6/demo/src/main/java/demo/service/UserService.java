package demo.service;

import demo.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll(Pageable pageable);

    User findById(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);
}
