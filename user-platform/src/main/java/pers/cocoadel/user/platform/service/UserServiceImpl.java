package pers.cocoadel.user.platform.service;

import org.apache.commons.lang.StringUtils;
import pers.cocoadel.user.platform.bean.SingletonBeanContainer;
import pers.cocoadel.user.platform.domain.User;
import pers.cocoadel.user.platform.exception.BusinessException;
import pers.cocoadel.user.platform.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = SingletonBeanContainer.getInstance().get(UserRepository.class);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User selectByName(String name, String password) {
        return userRepository.getByNameAndPassword(name, password);
    }

    @Override
    public boolean signIn(String name, String password) {
        User user = selectByName(name, password);
        if(user == null){
            throw new BusinessException("用户名或者密码错误！");
        }
        return  true;
    }

    public void signUp(User user){
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            throw new BusinessException("用户名或密码不能为空！");
        }
        User oldUser = userRepository.getByName(user.getName());
        if(oldUser != null){
            throw new BusinessException(String.format("用户名称 %s 已经存在！",oldUser.getName()));
        }
        userRepository.save(user);
    }
}
