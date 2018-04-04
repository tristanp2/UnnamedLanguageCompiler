.source foo2.ir
.class public foo2
.super java/lang/Object

.method public static foo(II)V
	.limit locals 10
	.var 0 is x I from L_0 to L_1
	.var 1 is y I from L_0 to L_1
	.var 2 is z I from L_0 to L_1
	.var 3 is T3  I from L_0 to L_1
	.var 4 is T4  I from L_0 to L_1
	.var 5 is T5  I from L_0 to L_1
	.var 6 is T6  I from L_0 to L_1
	.var 7 is T7  I from L_0 to L_1
	.var 8 is T8  I from L_0 to L_1
	.var 9 is T9  Z from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0
	istore 2
	ldc 0
	istore 3
	ldc 0
	istore 4
	ldc 0
	istore 5
	ldc 0
	istore 6
	ldc 0
	istore 7
	ldc 0
	istore 8
	ldc 0
	istore 9
.line 14
;		T3 := 7;
	ldc 7
	istore 3
.line 15
;		T4 := T3 I* T1;
	iload 3
	iload 1
	imul
	istore 4
.line 16
;		T5 := 2;
	ldc 2
	istore 5
.line 17
;		T6 := T4 I+ T5;
	iload 4
	iload 5
	iadd
	istore 6
.line 18
;		T7 := T0 I+ T6;
	iload 0
	iload 6
	iadd
	istore 7
.line 19
;		T2 := T7;
	iload 7
	istore 2
.line 20
;		T8 := T0 I+ T1;
	iload 0
	iload 1
	iadd
	istore 8
.line 21
;		T2 := T8;
	iload 8
	istore 2
.line 22
;		T9 := T0 I== T1;
	iload 0
	iload 1
	isub
	ifeq L_10
	ldc 0
	goto L_11
L_10:
	ldc 1
L_11:
	istore 9
.line 23
;		RETURN;
	return
L_1:
.end method

.method public static foo2(FF)V
	.limit locals 9
	.var 0 is x F from L_12 to L_13
	.var 1 is y F from L_12 to L_13
	.var 2 is z F from L_12 to L_13
	.var 3 is T3  F from L_12 to L_13
	.var 4 is T4  F from L_12 to L_13
	.var 5 is T5  F from L_12 to L_13
	.var 6 is T6  F from L_12 to L_13
	.var 7 is T7  F from L_12 to L_13
	.var 8 is T8  F from L_12 to L_13
	.limit stack 16
L_12:
	ldc 0.0
	fstore 2
	ldc 0.0
	fstore 3
	ldc 0.0
	fstore 4
	ldc 0.0
	fstore 5
	ldc 0.0
	fstore 6
	ldc 0.0
	fstore 7
	ldc 0.0
	fstore 8
.line 36
;		T3 := 7.0;
	ldc 7.000000
	fstore 3
.line 37
;		T4 := T3 F* T1;
	fload 3
	fload 1
	fmul
	fstore 4
.line 38
;		T5 := 2.0;
	ldc 2.000000
	fstore 5
.line 39
;		T6 := T4 F+ T5;
	fload 4
	fload 5
	fadd
	fstore 6
.line 40
;		T7 := T0 F+ T6;
	fload 0
	fload 6
	fadd
	fstore 7
.line 41
;		T2 := T7;
	fload 7
	fstore 2
.line 42
;		T8 := T0 F+ T1;
	fload 0
	fload 1
	fadd
	fstore 8
.line 43
;		T2 := T8;
	fload 8
	fstore 2
.line 44
;		RETURN;
	return
L_13:
.end method

.method public static __main()V
	.limit locals 4
	.var 0 is T0  I from L_22 to L_23
	.var 1 is T1  I from L_22 to L_23
	.var 2 is T2  F from L_22 to L_23
	.var 3 is T3  F from L_22 to L_23
	.limit stack 16
L_22:
	ldc 0
	istore 0
	ldc 0
	istore 1
	ldc 0.0
	fstore 2
	ldc 0.0
	fstore 3
.line 52
;		T0 := 2;
	ldc 2
	istore 0
.line 53
;		T1 := 4;
	ldc 4
	istore 1
.line 54
;		CALL foo(T0 T1 );
	iload 0
	iload 1
	invokestatic foo2/foo(II)V
.line 55
;		T2 := 2.0;
	ldc 2.000000
	fstore 2
.line 56
;		T3 := 9.0;
	ldc 9.000000
	fstore 3
.line 57
;		CALL foo2(T2 T3 );
	fload 2
	fload 3
	invokestatic foo2/foo2(FF)V
.line 58
;		RETURN;
	return
L_23:
.end method

;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;

.method public static main([Ljava/lang/String;)V
	; set limits used by this method
	.limit locals 1
	.limit stack 4
	invokestatic foo2/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
