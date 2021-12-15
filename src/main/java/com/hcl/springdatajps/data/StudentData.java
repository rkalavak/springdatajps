package com.hcl.springdatajps.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT", uniqueConstraints = {
        @UniqueConstraint(name = "student_email", columnNames = {"EMAIL"})
})
@IdClass(StudentKey.class)
public class StudentData implements Serializable {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Id
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "AGE")
    private Integer age;

}