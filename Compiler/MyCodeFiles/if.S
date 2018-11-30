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
sub %esp, 40

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 0
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %ecx, 1
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SUBTRACT STATEMENT
sub %esi, %ecx
mov dword ptr [%ebx], %esi

#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#IF STATEMENT
cmp %ebx, 0
je false0
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
mov %ecx, 1
#WRITE STATEMENT
push %ecx
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
jmp continue0
false0:
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
mov %ecx, 0
#WRITE STATEMENT
push %ecx
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
jmp continue0
continue0:

#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#IF STATEMENT
cmp %ecx, 0
je false1
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
#IF STATEMENT
cmp %esi, 0
je false2
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
mov %edi, 0
#WRITE STATEMENT
push %edi
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
jmp continue2
false2:
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
mov %edi, 1
#WRITE STATEMENT
push %edi
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
jmp continue2
continue2:
jmp continue1
false1:
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
mov %edi, 0
#WRITE STATEMENT
push %edi
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
jmp continue1
continue1:

leave
ret

