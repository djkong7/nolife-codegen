.intel_syntax
.section .rodata
.__flt0: .float 0.010000
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
sub %esp, 104
mov %ebx, offset flat:.__main_ebp
mov dword ptr [%ebx], %ebp

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
mov %ebx, -56
add %ebx, %ebp
push %ebx
call init
add %esp, 4
add %esp, 4
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
mov %ebx, -56
add %ebx, %ebp
push %ebx
call writearray
add %esp, 4
add %esp, 4
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
#ARRAY REFERENCE
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %ebx, 10
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -56
add %ebx, %ebp
#ARRAY REFERENCE
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
add %ecx, -56
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
imul %ecx, %esi
mov dword ptr [%ebx], %ecx

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %ebx, 10
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -56
add %ebx, %ebp
push %ebx
call inc
add %esp, 4
add %esp, 4
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

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

jmp while0
false0:

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
mov %ecx, -56
add %ecx, %ebp
push %ecx
call writearray
add %esp, 4
add %esp, 4
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

leave
ret

.globl init;
.type init, @function
init:
push %ebp
mov %ebp, %esp
sub %esp, 40

#ASSIGNMENT
mov %ecx, -4
add %ecx, %ebp
mov %esi, 1
mov dword ptr [%ecx], %esi

#ASSIGNMENT
mov %ecx, -8
add %ecx, %ebp
mov %esi, 10
mov dword ptr [%ecx], %esi

#WHILE STATEMENT
while1:
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 10
#LESS EQUAL THAN
cmp %ecx, %esi
jg less1
mov %ecx, 1
jmp continue3
less1:
mov %ecx, 0
continue3:
cmp %ecx, 0
je false1
#ASSIGNMENT
#ARRAY REFERENCE
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
finit
#SCALAR REF CONVERSION
push %esi
fild dword ptr [%esp]
add %esp, 4
sub %esp, 4
fstp dword ptr [%esp]
pop %esi
#FLOAT CONSTANT
finit
fld dword ptr .__flt0
sub %esp, 4
fstp dword ptr [%esp]
pop %edi
finit
push %esi
fld dword ptr [%esp]
add %esp, 4
push %edi
fld dword ptr [%esp]
fmul %st(0), %st(1)
fstp dword ptr [%esp]

pop %esi
#SCALAR REF
mov %edi, -8
add %edi, %ebp
mov %edi, dword ptr [%edi]
finit
#SCALAR REF CONVERSION
push %edi
fild dword ptr [%esp]
add %esp, 4
sub %esp, 4
fstp dword ptr [%esp]
pop %edi
#ADD STATEMENT
finit
push %edi
fld dword ptr [%esp]
add %esp, 4
push %esi
fld dword ptr [%esp]
add %esp, 4
fadd %st(0), %st(1)
sub %esp, 4
fstp dword ptr [%esp]

pop %esi
finit
push %esi
fld dword ptr [%esp]
add %esp, 4
sub %esp, 4
fistp dword ptr [%esp]
pop %esi
mov dword ptr [%ecx], %esi

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

#ASSIGNMENT
mov %ecx, -8
add %ecx, %ebp
#SCALAR REF
mov %esi, -8
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

.globl writearray;
.type writearray, @function
writearray:
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
#ARRAY REFERENCE
mov %esi, 1
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 2
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 3
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 4
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 5
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 6
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 7
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 8
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 9
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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
#ARRAY REFERENCE
mov %esi, 10
mov %ecx, 10
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
#WRITE STATEMENT
push %ecx
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

.globl inc;
.type inc, @function
inc:
push %ebp
mov %ebp, %esp
sub %esp, 32

#ASSIGNMENT
mov %ecx, 8
add %ecx, %ebp
#TO PARAMETER
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#PARAMETER REFERENCE
mov %esi, dword ptr [%esi]
mov %edi, 1
#ADD STATEMENT
add %esi, %edi
mov dword ptr [%ecx], %esi

leave
ret

.comm .__main_ebp,4,4
