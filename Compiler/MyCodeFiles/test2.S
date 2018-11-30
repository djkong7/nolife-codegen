.intel_syntax
.section .rodata
.__flt0: .float 1.000000
.__flt1: .float 10.000000
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
#FLOAT CONSTANT
finit
fld dword ptr .__flt1
sub %esp, 4
fstp dword ptr [%esp]
pop %ecx
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
finit
push %esi
fld dword ptr [%esp]
add %esp, 4
push %ecx
fld dword ptr [%esp]
add %esp, 4
fadd %st(0), %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %ecx
finit
push %ecx
fld dword ptr [%esp]
add %esp, 4
fstp dword ptr [%ebx]

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
fld dword ptr [%esp]
add %esp, 4
sub %esp, 8
fstp qword ptr [%esp]
push offset flat:.flt_format
call printf
add %esp,12
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
sub %esp, 33

#FLOAT CONSTANT
finit
fld dword ptr .__flt0
sub %esp, 4
fstp dword ptr [%esp]
pop %ebx
mov %eax, %ebx

leave
ret

