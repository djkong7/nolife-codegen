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

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#SCALAR REF PARAM
mov %ebx, -4
add %ebx, %ebp
push %ebx
call decls
add %esp, 4
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#OTHER PARAM
mov %ebx, 10
#compilerTempNext: -8
mov %ecx, -8
add %ecx, %ebp
mov dword ptr [%ecx], %ebx
push %ecx
#SCALAR REF PARAM
mov %ebx, -4
add %ebx, %ebp
push %ebx
call foo
add %esp, 8
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

leave
ret

.globl decls;
.type decls, @function
decls:
push %ebp
mov %ebp, %esp
sub %esp, 32

#SCALAR REF
mov %ebx, 8
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#PARAMETER REFERENCE
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#SCALAR REF
mov %ebx, 8
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#PARAMETER REFERENCE
mov %ebx, dword ptr [%ebx]
mov %ecx, 0
#GREATER THAN
cmp %ebx, %ecx
jg greater0
mov %ebx, 0
jmp continue1
greater0:
mov %ebx, 1
continue1:
#IF STATEMENT
cmp %ebx, 0
je false0
#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#OTHER PARAM
mov %ecx, 1
#SCALAR REF
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#PARAMETER REFERENCE
mov %esi, dword ptr [%esi]
#SUBTRACT STATEMENT
sub %esi, %ecx
#compilerTempNext: -4
mov %ecx, -4
add %ecx, %ebp
mov dword ptr [%ecx], %esi
push %ecx
call decls
add %esp, 4
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
jmp continue0
false0:
#ASSIGNMENT
mov %ecx, 8
add %ecx, %ebp
#TO PARAMETER
mov %ecx, dword ptr [%ecx]
mov %esi, 0
mov dword ptr [%ecx], %esi
jmp continue0
continue0:

leave
ret

.globl foo;
.type foo, @function
foo:
push %ebp
mov %ebp, %esp
sub %esp, 32

#SCALAR REF
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
push offset flat:.int_format
call printf
add %esp,8

#SCALAR REF
mov %ecx, 12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

