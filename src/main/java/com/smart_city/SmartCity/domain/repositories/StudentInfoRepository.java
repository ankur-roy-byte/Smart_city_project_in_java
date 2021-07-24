package com.smart_city.SmartCity.domain.repositories;

import com.smart_city.SmartCity.domain.entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Integer> {

    List<StudentInfo> findAllByActiveOrderByIdDesc(boolean active);

    Optional<StudentInfo> findByIdAndActive(Integer id, boolean active);

}
