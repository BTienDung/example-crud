package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "subjects")
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;

    // mappedBy trỏ tới tên biến subjects ở trong Address.
    @ManyToMany(mappedBy = "subjects")
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
