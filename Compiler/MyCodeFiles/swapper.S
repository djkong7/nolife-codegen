.intel_syntax
.section .rodata
.__str0: .string "input j"
.__str1: .string "input i"
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

push offset flat:.__str1
#WRITE STATEMENT
push offset flat:.str_format
call printf
add %esp,8

#READ STATEMENT
mov %ebx, -4
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

push offset flat:.__str0
#WRITE STATEMENT
push offset flat:.str_format
call printf
add %esp,8

#READ STATEMENT
mov %ebx, -8
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
mov %ebx, -8
add %ebx, %ebp
push %ebx
mov %esi, -4
add %esi, %ebp
push %esi
call swap
add %esp, 8
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#SCALAR REF
mov %edx, -4
add %edx, %ebp
mov %edx, dword ptr [%edx]
#WRITE STATEMENT
push %edx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

.globl swap;
.type swap, @function
swap:
push %ebp
mov %ebp, %esp
sub %esp, 36

#ASSIGNMENT
mov %edx, -4
add %edx, %ebp
#SCALAR REF
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov dword ptr [%edx], %ecx

#ASSIGNMENT
mov %edx, 8
add %edx, %ebp
#TO PARAMETER
mov %edx, dword ptr [%edx]
#SCALAR REF
mov %ecx, 12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov dword ptr [%edx], %ecx

#ASSIGNMENT
mov %edx, 12
add %edx, %ebp
#TO PARAMETER
mov %edx, dword ptr [%edx]
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov dword ptr [%edx], %ecx

#SCALAR REF
mov %edx, 12
add %edx, %ebp
mov %edx, dword ptr [%edx]
#PARAMETER REFERENCE
mov %edx, dword ptr [%edx]
#WRITE STATEMENT
push %edx
push offset flat:.int_format
call printf
add %esp,8

#SCALAR REF
mov %edx, 8
add %edx, %ebp
mov %edx, dword ptr [%edx]
#PARAMETER REFERENCE
mov %edx, dword ptr [%edx]
#WRITE STATEMENT
push %edx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

