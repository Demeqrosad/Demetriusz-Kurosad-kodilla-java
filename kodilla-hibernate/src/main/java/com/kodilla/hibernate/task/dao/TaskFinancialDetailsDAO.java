package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskFinancialDetailsDAO extends CrudRepository<TaskFinancialDetails, Integer>
{
    List<TaskFinancialDetails> findByTaskPaid(boolean taskPaid);
}
