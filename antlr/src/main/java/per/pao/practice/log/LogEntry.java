package per.pao.practice.log;

import java.time.LocalDateTime;

public class LogEntry
{
    enum LogLevel
    {
        DEBUG, INFO, ERROR;
    }

    private LogLevel level;
    private String message;
    private LocalDateTime timestamp;

    public void setLevel(LogLevel level)
    {
        this.level = level;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public LogLevel getLevel()
    {
        return level;
    }

    public String getMessage()
    {
        return message;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }
}
