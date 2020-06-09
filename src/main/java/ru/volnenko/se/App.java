package ru.volnenko.se;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.config.ContextConfiguration;
import ru.volnenko.se.controller.Bootstrap;

public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        Bootstrap bootstrap = context.getBean(Bootstrap.class);
        Map<String, Command> classMap = context.getBeansOfType(Command.class);
        List<Command> commandList = new ArrayList<>(classMap.values());
        bootstrap.init(commandList);
    }
}
