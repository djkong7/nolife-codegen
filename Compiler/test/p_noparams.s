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
	.comm	main_fp,4,4
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -16
	mov	%eax, offset flat:main_fp
	mov	dword ptr [%eax], %ebp
	call	a1
	add	%esp, 0
	call	a2
	add	%esp, 0
	call	a3
	add	%esp, 0
	call	a4
	add	%esp, 0
	leave
	ret
	.globl	a1;
	.type	a1, @function
a1:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 1
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
	.globl	a2;
	.type	a2, @function
a2:	push	%ebp
	mov	%ebp, %esp
	call	a1
	add	%esp, 0
	mov	%eax, 2
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
	.globl	a3;
	.type	a3, @function
a3:	push	%ebp
	mov	%ebp, %esp
	call	a1
	add	%esp, 0
	call	a2
	add	%esp, 0
	mov	%eax, 3
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
	.globl	a4;
	.type	a4, @function
a4:	push	%ebp
	mov	%ebp, %esp
	call	a1
	add	%esp, 0
	call	a2
	add	%esp, 0
	call	a3
	add	%esp, 0
	mov	%eax, 4
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
