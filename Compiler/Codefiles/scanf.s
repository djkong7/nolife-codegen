	.file	"scanf.c"
	.intel_syntax noprefix
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	push	ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	mov	ebp, esp
	.cfi_def_cfa_register 5
	sub	esp, 16
	fld	DWORD PTR .LC0
	fstp	DWORD PTR [ebp-4]
	fld	DWORD PTR .LC1
	fstp	DWORD PTR [ebp-8]
	fld	DWORD PTR [ebp-8]
	fadd	st, st(0)
	fstp	DWORD PTR [ebp-12]
	mov	eax, 0
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.section	.rodata
	.align 4
.LC0:
	.long	1082130432
	.align 4
.LC1:
	.long	1084227584
	.ident	"GCC: (Ubuntu 5.4.0-6ubuntu1~16.04.10) 5.4.0 20160609"
	.section	.note.GNU-stack,"",@progbits
