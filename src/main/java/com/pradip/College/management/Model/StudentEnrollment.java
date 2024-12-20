package com.pradip.College.management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToMany
//    @JoinColumn(name="student_id",referencedColumnName = "sid")
//    private Long sid;

    @ManyToOne(cascade = CascadeType.ALL) // Establishing a many-to-one relationship with cascade
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false) // Foreign key reference to Student
    private Student student;

   // @OneToMany
//    @JoinColumn(name = "course_id", referencedColumnName = "cid")
//    private Long cid;

    @ManyToOne(cascade = CascadeType.ALL) // Assuming a course can also be enrolled in multiple times
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false) // Foreign key reference to Course
    private Course course;

//    @CurrentTimestamp
//    private LocalDateTime enrolled_date;

    @Column(updatable = false)
    private LocalDateTime enrolled_date = LocalDateTime.now();



}
