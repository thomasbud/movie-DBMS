grammar example;

program: literal;

literal: (STR_LITERAL | INTEGER)+;

OP: '==' | '!=' | '<' | '>' | '<=' | '>=';
DIGIT: [0-9];
ALPHA: [A-Za-z_];
POSDIG: [1-9];
INTEGER: POSDIG DIGIT*;
IDENTIFIER: ALPHA (ALPHA | POSDIG)*;
STR_LITERAL: '"'(ALPHA | POSDIG)+'"';

WS: [ \n\t]->skip;