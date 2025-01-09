package org.example.ehospital.service;

import org.example.ehospital.dto.QueueDto;
import org.example.ehospital.repo.QueueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface QueueService {
    List<QueueDto> getPriorityQueue();
    QueueDto updateQueue(Integer id, QueueDto updatedQueue);
}

