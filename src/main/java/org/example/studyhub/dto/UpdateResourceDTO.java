package org.example.studyhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateResourceDTO {

    @NotNull(message = "ID må være satt")
    private Long id;

    @NotBlank(message = "Tittel er påkrevd")
    private String titel;

    @NotNull(message = "Type må være satt")
    private String type;

    @NotBlank(message = "Innhold kan ikke være tomt.")
    private String content;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getTitel(){
        return titel;
    }
    public void setTitel(String titel){
        this.titel = titel;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }



}
