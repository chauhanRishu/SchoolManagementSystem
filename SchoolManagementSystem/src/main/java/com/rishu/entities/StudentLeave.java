package com.rishu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leaves")
public class StudentLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int leaveId;

    private String subject;

    private String body;

    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "Id")
    private User user;

}
