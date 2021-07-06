package per.pao.practice.log;

import per.pao.practice.antlrparser.LogBaseListener;
import per.pao.practice.antlrparser.LogParser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LogListener
        extends LogBaseListener
{
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss", Locale.ENGLISH);
    private final List<LogEntry> list = new ArrayList<>();
    private LogEntry current;

    public List<LogEntry> getList()
    {
        return list;
    }

    @Override
    public void enterEntry(LogParser.EntryContext ctx)
    {
        this.current = new LogEntry();
    }

    @Override
    public void enterTimestamp(LogParser.TimestampContext ctx)
    {
        this.current.setTimestamp(
                LocalDateTime.parse(ctx.getText(), DEFAULT_DATETIME_FORMATTER));
    }

    @Override
    public void enterMessage(LogParser.MessageContext ctx)
    {
        this.current.setMessage(ctx.getText());
    }

    @Override
    public void enterLevel(LogParser.LevelContext ctx)
    {
        this.current.setLevel(LogEntry.LogLevel.valueOf(ctx.getText()));
    }

    @Override
    public void exitEntry(LogParser.EntryContext ctx)
    {
        this.list.add(this.current);
    }
}
