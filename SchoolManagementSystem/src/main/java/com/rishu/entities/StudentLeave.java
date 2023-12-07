package com.rishu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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

    /*@Column(name = "user_id")
    private int user_id;*/
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "Id")
    private User user;

}
