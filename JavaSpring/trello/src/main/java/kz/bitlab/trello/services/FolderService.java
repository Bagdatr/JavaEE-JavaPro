package kz.bitlab.trello.services;

import kz.bitlab.trello.entities.Folder;
import kz.bitlab.trello.entities.TaskCategories;

import java.util.List;

public interface FolderService {
    Folder addFolder(Folder folder);
    List<Folder> getAllFolders();
    Folder getFolder(Long id);
    List<TaskCategories> getNotUsedCategories(List<TaskCategories> allCategories,
                                              Folder folder);
}
