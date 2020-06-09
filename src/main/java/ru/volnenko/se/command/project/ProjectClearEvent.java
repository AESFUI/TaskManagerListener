package ru.volnenko.se.command.project;

import javax.annotation.Resource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.service.ProjectService;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectClearEvent implements Command {

    @Resource
    private ProjectService projectService;

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    @EventListener(condition = "#event.command == 'project-clear'")
    public void execute(final CommandEvent event) {
        projectService.clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }
}
