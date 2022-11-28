package com.pawinc.myblog.service;

import com.pawinc.myblog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User create(User user);
    User readById(long id);
    User update(User user);
    void delete(long id);

    List<User> getAll();

}
