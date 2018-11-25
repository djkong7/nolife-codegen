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

 PROCEDURE swap(node1, node2 : listnode);
 VAR temp : listnode;
 BEGIN
 	node1.prev.next := node2;
	node2.prev := node1.prev;
	node1.next := node2.next;
	node2.next.prev := node1;
	node1.prev := node2;
	node2.next := node1
 END;

BEGIN
	list := newnode(32,NIL);
	node := newnode(11,list);
	node := newnode(111,node);
	node := newnode(88,node);
	node := newnode(11,node);
	node := newnode(44,node);
	node := newnode(33,node);
	node := newnode(33,node);
	node := newnode(22,node);
	node := newnode(77,node);
	node := newnode(45,node);
	node := newnode(65,node);
	node := newnode(76,node);
	node := newnode(87,node);
	node := newnode(34,node); 
	
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
