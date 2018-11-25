{ **** the canonical C program, redone in a brain-dead language **** }
{ **** contributed by the labbies (again, in past years)        **** }

PROGRAM hello;

VAR x,y:ARRAY [1..30] OF INTEGER;

BEGIN
	x[1] := y[1] + 5;
	x[1] := y[1] + x[1];
	WRITE(x[1])
END
