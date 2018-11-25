PROGRAM bubble;

 RECORD listnode =
 	i : INTEGER;
	prev, next : listnode
 END;

 VAR list, least, next,node : listnode;
     t:INTEGER;

 FUNCTION newnode(i : INTEGER; prev : listnode) : listnode;
 VAR node : listnode;
 BEGIN
 	node := NEW listnode;
	node.i := i;
	node.next := NIL;
	node.prev := prev;
	IF prev <> NIL THEN
	  prev.next := node;

	RETURN node
 END;

BEGIN
	list := NIL;
	list := newnode(0,NIL);
	node := list;
	t := 1;
	WHILE 1 DO BEGIN
	  node := newnode(t,node);
	  WRITE(t);
	  t := t + 1
	END; 

	node := list;
	WHILE node <> NIL DO BEGIN
          WRITE(node.i);
	  node := node.next
        END
      
END
