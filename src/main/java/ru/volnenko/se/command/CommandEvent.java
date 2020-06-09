package ru.volnenko.se.command;

import org.springframework.context.ApplicationEvent;

public class CommandEvent extends ApplicationEvent {

    public String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param event the object on which the event initially occurred (never {@code null})
     */
    public CommandEvent(Object event, String command) {
        super(event);
        this.command = command;
    }
}
