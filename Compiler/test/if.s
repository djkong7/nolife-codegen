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
.string_const_0:	.string	"a = "
.string_const_1:	.string	"b = "
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -8
	mov	%eax, 0
	mov	%ebx, -4
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 1
	sub	%eax, %ebx
	mov	%ebx, -8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	dword ptr [%ecx], %eax
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, -1
	test	%ebx, %eax
	je	.L0
	mov	%eax, 1
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	jmp	.L1
.L0:	nop
	mov	%eax, 0
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
.L1:	nop
	push	offset flat:.string_const_0
	push	offset flat:.string_wformat
	call	printf
	add	%esp, 8
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	push	offset flat:.string_const_1
	push	offset flat:.string_wformat
	call	printf
	add	%esp, 8
	mov	%eax, -8
	mov	%ebx, %ebp
	add	%ebx, %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	mov	%eax, -8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, -1
	test	%ebx, %eax
	je	.L2
	mov	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, -1
	test	%ebx, %eax
	je	.L3
	mov	%eax, 0
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	jmp	.L4
.L3:	nop
	mov	%eax, 1
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
.L4:	nop
	jmp	.L5
.L2:	nop
	mov	%eax, 0
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
.L5:	nop
	leave
	ret
