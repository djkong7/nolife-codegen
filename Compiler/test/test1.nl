{*********************************************************

This testcase checks subroutine calls, both recursive and
nonrecursive, as well as parameter passing.

*********************************************************}

PROGRAM subprog;
 VAR x,y:INTEGER;

{*main*}
BEGIN
        READ(x);
	x := x + x;
	y := x + 5;
	WRITE(y)
END
