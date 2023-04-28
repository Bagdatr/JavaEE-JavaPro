package kz.bitlab.trello.services.impl;

import kz.bitlab.trello.entities.TaskCategories;
import kz.bitlab.trello.repositories.TaskCategoriesRepository;
import kz.bitlab.trello.services.TaskCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoriesServiceImpl implements TaskCategoriesService {
    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;
    @Override
    public List<TaskCategories> getAllCategories() {
        return taskCategoriesRepository.findAll();
    }

    @Override
    public TaskCategories addCategories(TaskCategories taskCategories) {
        return taskCategoriesRepository.save(taskCategories);
    }

    @Override
    public void deleteCategory(Long id) {
        taskCategoriesRepository.deleteById(id);
    }

    @Override
    public TaskCategories getCategory(Long id) {
        return taskCategoriesRepository.findAllById(id);
    }
}
