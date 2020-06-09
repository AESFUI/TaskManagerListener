package ru.volnenko.se.command.task;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.controller.Bootstrap;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskRemoveCommand extends AbstractCommand {

    @Resource
    private Bootstrap bootstrap;

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "Remove selected task.";
    }

    @Override
    public void execute() {
        System.out.println("[REMOVING TASK]");
        System.out.println("Enter task order index:");
        final Integer orderIndex = bootstrap.nextInteger();
        if (orderIndex == null) {
            System.out.println("Error! Incorrect order index...");
            System.out.println();
            return;
        }
        System.out.println("[OK]");
    }

}
