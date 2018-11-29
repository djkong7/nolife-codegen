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
sub %esp, 32

#ASSIGNMENT
mov %ebx, -28
add %ebx, %ebp
mov %esi, 65
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -32
add %ebx, %ebp
mov %esi, 122
mov dword ptr [%ebx], %esi

#SCALAR REF
mov %ebx, -28
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -32
add %esi, %ebp
mov %esi, dword ptr [%esi]
#GREATER THAN
cmp %ebx, %esi
jg greater0
mov %ebx, 0
jmp continue0
greater0:
mov %ebx, 1
continue0:
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#SCALAR REF
mov %ebx, -28
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -32
add %esi, %ebp
mov %esi, dword ptr [%esi]
#GREATER THAN
cmp %ebx, %esi
jg greater1
mov %ebx, 0
jmp continue1
greater1:
mov %ebx, 1
continue1:
#NOT
cmp %ebx, 0
je false0
mov %ebx, 0
jmp continue2
false0:
mov %ebx, 1
continue2:
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#ASSIGNMENT
mov %esi, 100
mov %ebx, 102
sub %ebx, %esi
imul %ebx, 4
add %ebx, -24
add %ebx, %ebp
mov %esi, 3
mov dword ptr [%ebx], %esi

#ARRAY REFERENCE
mov %esi, 100
mov %ebx, 102
sub %ebx, %esi
imul %ebx, 4
add %ebx, -24
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

