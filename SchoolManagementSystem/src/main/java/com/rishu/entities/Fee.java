package com.rishu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feeId;

    private String month;

    private String givenBy;

    private long amount;

    private String description;

    @Column(name="date")
    private Date createDate;

    private int studentId;
}
