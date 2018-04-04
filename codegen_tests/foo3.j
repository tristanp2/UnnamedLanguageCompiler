.source foo3.ir
.class public foo3
.super java/lang/Object

.method public static __main()V
	.limit locals 8
	.var 0 is x I from L_0 to L_1
	.var 1 is y I from L_0 to L_1
	.var 2 is T2  I from L_0 to L_1
	.var 3 is T3  I from L_0 to L_1
	.var 4 is T4  Z from L_0 to L_1
	.var 5 is T5  Z from L_0 to L_1
	.var 6 is T6  I from L_0 to L_1
	.var 7 is T7  I from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0
	istore 0
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
.line 12
;		T2 := 10;
	ldc 10
	istore 2
.line 13
;		T0 := T2;
	iload 2
	istore 0
.line 14
;		T3 := 1;
	ldc 1
	istore 3
.line 15
;		T1 := T3;
	iload 3
	istore 1
.line 16
;		L0:;
L0:
.line 17
;		T4 := T1 I< T0;
	iload 1
	iload 0
	isub
	iflt L_2
	ldc 0
	goto L_3
L_2:
	ldc 1
L_3:
	istore 4
.line 18
;		T5 := Z! T4;
	iload 4
	ldc 1
	ixor
	istore 5
.line 19
;		IF T5 GOTO L1;
	iload 5
	ifne L1
.line 20
;		T6 := T1 I+ T3;
	iload 1
	iload 3
	iadd
	istore 6
.line 21
;		T1 := T6;
	iload 6
	istore 1
.line 22
;		PRINTLNI T1;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
.line 23
;		GOTO L0;
	goto L0
.line 24
;		L1:;
L1:
.line 25
;		T7 := T0 I+ T2;
	iload 0
	iload 2
	iadd
	istore 7
.line 26
;		T0 := T7;
	iload 7
	istore 0
.line 27
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
	invokestatic foo3/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
