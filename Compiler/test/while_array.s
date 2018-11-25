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
	add	%esp, -44
	mov	%eax, 1
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovg	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L0
.L1:	nop
	mov	%eax, %ebp
	mov	%ebx, -4
	add	%eax, %ebx
	mov	%ebx, 1
	mov	%ecx, dword ptr [%ebp-44]
	mov	%edx, %ecx
	sub	%edx, %ebx
	mov	%ebx, 4
	imul	%edx, %ebx
	sub	%eax, %edx
	mov	dword ptr [%eax], %ecx
	mov	%eax, 1
	mov	%ebx, %ecx
	add	%ebx, %eax
	mov	%eax, %ebx
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovle	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L1
.L0:	nop
	mov	%eax, 1
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovg	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L2
.L3:	nop
	mov	%eax, 5
	mov	%ebx, dword ptr [%ebp-44]
	cmp	%ebx, %eax
	mov	%eax, -1
	mov	%ecx, 0
	cmovl	%ecx, %eax
	mov	%eax, -1
	test	%eax, %ecx
	je	.L4
	mov	%eax, %ebp
	mov	%ecx, -4
	add	%eax, %ecx
	mov	%ecx, 1
	sub	%ebx, %ecx
	mov	%ecx, 4
	imul	%ebx, %ecx
	sub	%eax, %ebx
	push	dword ptr [%eax]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	jmp	.L5
.L4:	nop
	mov	%eax, 0
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
.L5:	nop
	mov	%eax, 1
	mov	%ebx, dword ptr [%ebp-44]
	add	%ebx, %eax
	mov	%eax, %ebx
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
