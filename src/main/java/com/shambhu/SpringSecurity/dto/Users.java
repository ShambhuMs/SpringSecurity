package com.shambhu.SpringSecurity.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
}
