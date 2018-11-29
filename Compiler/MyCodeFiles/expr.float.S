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
pop %ecx
push %ecx
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
pop %ecx
push %ecx
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
pop %ecx
push %ecx
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
pop %ecx
push %ecx
fld dword ptr [%esp]
add %esp, 4
fstp dword ptr [%ebx]

#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, -12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edi, -16
add %edi, %ebp
mov %edi, dword ptr [%edi]
#ADD STATEMENT
push %edi
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

#SCALAR REF
mov %ebx, -20
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -24
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, -28
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edi, -32
add %edi, %ebp
mov %edi, dword ptr [%edi]
imul %esi, %edi
#ADD STATEMENT
add %ecx, %esi
#ADD STATEMENT
add %ebx, %ecx
#PAREN CONVERT
push %ebx
fild dword ptr [%esp]
add %esp, 4
sub %esp, 4
fstp dword ptr [%esp]
pop %ebx
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edi, -12
add %edi, %ebp
mov %edi, dword ptr [%edi]
#SCALAR REF
mov %edx, -16
add %edx, %ebp
mov %edx, dword ptr [%edx]
#ADD STATEMENT
push %edx
fld dword ptr [%esp]
add %esp, 4
push %edi
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %edi
#ADD STATEMENT
push %edi
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

