package kz.bitlab.trello.services.impl;

import kz.bitlab.trello.entities.Folder;
import kz.bitlab.trello.entities.Task;
import kz.bitlab.trello.repositories.TaskRepository;
import kz.bitlab.trello.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findAllById(id);
    }

    @Override
    public List<Task> getTasksByFolder(Folder folder) {
        return taskRepository.findByFolder(folder);
    }
}
