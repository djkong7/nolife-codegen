	.intel_syntax	
	.section	.rodata
.int_wformat:	.string	"%d\12"
.float_wformat:	.string	"%f\12"
.char_wformat:	.string	"%c\12"
.string_wformat:	.string	"%s\12"
.int_rformat:	.string	"%d"
.float_rformat:	.string	"%f"
.char_rformat:	.string	"%c"
.string_rformat:	.string	"%s"
.string_const_0:	.string	"Hello world!"
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	push	offset flat:.string_const_0
	push	offset flat:.string_wformat
	call	printf
	add	%esp, 8
	leave
	ret
