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
sub %esp, 52
mov %ebx, offset flat:.__main_ebp
mov dword ptr [%ebx], %ebp

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

#ASSIGNMENT
mov %ebx, -20
add %ebx, %ebp
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#LESS THAN
cmp %ecx, %esi
jge less0
mov %ecx, 1
jmp continue0
less0:
mov %ecx, 0
continue0:
mov dword ptr [%ebx], %ecx

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
#SCALAR REF
mov %ebx, -16
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#GREATER THAN
cmp %ebx, %ecx
jg greater0
mov %ebx, 0
jmp continue1
greater0:
mov %ebx, 1
continue1:
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
mov %ebx, -16
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#GREATER THAN
cmp %ebx, %ecx
jg greater1
mov %ebx, 0
jmp continue2
greater1:
mov %ebx, 1
continue2:
#NOT
cmp %ebx, 0
je false0
mov %ebx, 0
jmp continue3
false0:
mov %ebx, 1
continue3:
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
mov %ebx, 0
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#LESS THAN
cmp %ecx, %esi
jge less1
mov %ecx, 1
jmp continue4
less1:
mov %ecx, 0
continue4:
#SCALAR REF
mov %esi, -12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edi, -16
add %edi, %ebp
mov %edi, dword ptr [%edi]
#NOT EQUAL
cmp %esi, %edi
je not0
mov %esi, 1
jmp continue5
not0:
mov %esi, 0
continue5:
#AND
cmp %ecx, %esi
je true0
mov %ecx, 0
jmp continue6
true0:
mov %ecx, 1
continue6:
#OR
cmp %ebx, 1
je true1
cmp %ecx, 1
je true1
mov %ebx, 0
jmp continue7
true1:
mov %ebx, 1
continue7:
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
