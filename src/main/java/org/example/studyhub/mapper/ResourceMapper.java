package org.example.studyhub.mapper;

import org.example.studyhub.dto.CreateResourceDTO;
import org.example.studyhub.dto.ResourceDTO;
import org.example.studyhub.dto.UpdateResourceDTO;
import org.example.studyhub.model.Resource;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

//ResourceMapper for converting between Resource and ResourceDTO
@Mapper (componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ResourceMapper {

    @Mapping(
            target = "moduleId",
            expression = "java(resource.getModule() != null ? resource.getModule().getModuleId() : null)"
    )
    ResourceDTO toDTO(Resource resource);

    List<ResourceDTO> toDTOList(List<Resource> resources);

    @Mappings({
            @Mapping(target = "resourceId", ignore = true),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "content", source = "content"),
           // @Mapping(target = "module", ignore = true) // valgfritt – hvis du ikke bruker det ennå
    })
    Resource fromCreateDTO(CreateResourceDTO dto);

    Resource fromUpdateDTO(UpdateResourceDTO dto);

    @Mapping(target = "resourceId", ignore = true)
    void updateResourceDTO(ResourceDTO dto, @MappingTarget Resource resource);
}
