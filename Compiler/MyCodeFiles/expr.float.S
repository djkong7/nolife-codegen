.intel_syntax
.section .rodata
.__flt0: .float 1.100000
.__flt1: .float 2.200000
.__flt2: .float 3.300000
.__flt3: .float 4.400000
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
sub %esp, 68

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#FLOAT CONSTANT
fld dword ptr .__flt0
sub %esp, 4
fstp dword ptr [%esp]
pop %esi
push %esi
fld dword ptr [%esp]
add %esp, 4
fstp dword ptr [%ebx]
#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
#FLOAT CONSTANT
fld dword ptr .__flt1
sub %esp, 4
fstp dword ptr [%esp]
pop %esi
push %esi
fld dword ptr [%esp]
add %esp, 4
fstp dword ptr [%ebx]
#ASSIGNMENT
mov %ebx, -12
add %ebx, %ebp
#FLOAT CONSTANT
fld dword ptr .__flt2
sub %esp, 4
fstp dword ptr [%esp]
pop %esi
push %esi
fld dword ptr [%esp]
add %esp, 4
fstp dword ptr [%ebx]
#ASSIGNMENT
mov %ebx, -16
add %ebx, %ebp
#FLOAT CONSTANT
fld dword ptr .__flt3
sub %esp, 4
fstp dword ptr [%esp]
pop %esi
push %esi
fld dword ptr [%esp]
add %esp, 4
fstp dword ptr [%ebx]
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edx, -12
add %edx, %ebp
mov %edx, dword ptr [%edx]
#SCALAR REF
mov %ecx, -16
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#ADD STATEMENT
push %ecx
fld dword ptr [%esp]
add %esp, 4
push %edx
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %edx
#ADD STATEMENT
push %edx
fld dword ptr [%esp]
add %esp, 4
push %esi
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %esi
#ADD STATEMENT
push %esi
fld dword ptr [%esp]
add %esp, 4
push %ebx
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
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

#ASSIGNMENT
mov %ebx, -20
add %ebx, %ebp
mov %esi, 1
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -24
add %ebx, %ebp
mov %esi, 2
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -28
add %ebx, %ebp
mov %esi, 3
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -32
add %ebx, %ebp
mov %esi, 4
mov dword ptr [%ebx], %esi

#SCALAR REF
mov %ebx, -20
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -24
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edx, -28
add %edx, %ebp
mov %edx, dword ptr [%edx]
#SCALAR REF
mov %ecx, -32
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
imul %edx, %ecx
#ADD STATEMENT
add %esi, %edx
#ADD STATEMENT
add %ebx, %esi
#PAREN CONVERT
push %ebx
fild dword ptr [%esp]
add %esp, 4
sub %esp, 4
fstp dword ptr [%esp]
pop %ebx
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edx, -8
add %edx, %ebp
mov %edx, dword ptr [%edx]
#SCALAR REF
mov %ecx, -12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %edi, -16
add %edi, %ebp
mov %edi, dword ptr [%edi]
#ADD STATEMENT
push %edi
fld dword ptr [%esp]
add %esp, 4
push %ecx
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %ecx
#ADD STATEMENT
push %ecx
fld dword ptr [%esp]
add %esp, 4
push %edx
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %edx
#ADD STATEMENT
push %edx
fld dword ptr [%esp]
add %esp, 4
push %esi
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %esi
#ADD STATEMENT
push %esi
fld dword ptr [%esp]
add %esp, 4
push %ebx
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
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

#ASSIGNMENT
mov %ebx, -36
add %ebx, %ebp
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edx, -8
add %edx, %ebp
mov %edx, dword ptr [%edx]
#LESS THAN
cmp %esi, %edx
jge less0
mov %esi, 1
jmp continue0
less0:
mov %esi, 0
continue0:
mov dword ptr [%ebx], %esi

#SCALAR REF
mov %ebx, -36
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

