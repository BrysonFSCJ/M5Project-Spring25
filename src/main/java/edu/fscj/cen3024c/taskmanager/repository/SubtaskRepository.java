package edu.fscj.cen3024c.taskmanager.repository;

import edu.fscj.cen3024c.taskmanager.entity.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtaskRepository extends JpaRepository<Subtask, Integer> {

    // Additional query methods can be defined here
    List<Subtask> findByTaskId(Integer taskId);
}
