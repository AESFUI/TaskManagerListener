package ru.volnenko.se.command.data.xml;

import java.io.File;
import java.nio.file.Files;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.Command;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.constant.DataConstant;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataXmlClearEvent implements Command {

    @Override
    public String command() {
        return "data-xml-clear";
    }

    @Override
    public String description() {
        return "Remove XML file.";
    }

    @Override
    @EventListener(condition = "#event.command == 'data-xml-clear'")
    public void execute(final CommandEvent event) throws Exception {
        final File file = new File(DataConstant.FILE_XML);
        Files.deleteIfExists(file.toPath());
    }
}
