# Product Backlog

## US-1 Basic RPN Calculator
As an international accountant 
I need a simple RPN (Reverse Polish Notation) adding machine 
so that I can easily manage my clients books.

### Acceptance Criteria
    1:  All values and operators are delimited by whitespace.
    2:  Accepts a continuous stream of values and operators.
    3:  Supports operations for sum, difference, division, multiplication.
    4:  Supports floating point operations.
    5:  Console input processed after every 'enter' key-press.
    6:  When an operator is read
          -  Output the list of all remaining values entered followed by the operator 
          -  Perform the operation
          -  Display the resulting list of values awaiting further operators.
      
## US-2 Advanced Mathematical Operations
As an international accountant 
I need my RPN Adding Machine to support advanced math operations 
so that I can handle complex record keeping for the Chicago Mafia.

### Acceptance Criteria
    1:  Use '^' for exponent operator. values entered as "X Y ^" are calculated as X to the power of Y.
    2:  Use '%' for the percent operation.  values entered as "X%" or "X %" are calculated as X/100.
    3:  Use ‘!’ for Factorial (unary operation).

## US-3 Stack Operations
As an international Account 
I need my RPN Adding Machine to support stack operations 
so that I can manage the list of values and correct my entry mistakes.

### Acceptance Criteria
    1:  Function names are not case sensitive.
    2:  "SWAP" changes the order of the last two entries in the values list.
    3:  "DROP" removes the last entry from the list.
    4:  "CLEAR" wipes out the entire entry list.
    5:  "ROLL" rotates the last entry in the list to the first entry in the list.

## US-4 Multi-Format Operand support
As an international accountant 
I need my RPN Adding Machine to interpret various number systems as they are entered 
 so that I can pay less attention to how to enter the numbers and simply get work done as efficiently as possible.

### Acceptance Criteria
    1:  Values are interpreted as they are entered to validate format.
    2:  Values are interpreted as they are consumed by operations.
    3:  Results are displayed in the format of the last values format in the list prior to the operation.

## US-5
As an international accountant 
I need my RPN Adding Machine to accept Roman Numerals 
so that I can support my clients in the Vatican.

### Acceptance Criteria
    1:  Can interpret strings [I, II, III, IV ... IX... XX... XL, L... C... D... M].
    2:  Results are displayed in proper roman numerals.
    3:  Integer values only.
    4:  Input is case insensitive.
    5:  Output is in upper case.

## US-6 Roman Numeral Large Value Support
As an accountant for the Vatican 
I need to manage numbers larger than MMMM 
so that I can manage the books for my more wealthy clients.

### Acceptance Criteria
    Support bar symbology to represent ‘multiply by M  (1,000)‘.

## US-7 Roman Numeral Operand Supports Monetary Data Values 
As a Vatican client 
I need my Roman accounting books to maintain proper financial precision to 1/1000 
so that I can satisfy the International Auditors Association.

### Acceptance Criteria
    1:  Roman Numeral Operand supports floating point values.
    2:  Operand symbology must be easily human readable form. [i.e. radix must be in similar form as mantissa].
    3:  Operand symbology must support ease of data entry.


## US-8 Hex Operand
As an international accountant 
I need my RPN Adding Machine to accept Hexadecimal values 
so that I can support my engineering clients.

### Acceptance Criteria
    1:  Interprets multi digit values [0-9,A-F]* preceded with '0x' as hexadecimal.
    2:  Integer values only.
    3:  Is case insensitive.


## US-9 Hex Operand Supports Monetary Data Values
As an engineering client 
I need my accounting books to maintain proper financial precision to 1/1000 
so that I can satisfy the International Auditors Association.

### Acceptance Criteria
    1:  Hexadecimal Operand supports floating point values.
    2:  Operand symbology must be easily human readable form. [i.e. radix must be in similar form as mantissa].
    3:  Operand symbology must support ease of data entry.

## US-10 Octal Operand
As an international accountant 
I need my RPN Adding Machine to accept Octal values 
so that I can support my engineering clients.

### Acceptance Criteria
    1:  Interpret multi digit values [0-8]* preceded with '0o' as Octal.
    2:  Integer values only.
    3:  Is case insensitive.

## US-11 Octal Operand Supports Monetary Data Values 
As an engineering professor 
I need my accounting books to maintain proper financial precision to 1/1000 
so that I can satisfy the Collegiate Auditors Association.

### Acceptance Criteria
    1:  Octal Operand supports floating point values.
    2:  Operand symbology must be easily human readable form. [i.e. radix must be in similar form as mantissa].
    3:  Operand symbology must support ease of data entry.

## US-12 Binary Operand
As an international accountant I need my RPN Adding Machine to accept Binary values so that I can support my computer science clients.

### Acceptance Criteria
    1:  Interpret multi digit values [0-8]* preceded with '0b' as Binary.
    2:  Integer values only.
    3:  Is case insensitive.
