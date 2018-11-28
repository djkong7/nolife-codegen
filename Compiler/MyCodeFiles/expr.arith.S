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
sub %esp, 48

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %esi, 1
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %esi, 2
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -12
add %ebx, %ebp
mov %esi, 3
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -16
add %ebx, %ebp
mov %esi, 4
mov dword ptr [%ebx], %esi

#SCALAR REF
mov %ebx, -12
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -16
add %esi, %ebp
mov %esi, dword ptr [%esi]
imul %ebx, %esi
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#ADD STATEMENT
add %esi, %ebx
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#ADD STATEMENT
add %ebx, %esi
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

mov %ebx, 5
mov %esi, 7
mov %eax, %ebx
cdq
idiv %esi
mov %ebx, %edx
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#ASSIGNMENT
mov %ebx, -64
add %ebx, %ebp
mov %esi, 3
mov dword ptr [%ebx], %esi

#ARRAY REFERENCE
mov %ebx, -64
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

