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
.float_const_1:	.float	2.2
.float_const_2:	.float	3.3
.float_const_3:	.float	4.4
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -16
	mov	%eax, offset flat:.float_const_0
	movss	%xmm0, dword ptr [%eax]
	mov	%eax, offset flat:.float_const_1
	movss	%xmm1, dword ptr [%eax]
	mov	%eax, offset flat:.float_const_2
	movss	%xmm2, dword ptr [%eax]
	mov	%eax, offset flat:.float_const_3
	movss	%xmm3, dword ptr [%eax]
	movss	%xmm4, %xmm2
	addss	%xmm4, %xmm3
	movss	%xmm5, %xmm1
	addss	%xmm5, %xmm4
	movss	%xmm4, %xmm0
	addss	%xmm4, %xmm5
	sub	%esp, 8
	movss	dword ptr [%esp], %xmm4
	fld	dword ptr [%esp]
	fstp	qword ptr [%esp]
	push	offset flat:.float_wformat
	movss	dword ptr [%ebp-4], %xmm0
	movss	dword ptr [%ebp-8], %xmm1
	movss	dword ptr [%ebp-12], %xmm2
	movss	dword ptr [%ebp-16], %xmm3
	call	printf
	add	%esp, 12
	mov	%eax, 15
	cvtsi2ss	%xmm0, %eax
	movss	%xmm1, dword ptr [%ebp-12]
	movss	%xmm2, dword ptr [%ebp-16]
	addss	%xmm1, %xmm2
	movss	%xmm2, dword ptr [%ebp-8]
	movss	%xmm3, %xmm2
	addss	%xmm3, %xmm1
	movss	%xmm1, dword ptr [%ebp-4]
	movss	%xmm4, %xmm1
	addss	%xmm4, %xmm3
	addss	%xmm0, %xmm4
	sub	%esp, 8
	movss	dword ptr [%esp], %xmm0
	fld	dword ptr [%esp]
	fstp	qword ptr [%esp]
	push	offset flat:.float_wformat
	movss	dword ptr [%ebp-4], %xmm1
	movss	dword ptr [%ebp-8], %xmm2
	call	printf
	add	%esp, 12
	movss	%xmm0, dword ptr [%ebp-4]
	cvttss2si	%eax, %xmm0
	movss	%xmm0, dword ptr [%ebp-8]
	cvttss2si	%ebx, %xmm0
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovl	%ebx, %eax
	mov	%eax, %ebx
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
