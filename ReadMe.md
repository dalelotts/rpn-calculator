# RPN Calculator

Java starter project for Scrum Developer (XP) 101 training. 

[![MIT License][license-image]][license-url]

This project was written using Pair Programming & TDD. As a result, all enhancements and changes have related tests.

NB: The master branch is the starting point for the training, there is only one test, and it fails. This is by design. 
Explore the other branches see the different states of the code.

See the [Product Backlog](ProductBacklog.md) for details about which features are needed.

# New to Git?
See the [Git cheat sheet](https://training.github.com/kit/downloads/github-git-cheat-sheet.pdf) for details.

# PostFix, InFix, Operator & Operand Definitions:

In all computer languages, expressions consist of two types of components: 
Operands and Operators. 

Operands are the objects that are manipulated and operators are the symbols that represent specific actions. 
For example, in the expression

```
5 + 9
```

9 and 5 are operands and + is an operator. 
All expressions have at least one operand. 

## Infix:  
Infix calculators expect two operands separated by an operator:

```
5 + 9
```

the result of which = 14.

## Postfix
In Postfix, or RPN, the operators follow the operands:

```
5 9 +
```

the result of which = 14.

For order dependent functions the top operand is Y, the next operand is X:

```
5 9 -
```

operator = '-'
X = '5'
Y = '9'

POSTFIX(X Y -)  ==  INFIX(X - Y)  ==  INFIX(5 - 9)  ==  -4

# Environment
 * Git 2.6.2 or higher
 * Java 1.8 or higher
 * Gradle 2.8 or higher
 
# Dependencies
 * JMockit 1.20 or higher
 * JUnit 4.12 or higher

# Usage

## Build and Test
This project uses Gradle. To build and test the code run the following command:

```
gradle build
```

## Run Tests
```
gradle test
java -j
```

The html report of the test results is ./build/reports/index.html

#Run Jar
To jar and run the calculator run the following commands:

```
gradle jar
java -jar ./build/libs/calculator-1.0-SNAPSHOT.jar 
```

## License

rpn-calculator is released under the MIT license and is copyright 2015 Dale Lotts. Boiled down to smaller chunks, it can be described with the following conditions.

## It requires you to:

* Keep the license and copyright notice included in rpn-calculator java and other source files when you use them in your works

## It permits you to:

* Freely download and use rpn-calculator, in whole or in part, for personal, private, company internal, or commercial purposes
* Use rpn-calculator in packages or distributions that you create
* Modify the source code
* Grant a sublicense to modify and distribute rpn-calculator to third parties not included in the license

## It forbids you to:

* Hold the authors and license owners liable for damages as rpn-calculator is provided without warranty
* Hold the creators or copyright holders of rpn-calculator liable
* Redistribute any piece of rpn-calculator without proper attribution
* Use any marks owned by Dale Lotts in any way that might state or imply that Dale Lotts endorses your distribution
* Use any marks owned by Dale Lotts in any way that might state or imply that you created the Dale Lotts software in question

## It does not require you to:

* Include the source of rpn-calculator itself, or of any modifications you may have made to it, in any redistribution you may assemble that includes it
* Submit changes that you make to rpn-calculator back to the rpn-calculator project (though such feedback is encouraged)

The full rpn-calculator license is located [in the project repository](https://github.com/dalelotts/rpn-calculator/blob/master/LICENSE) for more information.

[license-image]: http://img.shields.io/badge/license-MIT-blue.svg?style=flat
[license-url]: LICENSE
