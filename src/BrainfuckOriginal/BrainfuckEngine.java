package BrainfuckOriginal;

import java.util.Scanner;

public class BrainfuckEngine     //code credit: https://www.geeksforgeeks.org/brainfuck-interpreter-java/
{
    private static Scanner ob = new Scanner(System.in);
    private static int ptr; // Data pointer

    // Max memory limit. Highest number which can be represented by an unsigned 16-bit binary
    // number.
    private static int length = 65535;
    private static byte memory[] = new byte[length];

    public static void interpret(String input)
    {
        int loopDepth = 0;

        // Parsing through each character of the code
        int operatorIndex = 0;
        //for (int i = 0; i < s.length(); i++)
        while(true)
        {
            if(!(operatorIndex < input.length())) break;

            // > moves the pointer to the right
            if (input.charAt(operatorIndex) == '>')
            {
                if (ptr == length - 1)//If memory is full
                    ptr = 0;//pointer is returned to zero
                else
                    ptr ++;
            }

            // < moves the pointer to the left
            else if (input.charAt(operatorIndex) == '<')
            {
                if (ptr == 0) // If the pointer reaches zero

                    // pointer is returned to rightmost memory
                    // position
                    ptr = length - 1;
                else
                    ptr --;
            }

            // + increments the value of the memory
            // cell under the pointer
            else if (input.charAt(operatorIndex) == '+')
                memory[ptr] ++;

                // - decrements the value of the memory cell
                // under the pointer
            else if (input.charAt(operatorIndex) == '-')
                memory[ptr] --;

                // . outputs the character signified by the
                // cell at the pointer
            else if (input.charAt(operatorIndex) == '.')
                System.out.print((char)(memory[ptr]));

                // , inputs a character and store it in the
                // cell at the pointer
            else if (input.charAt(operatorIndex) == ',')
                memory[ptr] = (byte)(ob.next().charAt(0));

                // [ jumps past the matching ] if the cell
                // under the pointer is 0
            else if (input.charAt(operatorIndex) == '[')
            {
                if (memory[ptr] == 0)
                {
                    operatorIndex++;
                    while (loopDepth > 0 || input.charAt(operatorIndex) != ']')
                    {
                        if (input.charAt(operatorIndex) == '[')
                            loopDepth++;
                        else if (input.charAt(operatorIndex) == ']')
                            loopDepth--;
                        operatorIndex++;

                        /*Tool.Debugger.debug("reading_BrainfuckCore",
                                "\tloopDepth: " + loopDepth + "\n"
                                        + "\toperatorIndex: " + operatorIndex);*/
                    }
                }
            }

            // ] jumps back to the matching [ if the
            // cell under the pointer is nonzero
            else if (input.charAt(operatorIndex) == ']')
            {
                if (memory[ptr] != 0)
                {
                    operatorIndex --;
                    while (loopDepth > 0 || input.charAt(operatorIndex) != '[')
                    {
                        if (input.charAt(operatorIndex) == ']')
                            loopDepth++;
                        else if (input.charAt(operatorIndex) == '[')
                            loopDepth--;
                        operatorIndex--;

                        /*Tool.Debugger.debug("reading_BrainfuckCore",
                                "\tloopDepth: " + loopDepth + "\n"
                                        + "\toperatorIndex: " + operatorIndex);*/
                    }
                }
            }
            operatorIndex++;
        }
    }

}
