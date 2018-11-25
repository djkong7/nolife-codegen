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
	mov	%ebx, offset flat:.int_rformat
	push	%eax
	push	%ebx
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	push	%eax
	call	decls
	add	%esp, 4
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, 10
	mov	%ecx, %ebp
	add	%ecx, -8
	mov	dword ptr [%ecx], %ebx
	push	%eax
	push	%ecx
	call	foo
	add	%esp, 8
	leave
	ret
	.globl	decls;
	.type	decls, @function
decls:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	mov	%eax, 8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, 8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 0
	cmp	%eax, %ebx
	mov	%ebx, -1
	mov	%ecx, 0
	cmovg	%ecx, %ebx
	mov	%ebx, -1
	test	%ebx, %ecx
	je	.L0
	sub	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
	push	%ebx
	call	decls
	add	%esp, 4
	jmp	.L1
.L0:	nop
	mov	%eax, 0
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	dword ptr [%ebx], %eax
.L1:	nop
	leave
	ret
	.globl	foo;
	.type	foo, @function
foo:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 12
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, 8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
