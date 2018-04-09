.source foo2.ir
.class public foo2
.super java/lang/Object

.method public static foo(II)V
    .limit locals 10
    .var 0 is x I from L_0 to L_1
    .var 1 is y I from L_0 to L_1
    .var 2 is z I from L_0 to L_1
    .var 3 is T3 I from L_0 to L_1
    .var 4 is T4 I from L_0 to L_1
    .var 5 is T5 I from L_0 to L_1
    .var 6 is T6 I from L_0 to L_1
    .var 7 is T7 I from L_0 to L_1
    .var 8 is T8 I from L_0 to L_1
    .var 9 is T9 Z from L_0 to L_1
    .limit stack 40
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
;         T3 := 7;
    ldc 7
    istore 3
;         T4 := T3 I* T1;
    iload 3
    iload 1
    imul
    istore 4
;         T5 := 2;
    ldc 2
    istore 5
;         T6 := T4 I+ T5;
    iload 4
    iload 5
    iadd
    istore 6
;         T7 := T0 I+ T6;
    iload 0
    iload 6
    iadd
    istore 7
;         T2 := T7;
    iload 7
    istore 2
;         T8 := T0 I+ T1;
    iload 0
    iload 1
    iadd
    istore 8
;         T2 := T8;
    iload 8
    istore 2
;         T9 := T0 I== T1;
    iload 0
    iload 1
    isub
    ifeq L_2
    ldc 0
    goto L_3
L_2:
    ldc 1
L_3:
    istore 9
;         RETURN;
    return
L_1:
.end method
.method public static foo2(FF)V
    .limit locals 9
    .var 0 is x F from L_4 to L_5
    .var 1 is y F from L_4 to L_5
    .var 2 is z F from L_4 to L_5
    .var 3 is T3 F from L_4 to L_5
    .var 4 is T4 F from L_4 to L_5
    .var 5 is T5 F from L_4 to L_5
    .var 6 is T6 F from L_4 to L_5
    .var 7 is T7 F from L_4 to L_5
    .var 8 is T8 F from L_4 to L_5
    .limit stack 36
L_4:
;         T3 := 7.0;
    ldc 7.0
    fstore 3
;         T4 := T3 F* T1;
    fload 3
    fload 1
    fmul
    fstore 4
;         T5 := 2.0;
    ldc 2.0
    fstore 5
;         T6 := T4 F+ T5;
    fload 4
    fload 5
    fadd
    fstore 6
;         T7 := T0 F+ T6;
    fload 0
    fload 6
    fadd
    fstore 7
;         T2 := T7;
    fload 7
    fstore 2
;         T8 := T0 F+ T1;
    fload 0
    fload 1
    fadd
    fstore 8
;         T2 := T8;
    fload 8
    fstore 2
;         RETURN;
    return
L_5:
.end method
.method public static __main()V
    .limit locals 4
    .var 0 is T0 I from L_6 to L_7
    .var 1 is T1 I from L_6 to L_7
    .var 2 is T2 F from L_6 to L_7
    .var 3 is T3 F from L_6 to L_7
    .limit stack 16
L_6:
    ldc 0
    istore 0
    ldc 0
    istore 1
;         T0 := 2;
    ldc 2
    istore 0
;         T1 := 4;
    ldc 4
    istore 1
;         CALL foo(T0 T1 );
    iload 0
    iload 1
    invokestatic foo2/foo(II)V
;         T2 := 2.0;
    ldc 2.0
    fstore 2
;         T3 := 9.0;
    ldc 9.0
    fstore 3
;         CALL foo2(T2 T3 );
    fload 2
    fload 3
    invokestatic foo2/foo2(FF)V
;         RETURN;
    return
L_7:
.end method

;---------------------------;
;  Boiler's plates          ;
;---------------------------;

.method public static main([Ljava/lang/String;)V

    .limit locals 1
    .limit stack 4
    invokestatic foo2/__main()V
    return
.end method

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method
