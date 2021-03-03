package pers.cocoadel.user.platform.service;

import pers.cocoadel.user.platform.domain.User;

public interface UserService {

    void save(User user);

    User selectByName(String name);

}
