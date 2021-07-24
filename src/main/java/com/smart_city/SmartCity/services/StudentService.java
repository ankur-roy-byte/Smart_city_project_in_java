package com.smart_city.SmartCity.services;

import com.smart_city.SmartCity.domain.entities.StudentInfo;
import com.smart_city.SmartCity.domain.repositories.StudentInfoRepository;
import com.smart_city.SmartCity.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentInfoRepository studentInfoRepository;

    public StudentService(StudentInfoRepository studentInfoRepository) {
        this.studentInfoRepository = studentInfoRepository;
    }

    public StudentInfo getUser(Integer id) {
        return studentInfoRepository.findByIdAndActive(id,true).orElseThrow(NotFoundException::new);
    }

    public StudentInfo createUser(StudentInfo userInfo) {
        return studentInfoRepository.save(userInfo);
    }

    public List<StudentInfo> getUsers() {
        return studentInfoRepository.findAllByActiveOrderByIdDesc(true);
    }

    public StudentInfo updateUser(Integer id, StudentInfo request) {
        StudentInfo fromDb = getUser(id);
        fromDb.setFirstName(request.getFirstName());
        fromDb.setLastName(request.getLastName());
        fromDb.setRole(request.getRole());
        fromDb.setActive(request.isActive());
        fromDb.setUpdatedAt(LocalDateTime.now());
        return studentInfoRepository.save(fromDb);
    }
}
