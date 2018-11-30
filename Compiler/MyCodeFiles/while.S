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
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while0:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %ecx, 10
#LESS EQUAL THAN
cmp %ebx, %ecx
jg less0
mov %ebx, 1
jmp continue1
less0:
mov %ebx, 0
continue1:
cmp %ebx, 0
je false0
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

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while0
false0:

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

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while1:
#SCALAR REF
mov %ebx, -8
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %ecx, 10
#LESS EQUAL THAN
cmp %ebx, %ecx
jg less1
mov %ebx, 1
jmp continue3
less1:
mov %ebx, 0
continue3:
cmp %ebx, 0
je false1
#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while2:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %ecx, 10
#LESS EQUAL THAN
cmp %ebx, %ecx
jg less2
mov %ebx, 1
jmp continue5
less2:
mov %ebx, 0
continue5:
cmp %ebx, 0
je false2
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
imul %ebx, %ecx
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
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while2
false2:

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while1
false1:

leave
ret

