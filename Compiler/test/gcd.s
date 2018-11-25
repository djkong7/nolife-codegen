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
	add	%esp, -8
	mov	%eax, offset flat:main_fp
	mov	dword ptr [%eax], %ebp
	mov	%eax, %ebp
	add	%eax, -4
	push	%eax
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -8
	push	%eax
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 0
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ecx, 0
	cmovne	%ecx, %eax
	mov	%eax, %ebp
	add	%eax, -8
	mov	%eax, dword ptr [%eax]
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%edx, 0
	cmovne	%edx, %eax
	mov	%eax, %ecx
	or	%eax, %edx
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmove	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L0
.L1:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, -8
	push	%eax
	push	%ebx
	call	gcd
	add	%esp, 8
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	push	%eax
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -8
	push	%eax
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 0
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ecx, 0
	cmovne	%ecx, %eax
	mov	%eax, %ebp
	add	%eax, -8
	mov	%eax, dword ptr [%eax]
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmovne	%ebx, %eax
	mov	%eax, %ecx
	or	%eax, %ebx
	mov	%ebx, -1
	test	%ebx, %eax
	jne	.L1
.L0:	nop
	leave
	ret
	.globl	gcd;
	.type	gcd, @function
gcd:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	mov	%eax, 8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 0
	cmp	%eax, %ebx
	mov	%eax, -1
	mov	%ebx, 0
	cmove	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	je	.L2
	mov	%eax, 12
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	leave
	ret
	jmp	.L3
.L2:	nop
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
	cdq
	idiv	%ebx
	mov	%eax, %edx
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
	mov	%eax, 8
	mov	%ecx, %ebp
	add	%ecx, %eax
	push	dword ptr [%ecx]
	push	%ebx
	call	gcd
	add	%esp, 8
	leave
	ret
.L3:	nop
	leave
	ret
