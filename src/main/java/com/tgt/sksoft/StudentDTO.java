package com.tgt.sksoft;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
public class StudentDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "roll_number")
    private Integer rollNumber;
}
