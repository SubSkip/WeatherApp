package com.tts.weatherapp;

import java.util.Date;
//import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ZipCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "zip_id")
    private Long id;
    private String zip;
    @CreationTimestamp
    private Date date;
}
