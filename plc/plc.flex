import java_cup.runtime.*;
%%   
%cup 
%%

    "+"                         { return new Symbol(sym.MAS); }
    "-"                         { return new Symbol(sym.MENOS); }
    "*"                         { return new Symbol(sym.POR); }
    "/"                         { return new Symbol(sym.DIV); }
    "("                         { return new Symbol(sym.AP); }
    ")"                         { return new Symbol(sym.CP); }
    "{"                         { return new Symbol(sym.ALL); }
    "}"                         { return new Symbol(sym.CLL); }
    ";"                         { return new Symbol(sym.PYC); }
    "="				{ return new Symbol(sym.ASIG); }
    "=="                        { return new Symbol(sym.EQ); }
    "<"				{ return new Symbol(sym.MEN); }
    "<="			{ return new Symbol(sym.MEOI); }
    ">"				{ return new Symbol(sym.MAY); }
    ">="			{ return new Symbol(sym.MAOI); }
    "!="                        { return new Symbol(sym.NEQ); }
    "!"                         { return new Symbol(sym.NOT); }
    "if"			{ return new Symbol(sym.IF,Generator.getLabel()); }
    "else"			{ return new Symbol(sym.ELSE); }
    "&&"			{ return new Symbol(sym.AND); }
    "||"			{ return new Symbol(sym.OR); }

"print" 			{ return new Symbol(sym.PRINT); }
"for"				{ return new Symbol(sym.FOR,Generator.getLabel());}
"while" 			{ return new Symbol(sym.WHILE,Generator.getLabel());}
"do"				{ return new Symbol(sym.DO,Generator.getLabel());}
0|[1-9][0-9]*               	{ return new Symbol(sym.ENTERO, new String(yytext()) ); }
[_a-zA-Z][_a-zA-Z0-9]*          { return new Symbol(sym.IDENT, yytext()); }
\ |\t\f                     	{  }
[^]			    	{  }
