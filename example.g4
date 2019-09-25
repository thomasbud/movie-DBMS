grammar example;

program: literal;

operand: ATTRIBUTE_NAME | literal;
literal: STR_LITERAL | INTEGER;

ATTRIBUTE_LIST: ATTRIBUTE_NAME (',' ATTRIBUTE_NAME)*;
ATTRIBUTE_NAME: IDENTIFIER;
RELATION_NAME: IDENTIFIER;
OP: '=='| '!=' | '<'| '>' | '<=' | '>=';
TYPE: 'VARCHAR' (INTEGER) | 'INTEGER';
IDENTIFIER: ALPHA (ALPHA | DIGIT)*;
STR_LITERAL: '"'(ALPHA | DIGIT) + '"';
INTEGER: POSDIG DIGIT* | '0';
DIGIT:[0-9];
ALPHA:[A-Za-z_];
POSDIG: [1-9];
WS: [ \n\t]->skip;