package BrainfuckPlusPlus;

public enum OperatorType {
    LEFT, RIGHT, ADD, MINUS,
    DOT, COMMA, LOOP_OPEN, LOOP_CLOSE,

    SET_LOCATOR, BRA, METHOD_CALL, RET,

    SET_AV, STAR, DOUBLE_QUOTE, BANG, AT_SYMBOL,

    STRING_LITERAL_CHAR,

    EOF
}
