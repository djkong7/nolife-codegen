.intel_syntax
.section .rodata
.__flt0: .float 1.100000
.__flt1: .float 110000.000000
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
mov %ebx, offset flat:.__main_ebp
mov dword ptr [%ebx], %ebp

#READ STATEMENT
mov %ebx, -4
add %ebx, %ebp
push %ebx
push offset flat:.flt_in_format
call scanf
add %esp,8

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

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#FLOAT CONSTANT
finit
fld dword ptr .__flt0
sub %esp, 4
fstp dword ptr [%esp]
pop %ebx
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

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#FLOAT CONSTANT
finit
fld dword ptr .__flt1
sub %esp, 4
fstp dword ptr [%esp]
pop %ebx
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

.comm .__main_ebp,4,4
