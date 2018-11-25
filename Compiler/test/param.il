	.data
	.string	.int_wformat "%d\12"
	.string	.float_wformat "%f\12"
	.string	.char_wformat "%c\12"
	.string	.string_wformat "%s\12"
	.string	.int_rformat "%d"
	.string	.float_rformat "%f"
	.string	.char_rformat "%c"
	.string	.string_rformat "%s"
	.global	main_fp 4 4
	.text
	.frame	main 12
	loadI	main_fp  => %vr4
	store	%vr0  => %vr4
	loadI	1  => %vr5
	loadI	-8  => %vr6
	add	%vr0 %vr6 => %vr7
	store	%vr5  => %vr7
	loadI	2  => %vr8
	i2i	%vr8  => %vr7
	loadI	3  => %vr9
	i2i	%vr9  => %vr8
	loadI	4  => %vr10
	i2i	%vr10  => %vr9
	loadI	1  => %vr5
	i2i	%vr5  => %vr4
	loadI	2  => %vr8
	i2i	%vr8  => %vr5
	loadI	3  => %vr9
	loadI	-4  => %vr11
	add	%vr0 %vr11 => %vr12
	store	%vr9  => %vr12
	loadI	4  => %vr10
	i2i	%vr10  => %vr6
	loadI	-4  => %vr11
	add	%vr0 %vr11 => %vr12
	icall	b4 %vr12 	 => %vr13
	iwrite	%vr13
	loadI	-8  => %vr6
	add	%vr0 %vr6 => %vr7
	call	d1 %vr7 
	loadI	-8  => %vr6
	add	%vr0 %vr6 => %vr7
	load	%vr7  => %vr14
	iwrite	%vr14
	loadI	1  => %vr5
	loadI	-12  => %vr15
	add	%vr0 %vr15 => %vr16
	store	%vr5  => %vr16
	icall	b4 %vr16 	 => %vr17
	loadI	-12  => %vr15
	add	%vr0 %vr15 => %vr16
	store	%vr17  => %vr16
	icall	b4 %vr16 	 => %vr17
	iwrite	%vr17
	ret
	.frame	b4 0 %vr12
	loadI	4  => %vr13
	iwrite	%vr13
	load	%vr12  => %vr14
	loadI	1  => %vr15
	add	%vr14 %vr15 => %vr16
	iret	%vr16
	.frame	d2 0 %vr4 %vr5
	load	%vr5  => %vr7
	iwrite	%vr7
	load	%vr4  => %vr8
	iwrite	%vr8
	load	%vr4  => %vr8
	i2i	%vr8  => %vr6
	load	%vr5  => %vr7
	store	%vr7  => %vr4
	store	%vr6  => %vr5
	ret
	.frame	d3 0 %vr4 %vr5 %vr6 %vr7
	load	%vr4  => %vr8
	loadI	1  => %vr9
	add	%vr8 %vr9 => %vr10
	store	%vr10  => %vr4
	load	%vr5  => %vr11
	loadI	2  => %vr12
	add	%vr11 %vr12 => %vr13
	store	%vr13  => %vr5
	load	%vr6  => %vr14
	loadI	3  => %vr15
	add	%vr14 %vr15 => %vr16
	store	%vr16  => %vr6
	load	%vr7  => %vr17
	store	%vr17  => %vr7
	ret
	.frame	d1 4 %vr4
	load	%vr4  => %vr5
	loadI	200  => %vr6
	mult	%vr5 %vr6 => %vr7
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	store	%vr7  => %vr9
	load	%vr4  => %vr5
	iwrite	%vr5
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	load	%vr9  => %vr10
	iwrite	%vr10
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	call	d2 %vr4 %vr9 
	load	%vr4  => %vr5
	iwrite	%vr5
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	load	%vr9  => %vr10
	iwrite	%vr10
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	call	d3 %vr4 %vr4 %vr4 %vr9 
	load	%vr4  => %vr5
	iwrite	%vr5
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	load	%vr9  => %vr10
	iwrite	%vr10
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	call	d3 %vr9 %vr9 %vr9 %vr9 
	load	%vr4  => %vr5
	iwrite	%vr5
	loadI	-4  => %vr8
	add	%vr0 %vr8 => %vr9
	load	%vr9  => %vr10
	iwrite	%vr10
	ret
