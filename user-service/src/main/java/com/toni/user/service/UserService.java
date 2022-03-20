package com.toni.user.service;

import com.toni.user.entity.User;
import com.toni.user.repository.UserRepository;
import com.toni.user.vo.DepartmentVO;
import com.toni.user.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate){
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserVO findUser(Long id) {
        User user = userRepository.getById(id);
        DepartmentVO  department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
                DepartmentVO.class);
        return UserVO.builder().id(user.getId()).name(user.getName())
                .departmentId(department.getId()).departmentName(department.getName())
                .build();
    }
}
