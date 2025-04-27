package org.example.studyhub.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "course_module")
public class CourseModule {

    @OneToMany(mappedBy = "courseModule", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Resource> resources = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long moduleId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "orderNum")
    private int orderNum;

    @Column(name = "courseId")
    private int courseId;

    @CreationTimestamp
    @Column(name = "createdAt", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatetAt")
    private LocalDateTime updatetAt;

    //Lage en tom konstruktør
    public CourseModule() {

    }
    //konsturktør som kan initialiseres
    public CourseModule(String title, String description, int orderNum, int courseId) {
        this.title = title;
        this.description = description;
        this.orderNum = orderNum;
        this.courseId = courseId;
    }

    //gettere og settere
    public long getModuleId() {
        return moduleId;
    }
    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getOrderNum() {
        return orderNum;
    }
    public void setOrder_num(int orderNum) {
        this.orderNum = orderNum;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreated_at(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatetAt() {
        return updatetAt;
    }
    public void setUpdatet_at(LocalDateTime updatetAt) {
        this.updatetAt = updatetAt;
    }

}
