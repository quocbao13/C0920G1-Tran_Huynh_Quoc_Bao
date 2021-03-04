package demo.controller;

import demo.model.User;
import demo.service.UserService;
import demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser(Pageable pageable) {
        return userService.findAll(pageable);
     }
}
