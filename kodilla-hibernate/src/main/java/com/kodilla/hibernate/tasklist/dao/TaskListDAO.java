package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskListDAO extends CrudRepository<TaskList, Integer>
{
    public List<TaskList> findByTaskListName(String taskListName);
    public List<TaskList> findByTaskListNameContaining(String listNameSubstring);
}
