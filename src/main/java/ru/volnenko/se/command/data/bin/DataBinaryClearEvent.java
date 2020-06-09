package ru.volnenko.se.command.data.bin;

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
public final class DataBinaryClearEvent implements Command {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String command() {
        return "data-bin-clear";
    }

    @Override
    public String description() {
        return "Remove binary data.";
    }

    @Override
    @EventListener(condition = "#event.command == 'data-bin-clear'")
    public void execute(final CommandEvent event) throws Exception {
        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
    }
}
