package com.smart_city.SmartCity.domain.repositories;

import com.smart_city.SmartCity.domain.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    List<UserInfo> findAllByActiveOrderByIdDesc(boolean active);

    Optional<UserInfo> findByIdAndActive(Integer id, boolean active);

}
