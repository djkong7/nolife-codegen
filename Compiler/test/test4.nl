{*********************************************************

This testcase checks subroutine calls, both recursive and
nonrecursive, as well as parameter passing.

*********************************************************}

PROGRAM subprog;
 VAR x:ARRAY[1..10] OF INTEGER;

{* pass array as parm *}

PROCEDURE init (a:ARRAY[1..10] OF INTEGER);
VAR i:INTEGER;
BEGIN
	i:=1;
	WHILE i<=10 DO BEGIN
	  a[i]:= (i*0.01) + i;
	  i:=i+1
	END
END;

{*main*}
BEGIN
	init(x);
	WRITE(x[3])
END
