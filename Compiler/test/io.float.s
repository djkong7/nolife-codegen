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
.float_const_0:	.float	1.1
.float_const_1:	.float	110000.0
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, offset flat:.float_rformat
	push	%eax
	push	%ebx
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	movss	%xmm0, dword ptr [%eax]
	mov	%eax, offset flat:.float_wformat
	sub	%esp, 8
	movss	dword ptr [%esp], %xmm0
	fld	dword ptr [%esp]
	fstp	qword ptr [%esp]
	push	%eax
	call	printf
	add	%esp, 12
	mov	%eax, offset flat:.float_const_0
	movss	%xmm0, dword ptr [%eax]
	mov	%eax, offset flat:.float_wformat
	sub	%esp, 8
	movss	dword ptr [%esp], %xmm0
	fld	dword ptr [%esp]
	fstp	qword ptr [%esp]
	push	%eax
	call	printf
	add	%esp, 12
	mov	%eax, offset flat:.float_const_1
	movss	%xmm0, dword ptr [%eax]
	mov	%eax, offset flat:.float_wformat
	sub	%esp, 8
	movss	dword ptr [%esp], %xmm0
	fld	dword ptr [%esp]
	fstp	qword ptr [%esp]
	push	%eax
	call	printf
	add	%esp, 12
	leave
	ret
