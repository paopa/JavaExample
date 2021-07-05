package per.pao.practice.sample;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import per.pao.practice.antlrparser.Java8Lexer;
import per.pao.practice.antlrparser.Java8Parser;

import static org.assertj.core.api.Assertions.assertThat;

class TestUppercaseMethodListener
{
    @Test
    public void test()
    {
        final String string = "public class SampleClass { void DoSomething(){} }";
        final Java8Lexer lexer
                = new Java8Lexer(new ANTLRInputStream(string));
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final Java8Parser parser = new Java8Parser(tokenStream);
        final ParseTree tree = parser.compilationUnit();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final UppercaseMethodListener listener = new UppercaseMethodListener();
        walker.walk(listener, tree);

        assertThat(listener.getErrors()).hasSize(1);
        assertThat(listener.getErrors().get(0)).contains("Method DoSomething is uppercased!!");
    }
}