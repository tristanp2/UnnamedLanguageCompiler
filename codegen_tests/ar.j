.source ar.ir
.class public ar
.super java/lang/Object

.method public static __main()V
    .limit locals 18
    .var 0 is x [I from L_0 to L_1
    .var 1 is y I from L_0 to L_1
    .var 2 is i I from L_0 to L_1
    .var 3 is T3 I from L_0 to L_1
    .var 4 is T4 I from L_0 to L_1
    .var 5 is T5 I from L_0 to L_1
    .var 6 is T6 I from L_0 to L_1
    .var 7 is T7 I from L_0 to L_1
    .var 8 is T8 I from L_0 to L_1
    .var 9 is T9 I from L_0 to L_1
    .var 10 is T10 I from L_0 to L_1
    .var 11 is T11 I from L_0 to L_1
    .var 12 is T12 I from L_0 to L_1
    .var 13 is T13 Z from L_0 to L_1
    .var 14 is T14 Z from L_0 to L_1
    .var 15 is T15 I from L_0 to L_1
    .var 16 is T16 I from L_0 to L_1
    .var 17 is T17 I from L_0 to L_1
    .limit stack 72
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
    ldc 0
    istore 10
    ldc 0
    istore 11
    ldc 0
    istore 12
    ldc 0
    istore 13
    ldc 0
    istore 14
    ldc 0
    istore 15
    ldc 0
    istore 16
    ldc 0
    istore 17
;         T0 := NEWARRAY I 3;
    ldc 3
    newarray int
    astore 0
;         T3 := 0;
    ldc 0
    istore 3
;         T4 := 7;
    ldc 7
    istore 4
;         T0[T3] := T4;
    aload 0
    iload 3
    iload 4
    iastore
;         T5 := 1;
    ldc 1
    istore 5
;         T6 := 24;
    ldc 24
    istore 6
;         T0[T5] := T6;
    aload 0
    iload 5
    iload 6
    iastore
;         T7 := 1;
    ldc 1
    istore 7
;         T1 := T7;
    iload 7
    istore 1
;         T8 := 1;
    ldc 1
    istore 8
;         T9 := T1 I+ T8;
    iload 1
    iload 8
    iadd
    istore 9
;         T10 := 2;
    ldc 2
    istore 10
;         T0[T9] := T10;
    aload 0
    iload 9
    iload 10
    iastore
;         T11 := 0;
    ldc 0
    istore 11
;         T2 := T11;
    iload 11
    istore 2
;         L0:;
L0:
;         T12 := 3;
    ldc 3
    istore 12
;         T13 := T2 I< T12;
    iload 2
    iload 12
    isub
    iflt L_2
    ldc 0
    goto L_3
L_2:
    ldc 1
L_3:
    istore 13
;         T14 := Z! T13;
    iload 13
    ldc 1
    ixor
    istore 14
;         IF T14 GOTO L1;
    iload 14
    ifne L1
;         T15 := T0[T2];
    aload 0
    iload 2
    iaload
    istore 15
;         PRINTLNI T15;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 15
    invokevirtual java/io/PrintStream/println(I)V
;         T16 := 1;
    ldc 1
    istore 16
;         T17 := T2 I+ T16;
    iload 2
    iload 16
    iadd
    istore 17
;         T2 := T17;
    iload 17
    istore 2
;         GOTO L0;
    goto L0
;         L1:;
L1:
;         RETURN;
    return
L_1:
.end method

;---------------------------;
;  Boiler's plates          ;
;---------------------------;

.method public static main([Ljava/lang/String;)V

    .limit locals 1
    .limit stack 4
    invokestatic ar/__main()V
    return
.end method

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method
