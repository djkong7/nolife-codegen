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
	add	%esp, -8
	mov	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
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
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	add	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovle	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L1
.L0:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -8
	mov	dword ptr [%ebx], %eax
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
	mov	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovg	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L4
.L5:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, %ebp
	add	%ebx, -8
	mov	%ebx, dword ptr [%ebx]
	imul	%eax, %ebx
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	add	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 10
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovle	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L5
.L4:	nop
	mov	%eax, %ebp
	add	%eax, -8
	mov	%ebx, dword ptr [%eax]
	add	%ebx, 1
	mov	dword ptr [%eax], %ebx
	mov	%eax, dword ptr [%eax]
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
