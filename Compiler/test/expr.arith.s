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
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -28
	mov	%eax, 15
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 5
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 3
	mov	%ebx, %ebp
	add	%ebx, -4
	sub	%ebx, 8
	mov	dword ptr [%ebx], %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
