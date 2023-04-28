package kz.bitlab.trello.services.impl;

import kz.bitlab.trello.entities.Folder;
import kz.bitlab.trello.entities.TaskCategories;
import kz.bitlab.trello.repositories.FolderRepository;
import kz.bitlab.trello.services.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Override
    public Folder addFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    @Override
    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    @Override
    public Folder getFolder(Long id) {
        return folderRepository.findAllById(id);
    }

    @Override
    public List<TaskCategories> getNotUsedCategories(List<TaskCategories> allCategories, Folder folder) {
        List<TaskCategories> newCategories = new ArrayList<>();
        for(int i = 0; i < allCategories.size(); i++){
            boolean flag = false;
            for(int j = 0; j < folder.getCategories().size(); j++){
                if(allCategories.get(i).getId() == (folder.getCategories().get(j).getId())){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                newCategories.add(allCategories.get(i));
            }
        }
        return newCategories;
    }

}
