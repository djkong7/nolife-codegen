PROGRAM bubble;

 RECORD listnode =
 	i : INTEGER;
	next : listnode
 END;

 VAR list, node, least, next : listnode;
     t:INTEGER;

BEGIN
	list := NEW listnode;
	list.i := 32;
	list.next := NEW listnode;
	node := list.next;
	node.i := 11;
	node.next := NEW listnode;
	node := node.next;
	node.i := 111;
	node.next := NEW listnode;
	node := node.next;
	node.i := 88;
	node.next := NEW listnode;
	node := node.next;
	node.i := 11;
	node.next := NEW listnode;
	node := node.next;
	node.i := 44;
	node.next := NEW listnode;
	node := node.next;
	node.i := 33;
	node.next := NEW listnode;
	node := node.next;
	node.i := 33;
	node.next := NEW listnode;
	node := node.next;
	node.i := 22;
	node.next := NEW listnode;
	node := node.next;
	node.i := 77;
	node.next := NEW listnode;
	node := node.next;
	node.i := 45;
	node.next := NEW listnode;
	node := node.next;
	node.i := 65;
	node.next := NEW listnode;
	node := node.next;
	node.i := 76;
	node.next := NEW listnode;
	node := node.next;
	node.i := 87;
	node.next := NEW listnode;
	node := node.next;
	node.i := 34;
	node.next := NIL;
	
	node := list;

	WHILE node.next <> NIL DO BEGIN
          least := node;
	  next := node.next;
	  WHILE next <> NIL DO BEGIN
            IF next.i < least.i THEN 
              least := next;
	    next := next.next
	  END;
          t := node.i;
          node.i := least.i;
          least.i := t;
          node := node.next
	END;

	node := list;
	WHILE node <> NIL DO BEGIN
          WRITE(node.i);
	  node := node.next
        END
      
END
