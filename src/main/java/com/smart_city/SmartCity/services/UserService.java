package com.smart_city.SmartCity.services;

import com.smart_city.SmartCity.domain.entities.UserInfo;
import com.smart_city.SmartCity.domain.repositories.UserInfoRepository;
import com.smart_city.SmartCity.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserInfoRepository userInfoRepository;

    public UserService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo getUser(Integer id) {
        return userInfoRepository.findByIdAndActive(id,true).orElseThrow(NotFoundException::new);
    }

    public UserInfo createUser(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getUsers() {
        return userInfoRepository.findAllByActiveOrderByIdDesc(true);
    }

    public UserInfo updateUser(Integer id, UserInfo request) {
        UserInfo fromDb = getUser(id);
        fromDb.setFirstName(request.getFirstName());
        fromDb.setLastName(request.getLastName());
        fromDb.setRole(request.getRole());
        fromDb.setActive(request.isActive());
        fromDb.setUpdatedAt(LocalDateTime.now());
        return userInfoRepository.save(fromDb);
    }
}
