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
	add	%esp, -32
	mov	%eax, 65
	mov	%ebx, 122
	cmp	%eax, %ebx
	mov	%ecx, -1
	mov	%edx, 0
	cmovg	%edx, %ecx
	push	%edx
	push	offset flat:.int_wformat
	mov	dword ptr [%ebp-28], %eax
	mov	dword ptr [%ebp-32], %ebx
	call	printf
	add	%esp, 8
	mov	%eax, dword ptr [%ebp-32]
	mov	%ebx, dword ptr [%ebp-28]
	cmp	%ebx, %eax
	mov	%eax, -1
	mov	%ebx, 0
	cmovg	%ebx, %eax
	mov	%eax, %ebx
	not	%eax
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 3
	mov	%ebx, %ebp
	add	%ebx, -4
	sub	%ebx, 12
	mov	dword ptr [%ebx], %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
