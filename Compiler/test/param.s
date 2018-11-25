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
	add	%esp, -44
	mov	%eax, offset flat:main_fp
	mov	dword ptr [%eax], %ebp
	mov	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -20
	mov	dword ptr [%ebx], %eax
	mov	%ebx, 2
	mov	%ecx, %ebp
	add	%ecx, -24
	mov	dword ptr [%ecx], %ebx
	mov	%ecx, 3
	mov	%edx, %ebp
	add	%edx, -28
	mov	dword ptr [%edx], %ecx
	mov	%edx, 4
	mov	%esi, %ebp
	add	%esi, -32
	mov	dword ptr [%esi], %edx
	mov	%esi, %ebp
	add	%esi, -4
	mov	dword ptr [%esi], %eax
	mov	%eax, %ebp
	add	%eax, -8
	mov	dword ptr [%eax], %ebx
	mov	%eax, %ebp
	add	%eax, -12
	mov	dword ptr [%eax], %ecx
	mov	%ebx, %ebp
	add	%ebx, -16
	mov	dword ptr [%ebx], %edx
	push	%eax
	call	b4
	add	%esp, 4
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -20
	push	%eax
	call	d1
	add	%esp, 4
	mov	%eax, %ebp
	add	%eax, -20
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, 1
	mov	%ebx, %ebp
	add	%ebx, -44
	mov	dword ptr [%ebx], %eax
	push	%ebx
	call	b4
	add	%esp, 4
	mov	%ebx, %ebp
	add	%ebx, -44
	mov	dword ptr [%ebx], %eax
	push	%ebx
	call	b4
	add	%esp, 4
	mov	%ebx, offset flat:.int_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
	.globl	b4;
	.type	b4, @function
b4:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 4
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
	add	%eax, 1
	leave
	ret
	.globl	d2;
	.type	d2, @function
d2:	push	%ebp
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
	leave
	ret
	.globl	d3;
	.type	d3, @function
d3:	push	%ebp
	mov	%ebp, %esp
	mov	%eax, 20
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	add	%eax, 1
	mov	%ebx, 20
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	dword ptr [%ebx], %eax
	mov	%eax, 16
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	add	%eax, 2
	mov	%ebx, 16
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	dword ptr [%ebx], %eax
	mov	%eax, 12
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	add	%eax, 3
	mov	%ebx, 12
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	dword ptr [%ebx], %eax
	mov	%eax, 8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	dword ptr [%ebx], %eax
	leave
	ret
	.globl	d1;
	.type	d1, @function
d1:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	mov	%eax, 8
	mov	%ebx, %ebp
	add	%ebx, %eax
	mov	%eax, dword ptr [%ebx]
	mov	%eax, dword ptr [%eax]
	imul	%eax, 200
	mov	%ebx, %ebp
	add	%ebx, -4
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
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	push	%ebx
	push	%eax
	call	d2
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
	mov	%ebx, 8
	mov	%ecx, %ebp
	add	%ecx, %ebx
	mov	%ebx, dword ptr [%ecx]
	mov	%ecx, 8
	mov	%edx, %ebp
	add	%edx, %ecx
	mov	%ebx, dword ptr [%edx]
	mov	%ecx, 8
	mov	%edx, %ebp
	add	%edx, %ecx
	mov	%ebx, dword ptr [%edx]
	push	%ebx
	push	%ebx
	push	%ebx
	push	%eax
	call	d3
	add	%esp, 16
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
	push	%eax
	push	%eax
	push	%eax
	push	%eax
	call	d3
	add	%esp, 16
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
