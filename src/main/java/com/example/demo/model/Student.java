package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // Quan hệ n-n với đối tượng ở dưới (Students) (1 người học nhiều môn)
    @JoinTable(name = "student_subject",                                //Tạo ra một join Table tên là "student_subject"
            joinColumns = @JoinColumn(name = "student_id"),         // TRong đó, khóa ngoại chính là student_id trỏ tới class hiện tại (Student)
            inverseJoinColumns = @JoinColumn(name = "subject_id")   //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Subject)
    )
    private List<Subject> subjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
