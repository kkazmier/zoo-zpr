package com.zoozpr.model;

import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
@Getter
public class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
