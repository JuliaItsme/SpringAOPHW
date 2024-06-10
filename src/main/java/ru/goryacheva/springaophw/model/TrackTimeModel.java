package ru.goryacheva.springaophw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TRACK_TIME")
public class TrackTimeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * имя метода
     */
    @Column(name = "NAME")
    private String name;

    /**
     * его время выполнения
     */
    @Column(name = "TIME")
    private Long time;
}
