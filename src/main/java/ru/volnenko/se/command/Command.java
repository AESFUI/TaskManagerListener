package ru.volnenko.se.command;

/**
 * @author Denis Volnenko
 */
public interface Command {

    void execute(final CommandEvent event) throws Exception;

    String command();

    String description();
}
