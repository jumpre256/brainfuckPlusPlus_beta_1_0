package BrainfuckAss;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

@SuppressWarnings({"CatchMayIgnoreException", "RedundantSuppression"})
public class BrainfuckAss   //Interpreter to the brainfuckAss language.
{

    private static boolean hadError = false;

    public static void interpret(String input) {}


    private static String removeCommentsAndNewlines(String input) throws LexerError
    {
        PrecompileState state = PrecompileState.Code;
        int operatorIndex = 0;
        while(true)
        {
            if(!(operatorIndex < input.length())) break;
            char c = input.charAt(operatorIndex);
            if(c == '#' && lastChar(input, operatorIndex)) {
                state = PrecompileState.LineComment;
            } else if(c == '#' && input.charAt(operatorIndex + 1) != '{' && input.charAt(operatorIndex + 1) != '}'){
                state = PrecompileState.LineComment;
            } else if(c == '#' && input.charAt(operatorIndex + 1) == '{' && state == PrecompileState.Code){
                state = PrecompileState.MultilineComment;
            } else if(c == '#' && input.charAt(operatorIndex + 1) == '{' && state != PrecompileState.Code) {
                throw new LexerError("Cannot initiate a new multiline comment within an existing multiline comment.");
            }

            if(c == '}' && input.charAt(operatorIndex + 1) != '{') {}

            operatorIndex++;
        }
        return "";
    }

    private static boolean lastChar(String input, int operatorIndex)
    {
        return operatorIndex == (input.length() - 1);
    }

    private static boolean isReserved(char c)
    {
        boolean returnValue;
        switch(c){
            case '[':
            case ']':
            case '+':
            case '-':
            case '.':
            case ',':
            case ':':
            case ';':
            case '|':
            case '>':
            case '<':
            case '*':
            case '^':
            case '@': //14th reserved character
            case '"':
            case '!':
            case '#':
            case '\n':
            case '{':
            case '}':
                returnValue = true; break;
            default:
                returnValue = ((c >= 48) && (c <= 57)) || ((c >= 97) && (c <= 122));
                Tool.Debugger.debug("BrainfuckAss.BrainfuckAss", c + ": " + (int)c + "\n", ' ');
                break;

        }
        return returnValue;
    }

    @SuppressWarnings({"TryWithIdenticalCatches", "ResultOfMethodCallIgnored"})
    private static void writeToFile(String input, String filePath) {
        boolean success = false;
        while (!success) {
            File file = new File(filePath);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(input);
                bufferedWriter.close();
                success = true;
            } catch (FileNotFoundException e) {
                try {
                    file.createNewFile();
                } catch(Exception e1) {}
            } catch(Exception e0) {}
        }
        System.out.println("Succesfully wrote to file.");
    }

    private enum PrecompileState {
        Code, LineComment, MultilineComment
    }
}
