package ru.volnenko.se.command.task;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Task;
import ru.volnenko.se.service.TaskService;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskListCommand extends AbstractCommand {

    @Resource
    private TaskService taskService;

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "Show all tasks.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK LIST]");
        int index = 1;
        for (Task task : taskService.getListTask()) {
            System.out.println(index + ". " + task.getName());
            index++;
        }
        System.out.println();
    }

}
