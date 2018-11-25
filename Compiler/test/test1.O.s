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
	add	%esp, -24
	mov	%eax, %ebp
	add	%eax, -4
	push	%eax
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, dword ptr [%ebp-12]
	add	%eax, %ebx
	mov	%ebx, dword ptr [%ebp-16]
	mov	dword ptr [%ebx], %eax
	mov	%eax, dword ptr [%ebx]
	add	%eax, 5
	mov	%ecx, %ebp
	add	%ecx, -8
	mov	dword ptr [%ecx], %eax
	mov	%ecx, dword ptr [%ebp-20]
	push	dword ptr [%ecx]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	mov	dword ptr [%ebp-24], %eax
	mov	dword ptr [%ebp-16], %ebx
	ret
