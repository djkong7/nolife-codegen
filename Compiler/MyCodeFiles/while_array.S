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
sub %esp, 76

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
#ASSIGNMENT
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %ebx, 10
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -44
add %ebx, %ebp
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov dword ptr [%ebx], %ecx

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

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while1:
#SCALAR REF
mov %ebx, -4
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
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %ecx, 5
#LESS THAN
cmp %ebx, %ecx
jge less2
mov %ebx, 1
jmp continue5
less2:
mov %ebx, 0
continue5:
#IF STATEMENT
cmp %ebx, 0
je false2
#ARRAY REFERENCE
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
add %ecx, -44
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
push offset flat:.int_format
call printf
add %esp,8
jmp continue4
false2:
mov %ecx, 0
#WRITE STATEMENT
push %ecx
push offset flat:.int_format
call printf
add %esp,8
jmp continue4
continue4:

#ASSIGNMENT
mov %ecx, -4
add %ecx, %ebp
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %edi, 1
#ADD STATEMENT
add %esi, %edi
mov dword ptr [%ecx], %esi

jmp while1
false1:

leave
ret

