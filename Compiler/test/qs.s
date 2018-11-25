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
.string_const_0:	.string	"A?"
.string_const_1:	.string	"A:"
.float_const_0:	.float	1.7
	.comm	main_fp,4,4
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -92
	mov	%eax, offset flat:main_fp
	mov	dword ptr [%eax], %ebp
	mov	%eax, -1
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, 1000
	sub	%ebx, 80
	mov	dword ptr [%ebx], %eax
	call	readarray
	add	%esp, 0
	call	writearray
	add	%esp, 0
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, 1
	mov	%ecx, %ebp
	add	%ecx, -88
	mov	dword ptr [%ecx], %ebx
	mov	%ebx, 19
	mov	%edx, %ebp
	add	%edx, -92
	mov	dword ptr [%edx], %ebx
	push	%eax
	push	%ecx
	push	%edx
	call	quicksort
	add	%esp, 12
	call	writearray
	add	%esp, 0
	leave
	ret
	.globl	readarray;
	.type	readarray, @function
readarray:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	push	offset flat:.string_const_0
	push	offset flat:.string_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 20
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovge	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L0
.L1:	nop
	mov	%eax, %ebp
	add	%eax, -4
	push	dword ptr [%eax]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:main_fp
	mov	%ebx, dword ptr [%ebx]
	add	%ebx, -4
	imul	%eax, 4
	sub	%ebx, %eax
	push	%ebx
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	add	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 20
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovl	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L1
.L0:	nop
	leave
	ret
	.globl	writearray;
	.type	writearray, @function
writearray:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	push	offset flat:.string_const_1
	push	offset flat:.string_wformat
	call	printf
	add	%esp, 8
	mov	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 20
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovge	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L2
.L3:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:main_fp
	mov	%ebx, dword ptr [%ebx]
	add	%ebx, -4
	imul	%eax, 4
	sub	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	add	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 20
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovl	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L3
.L2:	nop
	leave
	ret
	.globl	partition;
	.type	partition, @function
partition:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -20
	mov	%eax, 12
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 0
	imul	%eax, 4
	mov	%ecx, 16
	mov	%edx, %ebp
	add	%edx, %ecx
	mov	%ecx, dword ptr [%edx]
	sub	%ecx, %eax
	mov	%eax, dword ptr [%ecx]
	mov	%ecx, %ebp
	add	%ecx, -12
	mov	dword ptr [%ecx], %eax
	mov	%eax, 12
	mov	%ecx, %ebp
	add	%ecx, %eax
	mov	%eax, dword ptr [%ecx]
	mov	%eax, dword ptr [%eax]
	sub	%eax, 1
	mov	%ecx, %ebp
	add	%ecx, -4
	mov	dword ptr [%ecx], %eax
	mov	%eax, 8
	mov	%ecx, %ebp
	add	%ecx, %eax
	mov	%eax, dword ptr [%ecx]
	mov	%eax, dword ptr [%eax]
	add	%eax, 1
	mov	%ecx, %ebp
	add	%ecx, -8
	mov	dword ptr [%ecx], %eax
	mov	%eax, offset flat:.float_const_0
	movss	%xmm0, dword ptr [%eax]
	cvttss2si	%eax, %xmm0
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmove	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L4
.L5:	nop
	mov	%eax, %ebp
	add	%eax, -8
	mov	%ebx, dword ptr [%eax]
	sub	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	imul	%eax, 4
	mov	%ebx, 16
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, %ebp
	add	%ebx, -12
	mov	%ebx, dword ptr [%ebx]
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovle	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L6
.L7:	nop
	mov	%eax, %ebp
	add	%eax, -8
	mov	%ebx, dword ptr [%eax]
	sub	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	imul	%eax, 4
	mov	%ebx, 16
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, %ebp
	add	%ebx, -12
	mov	%ebx, dword ptr [%ebx]
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovg	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L7
.L6:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	add	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	imul	%eax, 4
	mov	%ebx, 16
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, %ebp
	add	%ebx, -12
	mov	%ebx, dword ptr [%ebx]
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovge	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L8
.L9:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	add	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	imul	%eax, 4
	mov	%ebx, 16
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	sub	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, %ebp
	add	%ebx, -12
	mov	%ebx, dword ptr [%ebx]
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovl	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L9
.L8:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	mov	%ecx, %ebp
	add	%ecx, -8
	mov	%edx, dword ptr [%ecx]
	cmp	%ebx, %edx
	mov	%edx, -1
	mov	%esi, 0
	cmovl	%esi, %edx
	mov	%edx, -1
	test	%edx, %esi
	je	.L10
	imul	%ebx, 4
	mov	%edx, 16
	mov	%esi, %ebp
	add	%esi, %edx
	mov	%edx, dword ptr [%esi]
	sub	%edx, %ebx
	mov	%ebx, dword ptr [%edx]
	mov	%edx, %ebp
	add	%edx, -16
	mov	dword ptr [%edx], %ebx
	mov	%ebx, dword ptr [%ecx]
	imul	%ebx, 4
	mov	%esi, 16
	mov	%edi, %ebp
	add	%edi, %esi
	mov	%esi, dword ptr [%edi]
	sub	%esi, %ebx
	mov	%ebx, dword ptr [%esi]
	mov	%eax, dword ptr [%eax]
	imul	%eax, 4
	mov	%esi, 16
	mov	%edi, %ebp
	add	%edi, %esi
	mov	%esi, dword ptr [%edi]
	sub	%esi, %eax
	mov	dword ptr [%esi], %ebx
	mov	%eax, dword ptr [%edx]
	mov	%ebx, dword ptr [%ecx]
	imul	%ebx, 4
	mov	%ecx, 16
	mov	%edx, %ebp
	add	%edx, %ecx
	mov	%ecx, dword ptr [%edx]
	sub	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	jmp	.L11
.L10:	nop
	mov	%eax, %ebp
	add	%eax, -8
	mov	%eax, dword ptr [%eax]
	leave
	ret
.L11:	nop
	mov	%eax, offset flat:.float_const_0
	movss	%xmm0, dword ptr [%eax]
	cvttss2si	%eax, %xmm0
	mov	%ebx, -1
	test	%ebx, %eax
	jne	.L5
.L4:	nop
	leave
	ret
	.globl	quicksort;
	.type	quicksort, @function
quicksort:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -8
	mov	%eax, 12
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	%ebx, dword ptr [%ebx]
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovl	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	je	.L12
	mov	%eax, 16
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 12
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	%ecx, 8
	mov	%edx, %ebp
	add	%edx, %ecx
	push	%eax
	push	%ebx
	push	dword ptr [%edx]
	call	partition
	add	%esp, 12
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
	mov	%eax, 16
	mov	%ecx, %ebp
	add	%ecx, %eax
	mov	%eax, 12
	mov	%edx, %ebp
	add	%edx, %eax
	push	dword ptr [%ecx]
	push	dword ptr [%edx]
	push	%ebx
	call	quicksort
	add	%esp, 12
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	add	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -8
	mov	dword ptr [%ebx], %eax
	mov	%eax, 16
	mov	%ecx, %ebp
	add	%ecx, %eax
	mov	%eax, 8
	mov	%edx, %ebp
	add	%edx, %eax
	push	dword ptr [%ecx]
	push	%ebx
	push	dword ptr [%edx]
	call	quicksort
	add	%esp, 12
.L12:	nop
	leave
	ret
