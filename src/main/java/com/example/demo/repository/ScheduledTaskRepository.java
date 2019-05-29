package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.ScheduledTask;
import com.example.demo.entity.ScheduledTaskKey;

@RepositoryRestResource(collectionResourceRel = "scheduled_tasks", path = "scheduled_tasks")
public interface ScheduledTaskRepository extends PagingAndSortingRepository<ScheduledTask, ScheduledTaskKey> {
	List<ScheduledTask> findByscheduledTaskKey_TaskName(String taskName);
}
