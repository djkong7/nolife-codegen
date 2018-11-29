.intel_syntax
.section .rodata
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

#READ STATEMENT
mov %ebx, -4
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

mov %ebx, 1
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

mov %ebx, 1
mov %ecx, 2
#ADD STATEMENT
add %ebx, %ecx
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

