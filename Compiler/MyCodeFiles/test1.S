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

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 10
#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
call f
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
mov %esi, %eax
#ADD STATEMENT
add %ecx, %esi
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

.globl f;
.type f, @function
f:
push %ebp
mov %ebp, %esp
sub %esp, 32

mov %ebx, 1
mov %eax, %ebx

leave
ret

