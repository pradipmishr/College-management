package com.pradip.College.management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

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
    @JoinColumn(name="student_id",referencedColumnName = "sid")
    private Long sid;

   // @OneToMany
    @JoinColumn(name = "course_id", referencedColumnName = "cid")
    private Long cid;

    @CurrentTimestamp
    private Date enrolled_date;
}
