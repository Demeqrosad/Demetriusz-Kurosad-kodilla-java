package com.kodilla.patterns.factory.tasks;

import java.util.HashSet;
import java.util.Set;

public class TasksStatus
{
    private static Set<Task> executed = new HashSet<>();

    public static void execute(Task task)
    {
        executed.add(task);
    }

    public static boolean check(Task task)
    {
        return executed.contains(task);
    }

    public static HashSet<Task> getExecuted()
    {
        return new HashSet<>(executed);
    }
}
