package org.example.ehospital.repo;

import org.example.ehospital.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueRepo extends JpaRepository<Queue, Integer> {
    List<Queue> findAllByStatusInOrderByPriorityPointsDesc(List<String> statuses);
}
