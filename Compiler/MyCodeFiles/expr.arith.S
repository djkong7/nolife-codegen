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
sub %esp, 80

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %ecx, 2
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -12
add %ebx, %ebp
mov %ecx, 3
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -16
add %ebx, %ebp
mov %ecx, 4
mov dword ptr [%ebx], %ecx

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, -12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edi, -16
add %edi, %ebp
mov %edi, dword ptr [%edi]
imul %esi, %edi
#ADD STATEMENT
add %ecx, %esi
#ADD STATEMENT
add %ebx, %ecx
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
mov %ebx, 5
mov %ecx, 7
#MOD
mov %eax, %ebx
cdq
idiv %ecx
mov %ebx, %edx
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
mov %ecx, 5
mov %ebx, 9
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -48
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
mov %ecx, 5
mov %ebx, 9
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -48
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

