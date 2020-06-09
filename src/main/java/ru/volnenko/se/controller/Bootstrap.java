package ru.volnenko.se.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.error.CommandAbsentException;
import ru.volnenko.se.error.CommandCorruptException;

/**
 * @author Denis Volnenko
 */
@Component
public final class Bootstrap implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    /**
     * Set the ApplicationEventPublisher that this object runs in.
     * <p>Invoked after population of normal bean properties but before an init
     * callback like InitializingBean's afterPropertiesSet or a custom init-method. Invoked before
     * ApplicationContextAware's setApplicationContext.
     *
     * @param applicationEventPublisher event publisher to be used by this object
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    private final Map<String, Command> commands = new LinkedHashMap<>();

    private final Scanner scanner = new Scanner(System.in);

    public void registry(final Command commandEvent) {
        final String cliCommand = commandEvent.command();
        final String cliDescription = commandEvent.description();
        if (cliCommand == null || cliCommand.isEmpty()) throw new CommandCorruptException();
        if (cliDescription == null || cliDescription.isEmpty()) throw new CommandCorruptException();
        commands.put(cliCommand, commandEvent);
    }

    public void registry(final List<Command> commandList) {
        for (Command command : commandList) registry(command);
    }

    public void init(final List<Command> commandList) throws Exception {
        if (commandList == null || commandList.isEmpty()) throw new CommandAbsentException();
        registry(commandList);
        start();
    }

    private void start() {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = scanner.nextLine();
            publisher.publishEvent(new CommandEvent(this, command));
        }
    }

    public List<Command> getListCommand() {
        return new ArrayList<>(commands.values());
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public Integer nextInteger() {
        final String value = nextLine();
        if (value == null || value.isEmpty()) return null;
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
}
