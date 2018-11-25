	.data
	.string	.int_wformat "%d\12"
	.string	.float_wformat "%f\12"
	.string	.char_wformat "%c\12"
	.string	.string_wformat "%s\12"
	.string	.int_rformat "%d"
	.string	.float_rformat "%f"
	.string	.char_rformat "%c"
	.string	.string_rformat "%s"
	.text
	.frame	main 4
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	iread	%vr6
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	load	%vr6  => %vr7
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	load	%vr6  => %vr7
	add	%vr7 %vr7 => %vr8
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	store	%vr8  => %vr6
	loadI	-4  => %vr5
	add	%vr0 %vr5 => %vr6
	load	%vr6  => %vr7
	loadI	5  => %vr9
	add	%vr7 %vr9 => %vr10
	loadI	0  => %vr11
	add	%vr0 %vr11 => %vr12
	store	%vr10  => %vr12
	loadI	0  => %vr11
	add	%vr0 %vr11 => %vr12
	load	%vr12  => %vr13
	iwrite	%vr13
	ret
