	.data
	.string	.int_wformat "%d\12"
	.string	.float_wformat "%f\12"
	.string	.char_wformat "%c\12"
	.string	.string_wformat "%s\12"
	.string	.int_rformat "%d"
	.string	.float_rformat "%f"
	.string	.char_rformat "%c"
	.string	.string_rformat "%s"
	.string	.string_const_0 "Enter: "
	.text
	.frame	main 4
	loadI	.string_const_0  => %vr4
	swrite	%vr4
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	iread	%vr6
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	load	%vr6  => %vr7
	loadI	1  => %vr8
	comp	%vr8 %vr7 => %vr9
	testne	%vr9  => %vr10
	loadI	2  => %vr11
	comp	%vr11 %vr7 => %vr12
	testne	%vr12  => %vr13
	and	%vr10 %vr13 => %vr14
	cbr	%vr14  => .L1
	loadI	0  => %vr15
	iwrite	%vr15
	jumpI	.L0
.L1:	nop
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	load	%vr6  => %vr7
	loadI	3  => %vr16
	comp	%vr16 %vr7 => %vr17
	testne	%vr17  => %vr18
	loadI	4  => %vr19
	comp	%vr19 %vr7 => %vr20
	testne	%vr20  => %vr21
	and	%vr18 %vr21 => %vr22
	cbr	%vr22  => .L2
	loadI	1  => %vr8
	iwrite	%vr8
	jumpI	.L0
.L2:	nop
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	load	%vr6  => %vr7
	loadI	5  => %vr23
	comp	%vr23 %vr7 => %vr24
	testne	%vr24  => %vr25
	cbr	%vr25  => .L3
	loadI	2  => %vr11
	iwrite	%vr11
	jumpI	.L0
.L3:	nop
.L0:	nop
	ret
