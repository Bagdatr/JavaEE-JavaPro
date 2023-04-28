package kz.bitlab.trello.services;

import kz.bitlab.trello.entities.TaskCategories;

import java.util.List;

public interface TaskCategoriesService {
    List<TaskCategories> getAllCategories();
    TaskCategories addCategories(TaskCategories taskCategories);
    void deleteCategory(Long id);
    TaskCategories getCategory(Long id);
}
