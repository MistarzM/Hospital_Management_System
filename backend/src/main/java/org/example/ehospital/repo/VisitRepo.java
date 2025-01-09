package org.example.ehospital.repo;

import org.example.ehospital.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitRepo extends JpaRepository<Visit, Integer> {
    Optional<Visit> findByTriageId(Integer triageId);
}
