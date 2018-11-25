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
	add	%eax, -8
	mov	%ebx, offset flat:.int_rformat
	push	%eax
	push	%ebx
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, %ebp
	add	%ebx, -8
	push	%eax
	push	%ebx
	call	swap
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
	.globl	swap;
	.type	swap, @function
swap:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	mov	%eax, 12
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, %ebp
	add	%ebx, -4
	mov	dword ptr [%ebx], %eax
	mov	%eax, 8
	mov	%ecx, %ebp
	add	%ecx, %eax
	mov	%eax, dword ptr [%ecx]
	mov	%eax, dword ptr [%eax]
	mov	%ecx, 12
	mov	%edx, %ebp
	add	%edx, %ecx
	mov	%ecx, dword ptr [%edx]
	mov	dword ptr [%ecx], %eax
	mov	%eax, dword ptr [%ebx]
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	dword ptr [%ebx], %eax
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
	leave
	ret
