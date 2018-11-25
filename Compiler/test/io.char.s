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
.string_const_0:	.string	"testcase First completed***************"
	.text
	.globl	main;
	.type	main, @function
main:	push	%ebp
	mov	%ebp, %esp
	add	%esp, -4
	mov	%eax, %ebp
	add	%eax, -4
	mov	%ebx, offset flat:.char_rformat
	push	%eax
	push	%ebx
	call	scanf
	add	%esp, 8
	mov	%eax, %ebp
	add	%eax, -4
	mov	%eax, dword ptr [%eax]
	mov	%ebx, offset flat:.char_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	mov	%eax, offset flat:.string_const_0
	mov	%ebx, offset flat:.string_wformat
	push	%eax
	push	%ebx
	call	printf
	add	%esp, 8
	leave
	ret
