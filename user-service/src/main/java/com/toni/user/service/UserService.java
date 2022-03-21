package com.toni.user.service;

import com.toni.user.entity.User;
import com.toni.user.httpclient.DepartmentHttpClient;
import com.toni.user.repository.UserRepository;
import com.toni.user.vo.DepartmentVO;
import com.toni.user.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final DepartmentHttpClient departmentHttpClient;

    public UserService(UserRepository userRepository, DepartmentHttpClient departmentHttpClient){
        this.userRepository = userRepository;
        this.departmentHttpClient = departmentHttpClient;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserVO findUser(Long id) {
        User user = userRepository.getById(id);
        DepartmentVO  department = departmentHttpClient.findById(user.getDepartmentId());
        return UserVO.builder().id(user.getId()).name(user.getName())
                .departmentId(department.getId()).departmentName(department.getName())
                .build();
    }
}
