package com.hcl.springdatajps.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentKey implements Serializable {
    private Long id;
    private String email;
}
