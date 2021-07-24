package com.smart_city.SmartCity.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity

public class StudentInfo extends UserInfo
{
    private String email;
    private Qualification qualification;
}
