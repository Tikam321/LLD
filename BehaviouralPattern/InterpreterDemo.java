package BehaviouralPattern;

import java.util.HashMap;
import java.util.Map;



class Context {
    Map<String, Integer> context;
    public Context() {
        this.context = new HashMap<>();
    }

    public void put(String key, Integer val) {
        context.put(key, val);
    }

    public int get(String key) {
        return context.get(key);
    }
}
abstract class Expression {
    abstract int interpret(Context context);
}

class Number extends Expression {
    private String number;

    public Number(String number) {
        this.number = number;
    }

    @Override
    int interpret(Context context) {
        return context.get(number);
    }
}

class AddOperation extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public AddOperation(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    int interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}

public class InterpreterDemo {

    public static void main(String[] args) {
        Context context = new Context();
        context.put("a", 12);
        context.put("b", 3);
        context.put("c", 15);
        Number number1 = new Number("a");
        Number number2 = new Number("b");
        Number number3 = new Number("c");
        Expression expression = new AddOperation(number1, number2);
        Expression expression1 = new AddOperation(expression, number3);
        System.out.println(expression1.interpret(context));
    }
}
