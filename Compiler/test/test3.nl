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
	  a[i]:= i;
	  i:=i+1
	END
END;

PROCEDURE writearray(z:ARRAY[1..10] OF INTEGER);
BEGIN
	WRITE(z[1]);
	WRITE(z[2]);
	WRITE(z[3]);
	WRITE(z[4]);
	WRITE(z[5]);
	WRITE(z[6]);
	WRITE(z[7]);
	WRITE(z[8]);
	WRITE(z[9]);
	WRITE(z[10])
END;


{*main*}
BEGIN
	init(x);
	writearray(x)
END
