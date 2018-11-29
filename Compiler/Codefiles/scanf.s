	.file	"scanf.c"
	.intel_syntax noprefix
	.section	.rodata
.LC0:
	.string	"B is true"
.LC1:
	.string	"B is false"
.LC2:
	.string	"A is false"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	lea	ecx, [esp+4]
	.cfi_def_cfa 1, 0
	and	esp, -16
	push	DWORD PTR [ecx-4]
	push	ebp
	.cfi_escape 0x10,0x5,0x2,0x75,0
	mov	ebp, esp
	push	ecx
	.cfi_escape 0xf,0x3,0x75,0x7c,0x6
	sub	esp, 20
	mov	DWORD PTR [ebp-12], 1
	mov	DWORD PTR [ebp-16], 0
	cmp	DWORD PTR [ebp-12], 0
	je	.L2
	cmp	DWORD PTR [ebp-16], 0
	je	.L3
	sub	esp, 12
	push	OFFSET FLAT:.LC0
	call	puts
	add	esp, 16
	jmp	.L5
.L3:
	sub	esp, 12
	push	OFFSET FLAT:.LC1
	call	puts
	add	esp, 16
	jmp	.L5
.L2:
	sub	esp, 12
	push	OFFSET FLAT:.LC2
	call	puts
	add	esp, 16
.L5:
	mov	eax, 0
	mov	ecx, DWORD PTR [ebp-4]
	.cfi_def_cfa 1, 0
	leave
	.cfi_restore 5
	lea	esp, [ecx-4]
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 5.4.0-6ubuntu1~16.04.10) 5.4.0 20160609"
	.section	.note.GNU-stack,"",@progbits
