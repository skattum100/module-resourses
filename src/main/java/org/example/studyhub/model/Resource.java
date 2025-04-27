package org.example.studyhub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.time.LocalDateTime;


@Entity
@Table(name = "resource")

public class Resource {

    @ManyToOne
    @JoinColumn(name = "moduleId")
    @JsonIgnore
    private CourseModule courseModule;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resourceId;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ResourceType type;

    @Column(name = "url")
    private String url;

    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(name = "createdAt", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatetAt")
    private LocalDateTime updatetAt;

    //Lage en tom konstruktør
    public Resource() {
    }
    //lage en kontruktør som kan initialisere
    public Resource(CourseModule courseModule, String title, ResourceType type, String url, String content) {
        this.courseModule = courseModule;
        this.title = title;
        this.type = type;
        this.url = url;
        this.content = content;
    }

    //gettere og settere
    public CourseModule getModule() {
        return courseModule;
    }
    public void setModule(CourseModule courseModule) {
        this.courseModule = courseModule;
    }
    public long getResourceId() {
        return resourceId;
    }
    public void setResource_Id(long resource_Id) {
        this.resourceId = resource_Id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public ResourceType getType() {
        return type;
    }
    public void setType(ResourceType type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getContent() {
        return content;

    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatetAt() {
        return updatetAt;
    }
    public void setUpdatet_At(LocalDateTime updatetAt) {
        this.updatetAt = updatetAt;
    }

}
