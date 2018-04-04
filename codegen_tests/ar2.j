.source ar2.ir
.class public ar2
.super java/lang/Object

.method public static __main()V
	.limit locals 10
	.var 0 is x [I from L_0 to L_1
	.var 1 is i I from L_0 to L_1
	.var 2 is T2  I from L_0 to L_1
	.var 3 is T3  I from L_0 to L_1
	.var 4 is T4  I from L_0 to L_1
	.var 5 is T5  I from L_0 to L_1
	.var 6 is T6  Z from L_0 to L_1
	.var 7 is T7  Z from L_0 to L_1
	.var 8 is T8  I from L_0 to L_1
	.var 9 is T9  I from L_0 to L_1
	.limit stack 16
L_0:
	aconst_null 
	astore 0
	ldc 0
	istore 1
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
;		T0 := NEWARRAY I 3;
	ldc 3
	newarray int
	astore 0
.line 15
;		T2 := 0;
	ldc 0
	istore 2
.line 16
;		T3 := 1;
	ldc 1
	istore 3
.line 17
;		T0[T2] := T3;
	aload 0
	iload 2
	iload 3
	iastore
.line 18
;		T4 := 2;
	ldc 2
	istore 4
.line 19
;		T0[T3] := T4;
	aload 0
	iload 3
	iload 4
	iastore
.line 20
;		T5 := 3;
	ldc 3
	istore 5
.line 21
;		T0[T4] := T5;
	aload 0
	iload 4
	iload 5
	iastore
.line 22
;		T1 := T2;
	iload 2
	istore 1
.line 23
;		L0:;
L0:
.line 24
;		T6 := T1 I< T5;
	iload 1
	iload 5
	isub
	iflt L_2
	ldc 0
	goto L_3
L_2:
	ldc 1
L_3:
	istore 6
.line 25
;		T7 := Z! T6;
	iload 6
	ldc 1
	ixor
	istore 7
.line 26
;		IF T7 GOTO L1;
	iload 7
	ifne L1
.line 27
;		T8 := T0[T1];
	aload 0
	iload 1
	iaload
	istore 8
.line 28
;		PRINTLNI T8;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 8
	invokevirtual java/io/PrintStream/println(I)V
.line 29
;		T9 := T1 I+ T3;
	iload 1
	iload 3
	iadd
	istore 9
.line 30
;		T1 := T9;
	iload 9
	istore 1
.line 31
;		GOTO L0;
	goto L0
.line 32
;		L1:;
L1:
.line 33
;		RETURN;
	return
L_1:
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
	invokestatic ar2/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
