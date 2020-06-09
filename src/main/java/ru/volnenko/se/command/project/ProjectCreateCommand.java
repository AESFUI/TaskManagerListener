package ru.volnenko.se.command.project;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.controller.Bootstrap;
import ru.volnenko.se.service.ProjectService;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectCreateCommand extends AbstractCommand {

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
    public void execute() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        projectService.createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
