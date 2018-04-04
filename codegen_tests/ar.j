.source ar.ir
.class public ar
.super java/lang/Object

.method public static __main()V
	.limit locals 7
	.var 0 is x [I from L_0 to L_1
	.var 1 is y I from L_0 to L_1
	.var 2 is T2  I from L_0 to L_1
	.var 3 is T3  I from L_0 to L_1
	.var 4 is T4  I from L_0 to L_1
	.var 5 is T5  I from L_0 to L_1
	.var 6 is T6  I from L_0 to L_1
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
.line 11
;		T0 := NEWARRAY I 3;
	ldc 3
	newarray int
	astore 0
.line 12
;		T2 := 0;
	ldc 0
	istore 2
.line 13
;		T3 := 7;
	ldc 7
	istore 3
.line 14
;		T0[T2] := T3;
	aload 0
	iload 2
	iload 3
	iastore
.line 15
;		T4 := 1;
	ldc 1
	istore 4
.line 16
;		T1 := T4;
	iload 4
	istore 1
.line 17
;		T5 := T1 I+ T4;
	iload 1
	iload 4
	iadd
	istore 5
.line 18
;		T6 := 2;
	ldc 2
	istore 6
.line 19
;		T0[T5] := T6;
	aload 0
	iload 5
	iload 6
	iastore
.line 20
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
	invokestatic ar/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
