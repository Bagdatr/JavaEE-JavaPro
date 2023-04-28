package kz.bitlab.trello.services;

import kz.bitlab.trello.entities.Folder;
import kz.bitlab.trello.entities.Task;

import java.util.List;

public interface TaskService {
    Task addTask(Task task);
    List<Task> getAllTasks();
    Task getTask(Long id);
    List<Task> getTasksByFolder(Folder folder);

}
