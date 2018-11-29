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
sub %esp, 8

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %esi, 0
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %esi, 1
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SUBTRACT STATEMENT
sub %ecx, %esi
mov dword ptr [%ebx], %ecx

#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#IF STATEMENT
cmp %ebx, 0
je false0
mov %esi, 1
#WRITE STATEMENT
push %esi
push offset flat:.int_format
call printf
add %esp,8
jmp continue0
false0:
mov %esi, 0
#WRITE STATEMENT
push %esi
push offset flat:.int_format
call printf
add %esp,8
jmp continue0
continue0:

#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#IF STATEMENT
cmp %esi, 0
je false1
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#IF STATEMENT
cmp %ecx, 0
je false2
mov %edi, 0
#WRITE STATEMENT
push %edi
push offset flat:.int_format
call printf
add %esp,8
jmp continue2
false2:
mov %edi, 1
#WRITE STATEMENT
push %edi
push offset flat:.int_format
call printf
add %esp,8
jmp continue2
continue2:
jmp continue1
false1:
mov %edi, 0
#WRITE STATEMENT
push %edi
push offset flat:.int_format
call printf
add %esp,8
jmp continue1
continue1:

leave
ret

