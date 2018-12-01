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
sub %esp, 64
mov %ebx, offset flat:.__main_ebp
mov dword ptr [%ebx], %ebp

#ASSIGNMENT
mov %ebx, -28
add %ebx, %ebp
mov %ecx, 65
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -32
add %ebx, %ebp
mov %ecx, 122
mov dword ptr [%ebx], %ecx

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#SCALAR REF
mov %ebx, -28
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -32
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#GREATER THAN
cmp %ebx, %ecx
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
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#SCALAR REF
mov %ebx, -28
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -32
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#GREATER THAN
cmp %ebx, %ecx
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
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#ASSIGNMENT
#ARRAY REFERENCE
mov %ecx, 100
mov %ebx, 102
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -24
add %ebx, %ebp
mov %ecx, 3
mov dword ptr [%ebx], %ecx

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#ARRAY REFERENCE
mov %ecx, 100
mov %ebx, 102
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -24
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

leave
ret

.comm .__main_ebp,4,4
