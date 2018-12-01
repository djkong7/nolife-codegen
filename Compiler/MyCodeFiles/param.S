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
sub %esp, 72
mov %ebx, offset flat:.__main_ebp
mov dword ptr [%ebx], %ebp

#ASSIGNMENT
mov %ebx, -20
add %ebx, %ebp
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -24
add %ebx, %ebp
mov %ecx, 2
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -28
add %ebx, %ebp
mov %ecx, 3
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -32
add %ebx, %ebp
mov %ecx, 4
mov dword ptr [%ebx], %ecx

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
mov %ebx, -12
add %ebx, %ebp
push %ebx
call b4
add %esp, 4
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
mov %ebx, %eax
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
mov %ebx, -20
add %ebx, %ebp
push %ebx
call d1
add %esp, 4
add %esp, 4
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
mov %ebx, -20
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

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
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
mov %ebx, 1
#compilerTempNext: -44
mov %ecx, -44
add %ecx, %ebp
mov dword ptr [%ecx], %ebx
push %ecx
call b4
add %esp, 4
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
mov %ebx, %eax
#compilerTempNext: -48
mov %ecx, -48
add %ecx, %ebp
mov dword ptr [%ecx], %ebx
push %ecx
call b4
add %esp, 4
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
mov %ebx, %eax
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

.globl b4;
.type b4, @function
b4:
push %ebp
mov %ebp, %esp
sub %esp, 32

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
mov %ebx, 4
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

#SCALAR REF
mov %ebx, 8
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#PARAMETER REFERENCE
mov %ebx, dword ptr [%ebx]
mov %ecx, 1
#ADD STATEMENT
add %ebx, %ecx
mov %eax, %ebx
leave
ret

leave
ret

.globl d2;
.type d2, @function
d2:
push %ebp
mov %ebp, %esp
sub %esp, 36

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#SCALAR REF
mov %ebx, 12
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#PARAMETER REFERENCE
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

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
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
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#SCALAR REF
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, 8
add %ebx, %ebp
#TO PARAMETER
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, 12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, 12
add %ebx, %ebp
#TO PARAMETER
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov dword ptr [%ebx], %ecx

leave
ret

.globl d3;
.type d3, @function
d3:
push %ebp
mov %ebp, %esp
sub %esp, 32

#ASSIGNMENT
mov %ebx, 8
add %ebx, %ebp
#TO PARAMETER
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, 12
add %ebx, %ebp
#TO PARAMETER
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, 12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov %esi, 2
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, 16
add %ebx, %ebp
#TO PARAMETER
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, 16
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov %esi, 3
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, 20
add %ebx, %ebp
#TO PARAMETER
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, 20
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov dword ptr [%ebx], %ecx

leave
ret

.globl d1;
.type d1, @function
d1:
push %ebp
mov %ebp, %esp
sub %esp, 36

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#SCALAR REF
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov %esi, 200
imul %ecx, %esi
mov dword ptr [%ebx], %ecx

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
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
mov %ebx, -4
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
#SCALAR REF PARAM
mov %ebx, 8
add %ebx, %ebp
#PARAM PASSED AS PARAM
mov %ebx, dword ptr [%ebx]
push %ebx
call d2
add %esp, 8
add %esp, 8
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
mov %ebx, -4
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
#SCALAR REF PARAM
mov %ebx, 8
add %ebx, %ebp
#PARAM PASSED AS PARAM
mov %ebx, dword ptr [%ebx]
push %ebx
#SCALAR REF PARAM
mov %ebx, 8
add %ebx, %ebp
#PARAM PASSED AS PARAM
mov %ebx, dword ptr [%ebx]
push %ebx
#SCALAR REF PARAM
mov %ebx, 8
add %ebx, %ebp
#PARAM PASSED AS PARAM
mov %ebx, dword ptr [%ebx]
push %ebx
call d3
add %esp, 16
add %esp, 16
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
mov %ebx, -4
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
#SCALAR REF PARAM
mov %ebx, -4
add %ebx, %ebp
push %ebx
#SCALAR REF PARAM
mov %ebx, -4
add %ebx, %ebp
push %ebx
#SCALAR REF PARAM
mov %ebx, -4
add %ebx, %ebp
push %ebx
call d3
add %esp, 16
add %esp, 16
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
mov %ebx, -4
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
