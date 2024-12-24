package com.pradip.College.management.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TeacherEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL) // Establishing a many-to-one relationship with cascade
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false) // Foreign key reference to Student
    private Users teacher;

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

    public Users getTeacher() {
        return teacher;
    }

    public void setTeacher(Users teacher) {
        this.teacher = teacher;
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