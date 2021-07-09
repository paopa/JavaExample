package per.pao.practice.log;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Resources;
import per.pao.practice.antlrparser.LogLexer;
import per.pao.practice.antlrparser.LogParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TestLogListener
{
    @Test
    public void test()
    {
        String log = "2018-May-05 14:20:24 ERROR Bad thing happened";

        final LogLexer lexer = new LogLexer(new ANTLRInputStream(log));
        final CommonTokenStream stream = new CommonTokenStream(lexer);
        final LogParser parser = new LogParser(stream);
        final ParseTreeWalker walker = new ParseTreeWalker();
        final LogListener listener = new LogListener();
        walker.walk(listener, parser.log());
        final LogEntry entry = listener.getList().get(0);
        assertThat(entry)
                .extracting("level", "message", "timestamp")
                .contains(
                        LogEntry.LogLevel.ERROR,
                        "Bad thing happened",
                        LocalDateTime.of(2018, 5, 5, 14, 20, 24));
    }

    @Test
    public void testFromFile()
            throws IOException
    {
        final LogLexer lexer = new LogLexer(new ANTLRFileStream(System.getProperty("user.dir") + "/src/test/resources/mock.log"));
        final CommonTokenStream stream = new CommonTokenStream(lexer);
        final LogParser parser = new LogParser(stream);
        final ParseTreeWalker walker = new ParseTreeWalker();
        final LogListener listener = new LogListener();
        walker.walk(listener, parser.log());
        final List<LogEntry> list = listener.getList();
        list.forEach(System.out::println);
    }
}