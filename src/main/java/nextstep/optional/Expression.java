package nextstep.optional;

import java.util.Arrays;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }

    static Expression of(String expression) {
        return Arrays.stream(values())
                .filter(e -> matchExpression(e, expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 없는 표현식입니다.", expression)));
    }
}
