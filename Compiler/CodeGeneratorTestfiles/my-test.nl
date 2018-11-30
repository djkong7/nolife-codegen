{** $awkdoc$ ********************************************************

A version of quicksort for testing recursion: reads and sorts
19 INTEGER.

** $endawk$ ********************************************************}

PROGRAM qs;
VAR  A:  ARRAY [0..20] OF INTEGER;
	
	PROCEDURE  readarray;
	VAR  i:  INTEGER;
	BEGIN
		WRITE ('A?');
		i := 1;
		WHILE i < 20 DO
		BEGIN
			WRITE (i);
			READ (A[i]);
			i := i + 1
		END
	END;
	
	
	
BEGIN
	A[0] := 0-1; A[20] :=  1000;  { book does this; don't know why }
	readarray()

END
