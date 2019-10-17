grammar rules;

//program: literal;
program : (query | command)*;

// Batch 5
command : open_cmd | close_cmd | write_cmd | exit_cmd | show_cmd |create_cmd | update_cmd | insert_cmd | delete_cmd;
query : relation_name '<-' expr;

// Batch 4
show_cmd : 'SHOW' atomic_expr;
create_cmd : 'CREATE TABLE' relation_name '(' typed_attribute_list ')' 'PRIMARY KEY' '(' attribute_list ')';
update_cmd : 'UPDATE' relation_name 'SET '  attribute_name '='  literal (',' attribute_name '=' literal)*  'WHERE' '(' condition ')';
insert_cmd 	: 'INSERT INTO' relation_name 'VALUES FROM' '(' literal ( ',' literal)* ')' | 'INSERT INTO' relation_name'VALUES FROM RELATION' expr;
delete_cmd 	: 'DELETE FROM' relation_name 'WHERE' '(' condition ')';

//Batch 3
expr : atomic_expr | selection | projection | renaming | union | difference | product | natural_join;
atomic_expr : relation_name | '(' expr ')';
selection : 'select' '(' condition ')' atomic_expr;
projection: 'project' '(' attribute_list ')' atomic_expr;
renaming : 'rename' '(' attribute_list ')' atomic_expr;
union : atomic_expr '+' atomic_expr; // using shunting algorithm
difference : atomic_expr '-' atomic_expr;
product : atomic_expr '*' atomic_expr;
natural_join: atomic_expr '&' atomic_expr;




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