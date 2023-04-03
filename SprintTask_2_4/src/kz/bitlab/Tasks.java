package kz.bitlab;

public class Tasks {
    private static Long prevId = 0L;
    private Long id;
    private String name;
    private String description;
    private String deadlineDate;
    private String taskStatus;

    public Tasks() {
    }

    public Tasks(String name, String description, String deadlineDate, String taskStatus) {
        prevId = prevId + 1;
        this.id = prevId;
        this.name = name;
        this.description = description;
        this.deadlineDate = deadlineDate;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
