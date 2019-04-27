package com.tgt.sksoft.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Null
    private Long studentId;

    @NotBlank
    private String firstName;

    @NotBlank
    private  String lastName;

    @NotNull
    private Integer rollNumber;
}
