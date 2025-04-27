package org.example.studyhub.repository;

import org.example.studyhub.model.CourseModule;
import org.example.studyhub.model.Resource;
import org.example.studyhub.model.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByType(ResourceType type);
    List<Resource> findByCourseModule(CourseModule courseModule);
}
