grammar example;

program: literal;

//Batch 3

//Batch 2
condition: conjunction ('||' conjunction)*;
conjunction: comparison ('&&' comparison)*;
comparison: operand OP operand | '(' condition ')';
// Batch 1
operand: attribute_name | literal;
literal: STR_LITERAL | INTEGER;

attribute_list: attribute_name (',' attribute_name)*;
typed_attribute_list: attribute_name type (',' attribute_name type)*;
open_cmd: 'OPEN' relation_name;
close_cmd: 'CLOSE' relation_name;
write_cmd: 'WRITE' relation_name;
exit_cmd: 'EXIT';
attribute_name: IDENTIFIER;
relation_name: IDENTIFIER;
type: 'VARCHAR' '(' INTEGER ')' | 'INTEGER';
// Batch 0
OP: '=='| '!=' | '<'| '>' | '<=' | '>=';
IDENTIFIER: ALPHA (ALPHA | DIGIT)*;
STR_LITERAL: '"'(ALPHA | DIGIT) + '"';
INTEGER: POSDIG DIGIT* | '0';
DIGIT:[0-9];
ALPHA:[A-Za-z_];
POSDIG: [1-9];
WS: [ \n\t]->skip;
