package ru.volnenko.se.command.project;

import javax.annotation.Resource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.controller.Bootstrap;
import ru.volnenko.se.service.ProjectService;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectCreateEvent implements Command {

    @Resource
    private Bootstrap bootstrap;
    @Resource
    private ProjectService projectService;

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    @EventListener(condition = "#event.command == 'project-create'")
    public void execute(final CommandEvent event) {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        projectService.createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }
}
