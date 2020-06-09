package ru.volnenko.se.command.task;

import javax.annotation.Resource;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.controller.Bootstrap;
import ru.volnenko.se.service.TaskService;

/**
 * @author Denis Volnenko
 */
@Component
public class TaskCreateEvent implements Command {

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
    @Async("CustomAsyncExecutor")
    @EventListener(condition = "#event.command == 'task-create'")
    public void execute(final CommandEvent event) {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        taskService.createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }
}
