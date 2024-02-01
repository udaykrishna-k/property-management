package com.myfirstcompany.property_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USER_TABLE")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "OWNER", nullable = false)
    private String ownerName;
    @Column(name = "OWNER_EMAIL", nullable = false)
    private String ownerEmail;
    private String password;
    private String phone;
}
