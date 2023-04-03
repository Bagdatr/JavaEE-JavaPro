package kz.bitlab;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager {
    private static ArrayList<Tasks> list = new ArrayList();

    public static void addTask(Tasks task) {
        list.add(task);
    }

    public static ArrayList<Tasks> getAllTasks() {
        return list;
    }

    public static Tasks getTask(Long id){
        for(Tasks task:list){
            if(Objects.equals(task.getId(), id)){
                return task;
            }
        }
        return null;
    }
    public static void updateTask(Tasks updTask){
        int index = -1;
        for(int i=0;i< list.size();i++){
            if(list.get(i).getId() == updTask.getId()){
                index = i;
                break;
            }
        }
        list.set(index,updTask);
    }
    public static void removeTask(Tasks remTask){
        int index = -1;
        for(int i=0;i< list.size();i++){
            if(list.get(i).getId() == remTask.getId()){
                index = i;
                break;
            }
        }
        list.remove(index);
    }
}
