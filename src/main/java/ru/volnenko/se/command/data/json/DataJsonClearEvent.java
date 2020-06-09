package ru.volnenko.se.command.data.json;

import java.io.File;
import java.nio.file.Files;
import javax.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.constant.DataConstant;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataJsonClearEvent implements Command {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String command() {
        return "data-json-clear";
    }

    @Override
    public String description() {
        return "Remove JSON file.";
    }

    @Override
    @EventListener(condition = "#event.command == 'data-json-clear'")
    public void execute(final CommandEvent event) throws Exception {
        final File file = new File(DataConstant.FILE_JSON);
        Files.deleteIfExists(file.toPath());
    }
}
