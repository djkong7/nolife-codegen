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
.float_const_0:	.float	0.01
	.comm	main_fp,4,4
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -72
	mov	%eax, offset flat:main_fp
	mov	dword ptr [%eax], %ebp
	mov	%eax, -36
	mov	%ebx, %ebp
	add	%ebx, %eax
	push	%ebx
	call	init
	add	%esp, 4
	mov	%eax, -36
	mov	%ebx, %ebp
	add	%ebx, %eax
	push	%ebx
	call	writearray
	add	%esp, 4
	mov	%eax, 1
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovg	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L0
.L1:	nop
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, %ebp
	mov	%ecx, -36
	add	%ebx, %ecx
	mov	%ecx, 1
	sub	%eax, %ecx
	mov	%ecx, 4
	imul	%eax, %ecx
	sub	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	imul	%eax, %ebx
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	%ecx, %ebp
	mov	%edx, -36
	add	%ecx, %edx
	mov	%edx, 1
	sub	%ebx, %edx
	mov	%edx, 4
	imul	%ebx, %edx
	sub	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, %ebp
	mov	%ecx, -36
	add	%ebx, %ecx
	mov	%ecx, 1
	sub	%eax, %ecx
	mov	%ecx, 4
	imul	%eax, %ecx
	sub	%ebx, %eax
	push	%ebx
	call	inc
	add	%esp, 4
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 1
	add	%eax, %ebx
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovle	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L1
.L0:	nop
	mov	%eax, -36
	mov	%ebx, %ebp
	add	%ebx, %eax
	push	%ebx
	call	writearray
	add	%esp, 4
	leave
	ret
	.globl	init;
	.type	init, @function
init:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -8
	mov	%eax, 1
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, 10
	mov	%ebx, -8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovg	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L2
.L3:	nop
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	cvtsi2ss	%xmm0, %eax
	mov	%eax, offset flat:.float_const_0
	movss	%xmm1, dword ptr [%eax]
	mulss	%xmm0, %xmm1
	mov	%eax, -8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	cvtsi2ss	%xmm1, %eax
	addss	%xmm0, %xmm1
	cvttss2si	%eax, %xmm0
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	%ecx, 1
	sub	%ebx, %ecx
	mov	%ecx, 4
	imul	%ebx, %ecx
	mov	%ecx, 8
	mov	%edx, %ebp
	add	%edx, %ecx
	mov	%ecx, dword ptr [%edx]
	sub	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 1
	add	%eax, %ebx
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 1
	add	%eax, %ebx
	mov	%ebx, -8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovle	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L3
.L2:	nop
	leave
	ret
	.globl	writearray;
	.type	writearray, @function
writearray:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 1
	mov	%ebx, %eax
	sub	%ebx, %eax
	mov	%eax, 4
	imul	%ebx, %eax
	mov	%eax, 8
	mov	%ecx, %ebp
	add	%ecx, %eax
	mov	%eax, dword ptr [%ecx]
	sub	%eax, %ebx
	push	dword ptr [%eax]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 2
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 3
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 4
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 5
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 6
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 7
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 8
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 9
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 10
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, 4
	imul	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
	.globl	inc;
	.type	inc, @function
inc:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 1
	add	%eax, %ebx
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	dword ptr [%ebx], %eax
	leave
	ret
