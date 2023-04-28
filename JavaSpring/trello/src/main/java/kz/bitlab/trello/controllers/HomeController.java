package kz.bitlab.trello.controllers;

import groovy.lang.Category;
import kz.bitlab.trello.entities.Folder;
import kz.bitlab.trello.entities.Task;
import kz.bitlab.trello.entities.TaskCategories;
import kz.bitlab.trello.services.FolderService;
import kz.bitlab.trello.services.TaskCategoriesService;
import kz.bitlab.trello.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/trello")
public class HomeController {
    @Autowired
    public FolderService folderService;
    @Autowired
    public TaskCategoriesService taskCategoriesService;
    @Autowired
    public TaskService taskService;

    @GetMapping(value="/home")
    public String openHome(Model model){
        List<Folder> folders = folderService.getAllFolders();
        model.addAttribute("folders",folders);
        return "home";
    }

    @PostMapping(value="/add-folder")
    public String addFolderPost(@RequestParam(name="folder-name") String folderName){
        String redirect = "/trello/add-folder?error";
        Folder folder = Folder.builder()
                .name(folderName)
                .build();
        if(folderService.addFolder(folder) != null){
            redirect = "/trello/home";
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value="/details/{id}")
    public String openDetails(@PathVariable("id") Long id,
                              Model model){
        Folder folder = folderService.getFolder(id);
        model.addAttribute("folder",folder);

        List<TaskCategories> allCategories = taskCategoriesService.getAllCategories();
        List<TaskCategories> newCategories = folderService.getNotUsedCategories(allCategories,folder);
        model.addAttribute("categories",newCategories);

        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);

        List<Task> tasksByFolder = taskService.getTasksByFolder(folder);
        model.addAttribute("tasksByFolder",tasksByFolder);

        return "details";
    }

    @PostMapping(value="/add-task")
    public String addTaskPost(@RequestParam(name="folder-id") Long folderId,
                              @RequestParam(name="task-title") String taskTitle,
                              @RequestParam(name="task-description") String taskDescription){
        String redirect = "/trello/add-task?error";
        Folder folder = folderService.getFolder(folderId);
        Task task = Task.builder()
                .title(taskTitle)
                .description(taskDescription)
                .status(0)
                .folder(folder)
                .build();
        if(taskService.addTask(task) != null){
            redirect = "/trello/details/" + folderId;
        }
        return "redirect:" + redirect;
    }

    @PostMapping(value="/add-category-to-folder")
    public String addCategoryToFolderPost(@RequestParam(name="folder-id") Long folderId,
                                  @RequestParam(name="category-id")Long categoryId){
        String redirect = "/trello/add-category-to-folder?error";
        Folder folder = folderService.getFolder(folderId);
        TaskCategories category = taskCategoriesService.getCategory(categoryId);
        folder.getCategories().add(category);
        if(folderService.addFolder(folder) != null){
            redirect = "/trello/details/" + folderId;
        }
        return "redirect:" + redirect;
    }

    @PostMapping(value="/delete-category-from-folder")
    public String deleteCategoryFromFolderPost(@RequestParam(name="folder-id") Long folderId,
                                               @RequestParam(name="category-id") Long categoryId){
        String redirect = "/trello/add-category-to-folder?error";
        Folder folder = folderService.getFolder(folderId);
        TaskCategories category = taskCategoriesService.getCategory(categoryId);
        folder.getCategories().remove(category);
        if(folderService.addFolder(folder) != null){
            redirect = "/trello/details/" + folderId;
        }
        return "redirect:" + redirect;
    }

    @GetMapping(value="/add-category")
    public String openAddCategories(Model model){
        List<TaskCategories>categories = taskCategoriesService.getAllCategories();
        model.addAttribute("categories",categories);
        return "add-category";
    }

    @PostMapping(value="/add-category")
    public String addCategoryPost(@RequestParam(name="category-name") String name){
        String redirect = "/trello/add-category?error";
        TaskCategories taskCategories = TaskCategories.builder()
                .name(name)
                .build();
        if(taskCategoriesService.addCategories(taskCategories) != null){
            redirect = "/trello/add-category";
        }
        return "redirect:" + redirect;
    }

    @PostMapping(value="/delete-category")
    public String deleteCategoryPost(@RequestParam(name="category-id") Long id){
        String redirect = "/trello/add-category";
        taskCategoriesService.deleteCategory(id);
        return "redirect:" + redirect;
    }

    @GetMapping(value="/task-details/{id}")
    public String openTaskDetails(@PathVariable("id") Long id,
                                  Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("task",task);
        return "task-details";
    }

    @PostMapping(value="/update-task")
    public String updateTaskPost(@RequestParam(name="folder-id") Long folderId,
                                 @RequestParam(name="task-id") Long taskId,
                                 @RequestParam(name="task-title") String taskTitle,
                                 @RequestParam(name="task-description") String taskDescription,
                                 @RequestParam(name="task-status") int taskStatus){
        String redirect = "/trello/update-task?error";
        Folder folder = folderService.getFolder(folderId);
        Task task = taskService.getTask(taskId);
        task.setTitle(taskTitle);
        task.setDescription(taskDescription);
        task.setStatus(taskStatus);
        task.setFolder(folder);
        if(taskService.addTask(task) != null){
            redirect = "/trello/details/" + folderId;
        }
        return "redirect:" + redirect;
    }

}
