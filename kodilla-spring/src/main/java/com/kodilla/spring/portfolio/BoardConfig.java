package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig
{
    @Autowired
    @Qualifier("ToDo")
    TaskList taskList;

    @Bean(name = "ToDo")
    public TaskList getToDoList()
    {
        return new TaskList();
    }

    @Bean(name = "InProgress")
    public TaskList getInProgressList()
    {
        return new TaskList();
    }

    @Bean(name = "Done")
    public TaskList getDoneList()
    {
        return new TaskList();
    }

    @Bean
    public Board getBoard()
    {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
}
