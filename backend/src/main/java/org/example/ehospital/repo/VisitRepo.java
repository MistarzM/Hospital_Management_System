package org.example.ehospital.repo;

import org.example.ehospital.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepo extends JpaRepository<Visit, Integer> {
}
