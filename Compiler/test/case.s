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
.string_const_0:	.string	"Enter: "
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	push	offset flat:.string_const_0
	push	offset flat:.string_wformat
	call	printf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	push	%eax
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 1
	cmp	%ebx, %eax
	mov	%ebx, -1
	mov	%ecx, 0
	cmovne	%ecx, %ebx
	mov	%ebx, 2
	cmp	%ebx, %eax
	mov	%eax, -1
	mov	%ebx, 0
	cmovne	%ebx, %eax
	mov	%eax, %ecx
	and	%eax, %ebx
	mov	%ebx, -1
	test	%ebx, %eax
	jne	.L1
	mov	%eax, 0
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	jmp	.L0
.L1:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 3
	cmp	%ebx, %eax
	mov	%ebx, -1
	mov	%ecx, 0
	cmovne	%ecx, %ebx
	mov	%ebx, 4
	cmp	%ebx, %eax
	mov	%eax, -1
	mov	%ebx, 0
	cmovne	%ebx, %eax
	mov	%eax, %ecx
	and	%eax, %ebx
	mov	%ebx, -1
	test	%ebx, %eax
	jne	.L2
	mov	%eax, 1
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	jmp	.L0
.L2:	nop
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 5
	cmp	%ebx, %eax
	mov	%eax, -1
	mov	%ebx, 0
	cmovne	%ebx, %eax
	mov	%eax, -1
	test	%eax, %ebx
	jne	.L3
	mov	%eax, 2
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	jmp	.L0
.L3:	nop
.L0:	nop
	leave
	ret
