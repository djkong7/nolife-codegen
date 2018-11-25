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
	mov	%eax, %ebp
	add	%eax, -4
	push	%eax
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, dword ptr [%eax]
	mov	%ecx, %ebx
	add	%ecx, %ebx
	mov	dword ptr [%eax], %ecx
	mov	%eax, dword ptr [%eax]
	add	%eax, 5
	mov	%ebx, %ebp
	add	%ebx, -8
	mov	dword ptr [%ebx], %eax
	push	dword ptr [%ebx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
