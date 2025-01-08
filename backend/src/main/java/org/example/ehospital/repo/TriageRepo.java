package org.example.ehospital.repo;

import org.example.ehospital.entity.Triage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriageRepo extends JpaRepository<Triage, Integer> {
}
