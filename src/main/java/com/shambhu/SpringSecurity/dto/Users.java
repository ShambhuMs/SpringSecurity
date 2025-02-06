package com.shambhu.SpringSecurity.dto;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class Users {

    @Id
    private int id;
    private String username;
    private String pasword;
}
