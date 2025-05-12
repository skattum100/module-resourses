package org.example.studyhub.dto;



//Data Transfer object for course creation
//@Data

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.studyhub.model.ResourceType;

//Post DTO
public class CreateResourceDTO {

    @NotBlank(message = "Tittel er påkrevd.")
    private String title;

    @NotNull(message = "Type må være satt")
    private ResourceType type;

    @NotBlank(message = "Innhold kan ikke være tomt.")
    private String content;


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


}
