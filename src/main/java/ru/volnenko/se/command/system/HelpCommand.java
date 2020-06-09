package ru.volnenko.se.command.system;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.controller.Bootstrap;

/**
 * @author Denis Volnenko
 */
@Component
public final class HelpCommand extends AbstractCommand {

    @Resource
    private Bootstrap bootstrap;

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Show all commands.";
    }

    @Override
    public void execute() {
        for (AbstractCommand command: bootstrap.getListCommand()) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }

}
