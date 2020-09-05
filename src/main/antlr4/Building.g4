grammar Building;

@header {
    package building.antlr;
}

program : importStatement*  (shapeDeclaration | assignment SEMICOLON | plotDecl)* EOF;

importStatement : 'import' STRING 'as' NAME SEMICOLON;

plotDecl : 'plot' arguments '->' qualifiedName;

shapeDeclaration : NAME '->' polyStatements ;

polyStatements : polyCommand SEMICOLON polyStatements #polyStatementsMultiple
               | polyCommand SEMICOLON? #polyStatementSingle
               | polyFinalCommand SEMICOLON? #polyStatementFinal;

polyCommand : simpleCommand arguments #polyCommandSimple
            | assignment #polyCommandAssignment;


simpleCommand : 'color' | 'translate' | 'translateG' | 'rotateX' | 'rotateY' | 'rotateZ' | 'rotatePX' | 'rotatePY' | 'rotatePZ' | 'scale' | 'polygon' | 'oshape' | 'lshape';

assignment : qualifiedVariable ASSIGN expression;

qualifiedName : qualifier NAME;
qualifiedVariable : qualifier VARIABLE;

qualifier : (NAME (DOT NAME)* DOT)?;

polyFinalCommand : qualifiedName #polyCommandName
                 | extrudeCommand #polyExtrudeCommand
                 | splitCommand #polySplitCommand
                 | ifCommand #polyIfCommand;

extrudeCommand : 'extrude' arguments #extrudeSimple
               | 'extrude' arguments LBRACE faceDecl (COMMA faceDecl)* RBRACE #extrudeFull;


faceDecl : FACE COLON enclosedPolystatements;

enclosedPolystatements : polyStatements | qualifiedName;

splitCommand : 'split' LPAREN AXIS RPAREN LBRACE splitDecl (COMMA splitDecl)*  RBRACE splitRepeating?;

splitRepeating : ASTERIX;

splitDecl : expression COLON enclosedPolystatements;

arguments : LPAREN expression (COMMA expression)* RPAREN;

ifCommand : 'if' LPAREN expression RPAREN LBRACE polyStatements RBRACE LBRACE polyStatements RBRACE;

expression : LPAREN expression RPAREN #expressionPar
           | expression op=(ASTERIX | DIVIDE | PERCENTAGE) expression #expressionMulDivMod
           | expression op=(PLUS | MINUS) expression #expressionAddSub
           | expression op=(EQUALS | NOT_EQUALS) expression #expressionEqNeq
           | LPAREN expression COMMA expression RPAREN #expressionPair
           | value #expressionVal
           | qualifiedVariable arguments #expressionFunctionCall;


value : 'true' #valTrue
      | 'false' #valFalse
      | NUMBER #valNumber
      | STRING #valString
      | NUMBER PERCENTAGE #valPercentage
      | TILDE NUMBER #valFraction
      | VARIABLE #valVariable;

AXIS : [xyzXYZ];
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
TILDE: '~';
RBRACE : '}';
PERCENTAGE : '%';
COMMA : ',';
NUMBER : '-'?('0'|[1-9][0-9]*|[0-9]+DOT[0-9]+);
FACE : 'TOP'|'BOTTOM'|'SIDE';
ASTERIX: '*';
COLON: ':';
DOT : '.';
SEMICOLON : ';';
NAME : [A-Z][a-zA-Z0-9_]*;
VARIABLE : [a-z_][a-zA-Z0-9_]*;
WS : (' ' | '\t' | '\n' )+ -> channel(HIDDEN);
STRING : '"' ('\\' ["\\] | ~["\\\r\n])* '"' ;
PLUS : '+';
MINUS : '-';
DIVIDE : '/';
EQUALS : '==';
NOT_EQUALS : '!=';
ASSIGN : ':=';