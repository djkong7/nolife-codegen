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
	add	%esp, -16
	mov	%eax, 1
	mov	%ebx, 2
	mov	%ecx, 3
	mov	%edx, 4
	cmp	%eax, %ebx
	mov	%esi, -1
	mov	%edi, 0
	cmovl	%edi, %esi
	mov	%esi, %edi
	push	%esi
	push	offset flat:.int_wformat
	mov	dword ptr [%ebp-4], %eax
	mov	dword ptr [%ebp-8], %ebx
	mov	dword ptr [%ebp-12], %ecx
	mov	dword ptr [%ebp-16], %edx
	call	printf
	add	%esp, 8
	mov	%eax, dword ptr [%ebp-12]
	mov	%ebx, dword ptr [%ebp-16]
	cmp	%ebx, %eax
	mov	%ecx, -1
	mov	%edx, 0
	cmovg	%edx, %ecx
	push	%edx
	push	offset flat:.int_wformat
	mov	dword ptr [%ebp-12], %eax
	mov	dword ptr [%ebp-16], %ebx
	call	printf
	add	%esp, 8
	mov	%eax, dword ptr [%ebp-12]
	mov	%ebx, dword ptr [%ebp-16]
	cmp	%ebx, %eax
	mov	%ecx, -1
	mov	%edx, 0
	cmovg	%edx, %ecx
	mov	%ecx, %edx
	not	%ecx
	push	%ecx
	push	offset flat:.int_wformat
	mov	dword ptr [%ebp-12], %eax
	mov	dword ptr [%ebp-16], %ebx
	call	printf
	add	%esp, 8
	mov	%eax, 0
	mov	%ebx, dword ptr [%ebp-8]
	mov	%ecx, dword ptr [%ebp-4]
	cmp	%ecx, %ebx
	mov	%ebx, -1
	mov	%ecx, 0
	cmovl	%ecx, %ebx
	mov	%ebx, dword ptr [%ebp-16]
	mov	%edx, dword ptr [%ebp-12]
	cmp	%edx, %ebx
	mov	%ebx, -1
	mov	%edx, 0
	cmovne	%edx, %ebx
	mov	%ebx, %ecx
	and	%ebx, %edx
	or	%eax, %ebx
	push	%eax
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
