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
sub %esp, 36

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
mov %ebx, -12
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#ADD STATEMENT
push %ebx
fld dword ptr [%esp]
add %esp, 4
push %esi
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %esi
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
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
#SCALAR REF
mov %esi, -28
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %ecx, -32
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
imul %esi, %ecx
#SCALAR REF
mov %ecx, -24
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#ADD STATEMENT
add %ecx, %esi
#SCALAR REF
mov %esi, -20
add %esi, %ebp
mov %esi, dword ptr [%esi]
#ADD STATEMENT
add %esi, %ecx
#PAREN CONVERT
push %esi
fild dword ptr [%esp]
add %esp, 4
sub %esp, 4
fstp dword ptr [%esp]
pop %esi

push %esi
fld dword ptr [%esp]
add %esp, 4
sub %esp, 8
fstp qword ptr [%esp]
push offset flat:.flt_format
call printf
add %esp,12


#ADD STATEMENT
push %ebx
fld dword ptr [%esp]
add %esp, 4
push %esi
fld dword ptr [%esp]
add %esp, 4
fadd %st, %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %esi
#WRITE STATEMENT
push %esi
fld dword ptr [%esp]
add %esp, 4
sub %esp, 8
fstp qword ptr [%esp]
push offset flat:.flt_format
call printf
add %esp,12

leave
ret

