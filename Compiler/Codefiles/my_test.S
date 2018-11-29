
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
sub %esp, 4

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp


#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8



#FUNCTION INVOCATION
call f



#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8



mov %esi, %eax
mov %ecx, 10
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

.globl f;
.type f, @function
f:
push %ebp
mov %ebp, %esp
sub %esp, 0

mov %ebx, 1

leave
mov %eax, %ebx
ret

