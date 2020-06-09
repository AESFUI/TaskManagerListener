package ru.volnenko.se.command.task;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.controller.Bootstrap;
import ru.volnenko.se.service.TaskService;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskCreateCommand extends AbstractCommand {

    @Resource
    private Bootstrap bootstrap;
    @Resource
    private TaskService taskService;

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        taskService.createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
