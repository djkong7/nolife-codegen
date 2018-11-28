.intel_syntax
.section .rodata
.int_format:
	.string "%d\12\0"
.str_format:
	.string "%s\12\0"
.flt_format:
	.string "%f\12\0"
.text
.globl main;
.type main, @function
main:
push %ebp
mov %ebp, %esp
sub %esp, 48

#ASSIGNMENT
mov %ebx, 0
add %ebx, %ebp
mov %esi, 1
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, 4
add %ebx, %ebp
mov %esi, 2
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, 8
add %ebx, %ebp
mov %esi, 3
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, 12
add %ebx, %ebp
mov %esi, 4
mov dword ptr [%ebx], %esi

mov %ebx, 0
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %esi, 4
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %edi, 12
add %edi, %ebp
mov %edi, dword ptr [%edi]
imul %ecx, %edi
add %esi, %ecx
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
mov %ebx, 28
add %ebx, %ebp
mov %esi, 3
mov dword ptr [%ebx], %esi

#ARRAY REFERENCE
mov %ebx, 28
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

leave
ret
