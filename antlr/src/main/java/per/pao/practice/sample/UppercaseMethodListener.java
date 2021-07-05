package per.pao.practice.sample;

import org.antlr.v4.runtime.tree.TerminalNode;
import per.pao.practice.antlrparser.Java8BaseListener;
import per.pao.practice.antlrparser.Java8Parser;

import java.util.ArrayList;
import java.util.List;

public class UppercaseMethodListener
        extends Java8BaseListener
{
    private final List<String> errors = new ArrayList();

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx)
    {
        final TerminalNode node = ctx.Identifier();
        final String methodName = node.getText();
        if (Character.isUpperCase(methodName.charAt(0))) {
            final String error = String.format("Method %s is uppercased!!", methodName);
            errors.add(error);
        }
    }
}
