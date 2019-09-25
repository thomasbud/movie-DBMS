grammar example;

program: literal;

operand: ATTRIBUTE_NAME | literal;
literal: STR_LITERAL | INTEGER;

ATTRIBUTE_LIST: ATTRIBUTE_NAME (',' ATTRIBUTE_NAME)*;
TYPED_ATTRIBUTE_LIST: ATTRIBUTE_NAME TYPE (',' ATTRIBUTE_NAME TYPE)*;
OPEN_CMD: 'OPEN' RELATION_NAME;
CLOSE_CMD: 'CLOSE' RELATION_NAME;
WRITE_CMD: 'WRITE' RELATION_NAME;
EXIT_CMD: 'EXIT';
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
