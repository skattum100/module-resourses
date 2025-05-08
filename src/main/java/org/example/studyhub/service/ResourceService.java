package org.example.studyhub.service;

import org.example.studyhub.model.Resource;
import org.example.studyhub.model.ResourceType;
import org.example.studyhub.repository.ModuleRepository;
import org.example.studyhub.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;


    }

//1.Get all resources
public List<Resource>  findAll() {
        return resourceRepository.findAll();
    }

//Get a resource on ID
public Optional<Resource> findById(Long id){
        return resourceRepository.findById(id);
}
// get a resource by type
    public List<Resource> findByType(ResourceType type){
        return resourceRepository.findByType(type);
    }

// Update resource
public Resource save(Resource resource) {
        return resourceRepository.save(resource);
}
//slette resources basert på id

public void deleteById(Long id){
        resourceRepository.deleteById(id);
}

}
