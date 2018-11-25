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
	add	%esp, -52
	mov	%eax, offset flat:main_fp
	mov	dword ptr [%eax], %ebp
	call	b1
	add	%esp, 0
	mov	dword ptr [%ebp-44], %eax
	call	b2
	add	%esp, 0
	mov	dword ptr [%ebp-48], %eax
	call	b3
	add	%esp, 0
	mov	dword ptr [%ebp-52], %eax
	call	b4
	add	%esp, 0
	mov	%ebx, dword ptr [%ebp-52]
	add	%eax, %ebx
	mov	%ebx, dword ptr [%ebp-48]
	add	%eax, %ebx
	mov	%ebx, dword ptr [%ebp-44]
	add	%eax, %ebx
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
	.globl	b1;
	.type	b1, @function
b1:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 1
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 1
	leave
	ret
	.globl	b2;
	.type	b2, @function
b2:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 2
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	call	b1
	add	%esp, 0
	leave
	ret
	.globl	b3;
	.type	b3, @function
b3:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	mov	%eax, 3
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	call	b1
	add	%esp, 0
	mov	dword ptr [%ebp-4], %eax
	call	b2
	add	%esp, 0
	mov	%ebx, dword ptr [%ebp-4]
	add	%eax, %ebx
	leave
	ret
	.globl	b4;
	.type	b4, @function
b4:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -8
	mov	%eax, 4
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	call	b1
	add	%esp, 0
	mov	dword ptr [%ebp-4], %eax
	call	b2
	add	%esp, 0
	mov	dword ptr [%ebp-8], %eax
	call	b3
	add	%esp, 0
	mov	%ebx, dword ptr [%ebp-8]
	add	%eax, %ebx
	mov	%ebx, dword ptr [%ebp-4]
	add	%eax, %ebx
	leave
	ret
