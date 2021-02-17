package com.autosledz.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "positions")
public class Position {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "deviceId")
    private Long deviceId;

    @Column (name = "latitude")
    private Long latitude;

    @Column (name = "longitude")
    private Long longitude;
}
