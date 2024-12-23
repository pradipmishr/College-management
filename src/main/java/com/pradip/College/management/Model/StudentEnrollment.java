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


    @ManyToOne(cascade = CascadeType.ALL) // Establishing a many-to-one relationship with cascade
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false) // Foreign key reference to Student
    private Student student;



    @ManyToOne(cascade = CascadeType.ALL) // Assuming a course can also be enrolled in multiple times
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false) // Foreign key reference to Course
    private Course course;


    @Column(updatable = false)
    private LocalDateTime enrolled_date = LocalDateTime.now();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getEnrolled_date() {
        return enrolled_date;
    }

    public void setEnrolled_date(LocalDateTime enrolled_date) {
        this.enrolled_date = enrolled_date;
    }
}
