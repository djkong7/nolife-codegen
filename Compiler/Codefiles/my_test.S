.intel_syntax
.section .rodata
.__flt0: .float 1.100000
.int_format:
	.string "%d\12\0"
.str_format:
	.string "%s\12\0"
.flt_format:
	.string "%f\12\0"
.char_format:
	.string "%c\12\0"
.int_in_format:
	.string "%d"
.flt_in_format:
	.string "%f"
.char_in_format:
	.string "%c"
.text
.globl main;
.type main, @function
main:
push %ebp
mov %ebp, %esp
sub %esp, 36

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#FLOAT CONSTANT
mov %esi, offset flat:.__flt0
mov dword ptr [%ebx], %esi

mov %ebx, -4
add %ebx, %ebp
#WRITE STATEMENT
fld dword ptr [%ebx]
sub %esp, 8
fstp qword ptr [%esp]
push offset flat:.flt_format
call printf
add %esp,12

leave
ret

