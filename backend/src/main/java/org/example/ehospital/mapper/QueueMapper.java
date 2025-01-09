package org.example.ehospital.mapper;

import org.example.ehospital.dto.QueueDto;
import org.example.ehospital.entity.Queue;

public class QueueMapper {
    public static QueueDto mapToQueueDto(Queue queue) {
        return new QueueDto(
                queue.getId(),
                queue.getTriage().getName(), // Pobiera nazwę pacjenta z tabeli `Triage`
                queue.getPriorityPoints(),
                queue.getPriorityLevel(),
                queue.getStatus()
        );
    }
}

