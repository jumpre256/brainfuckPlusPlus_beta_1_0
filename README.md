# Brainfuck++
#### Version beta 1.0

Brainfuck language, by Urban Müller, uses the 8 single-character operations `<>+-[],.` to constitute, although impractical, a complete programming language. `Brainfuck++ beta 1.0`, a superset of brainfuck, adds 34 new characters:  
`:;|#*^{}`, `a` to `z`.
to provide just a few new programming features. 

To start, if not already, one should be familiar with brainfuck. There are many resources for learning this, one is: [Basics of BrainFuck](https://gist.github.com/roachhd/dce54bec8ba55fb17d3a).

For the following "`1. Main operators and characters new to brainfuck++:`" section of text we will use:  
- `a` for any (lowercase) character `a` to `z`.

#### 1. Main operators and characters new to brainfuck++:
- Locator `:a` (read "set locator `a`")  
This operator is like an assembly label. `:a` can be jumped to with a `;a` or `|a` operator.
- Operator `|a`  
Jumps immediately to the corresponding `:a`. Can be thought of as a "branch-always" assembly instruction.
- The `#` character  
Can be used to write a single-line comment that is terminated by ending the line of code with the return key.
- Operators `$` and `;a`  
I feel these are best communicated through some example code.
```
#a complete example brainfuck++ beta 1.0 program.

a:  #in this case code below "locator_a" represents (continued)
#[...] a sub-program that does something
-[----->++<] #any code can go here, in this case
#          the code increments the next cell by 102.
$       #this operator represents "return"

;a  #"calls" a, execution-pointer goes to locator-a

#and returns here when it hits the "$" operator.
#With using ";a" you should always include a "$" at  
#end of the method code. Proceed to not do so  
#at your own peril.

```
#### 2. Final 2 operators and final 2 characters of brainfuck++:

In `Brainfuck++ beta 1.0`, in addition to the array of memory provided by regular brainfuck, this language provides an additional 1 single byte of variable memory, I like to call the "`active vault`" (or `AV` for short).

- Operator `^` (read "set `AV`")  
Copies the value in the current cell into the `active vault`.

- Operator `*` (read "get `AV`")  
Copies the value from the `active vault` into the current cell.

- Characters `{` and `}`  
Simply for multi-line comments. Multi-line comments begin with `#{` and end with `}#`. Nested multi-line comments are not supported/allowed.

#### 3. Motivation:
Brainfuck++ adds a few "quality of life" additions to the original brainfuck language whilst keeping in the spirit of its esoteric, hardcore nature.  
Designed for building bigger projects in the future in a brainfuck-esque language for the memes. Goal is to one day make a brainfuck++ powered operating system.
Implemented in Java. Goal is to hide this implementation detail more in the future.

#### 4. Code structure:
To execute, run Repl.java.

The code for this language is put on a github directly from being an intelliJ project. But it is very easy to grab the source java code files from the 'src' folder and compile and run them without intelliJ.

#### 5. Date(s):
Plan to improve the front-end user interface of this software further with a deadline of 24th February 2024.

#### 6. Example code
#### TODO: write a hello world program in brainfuck++ beta 1.0 here.

#### 7. Project TODOs:
Many TODOs, namely;  
-> provide easier compiling and executing support for new users.  
-> provide instructions here on how to use the software. (done!)
