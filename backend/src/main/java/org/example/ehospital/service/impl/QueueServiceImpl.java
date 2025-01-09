package org.example.ehospital.service.impl;

import org.example.ehospital.dto.QueueDto;
import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.entity.Queue;
import org.example.ehospital.mapper.QueueMapper;
import org.example.ehospital.mapper.TriageMapper;
import org.example.ehospital.repo.QueueRepo;
import org.example.ehospital.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueueServiceImpl implements QueueService {
    private final QueueRepo queueRepo;

    @Autowired
    public QueueServiceImpl(QueueRepo queueRepo) {
        this.queueRepo = queueRepo;
    }

    @Override
    public List<QueueDto> getPriorityQueue() {
        List<Queue> queueList = queueRepo.findAllByStatusInOrderByPriorityPointsDesc(
                List.of("WAITING", "IN_PROGRESS")
        );

        return queueList.stream()
                .map(QueueMapper::mapToQueueDto)
                .collect(Collectors.toList());
    }
}
