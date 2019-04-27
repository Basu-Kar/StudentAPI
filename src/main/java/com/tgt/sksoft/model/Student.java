package com.tgt.sksoft.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Long studentId;
    private String firstName;
    private  String lastName;
    private Integer rollNumber;
}
