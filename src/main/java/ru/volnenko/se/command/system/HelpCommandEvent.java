package ru.volnenko.se.command.system;

import javax.annotation.Resource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.controller.Bootstrap;

/**
 * @author Denis Volnenko
 */
//@Lazy(false)
@Component
public final class HelpCommandEvent implements Command {

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
    @EventListener(condition = "#event.command == 'help'")
    public void execute(final CommandEvent event) {
        event.getSource();
        for (Command command : bootstrap.getListCommand()) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }
}
