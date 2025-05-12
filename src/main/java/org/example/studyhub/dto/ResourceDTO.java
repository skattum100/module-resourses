package org.example.studyhub.dto;

import org.example.studyhub.model.ResourceType;
// Get og Post
public class ResourceDTO {
    private Long id;
    private String title;
    private ResourceType type;
    private String content;
    private Long moduleId;

    //tom konstruktør
    public ResourceDTO() {
    }

    public ResourceDTO (Long id, String title, ResourceType type,String content, Long moduleId) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.content = content;
        this.moduleId = moduleId;
    }

    //Getter og setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getModuleId() {
        return moduleId;
    }
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}
