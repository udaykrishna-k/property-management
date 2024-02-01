package com.myfirstcompany.property_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="PROPERTY_TABLE")
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Owner", nullable = false)
    private String ownerName;
    @Column(name = "Owner_Email", nullable = false)
    private String ownerEmail;
    private String title;
    private String address;
    private Double price;
}
