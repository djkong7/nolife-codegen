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
	add	%esp, 8
	mov	vr5, %ebp
	add	vr5, -4
	push	vr5
	push	offset flat:.int_rformat
	call	scanf
	add	%esp, 8
	mov	vr5, %ebp
	add	vr5, -4
	mov	vr7, dword ptr [vr5]
	mov	vr8, vr7
	add	vr8, vr7
	mov	dword ptr [vr5], vr8
	mov	vr7, dword ptr [vr5]
	mov	vr10, vr7
	add	vr10, 5
	mov	vr12, %ebp
	add	vr12, -8
	mov	dword ptr [vr12], vr10
	push	dword ptr [vr12]
	push	offset flat:.int_wformat
	call	printf
	add	%esp, 8
	leave
	ret
