{*********************************************************

This testcase checks subroutine calls, both recursive and
nonrecursive, as well as parameter passing.

*********************************************************}

PROGRAM subprog;
 RECORD listnode = 
 	x :INTEGER;
	next : listnode
 END;

 VAR x:INTEGER;
     l,p,h  :listnode;

{*main*}
BEGIN
	WRITE('Enter values (enter 0 to end)');
        READ(x);
	h := NEW listnode;
	h.x := x;
	h.next := NIL; 
	p := h;
	READ(x);
	WHILE (x <> 0) DO BEGIN
	 l := NEW listnode;
	 l.x := x;
	 l.next := NIL;
	 p.next := l;
	 p := l;
	 READ(x)
       END;
       WRITE('The values are');
       l := h;
       WHILE (l <> NIL) DO BEGIN
       	WRITE(l.x);
	l := l.next
       END
END
