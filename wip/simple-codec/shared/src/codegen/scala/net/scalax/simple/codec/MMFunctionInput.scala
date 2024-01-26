
package net.scalax.simple.codec



trait MMFunctionInput0[M[ _], F[_[_]]] {
    def input[ M0[_]](monad: Monad0Apply[M])(func: MFunction0[M,  M0]): M[ F[M0]]
}



trait MMFunctionInput1[M[ _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_]](monad: Monad1Apply[M])(func: MFunction1[M,  M0,  M1]): M[ F[M0],  F[M1]]
}



trait MMFunctionInput2[M[ _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_]](monad: Monad2Apply[M])(func: MFunction2[M,  M0,  M1,  M2]): M[ F[M0],  F[M1],  F[M2]]
}



trait MMFunctionInput3[M[ _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_]](monad: Monad3Apply[M])(func: MFunction3[M,  M0,  M1,  M2,  M3]): M[ F[M0],  F[M1],  F[M2],  F[M3]]
}



trait MMFunctionInput4[M[ _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_]](monad: Monad4Apply[M])(func: MFunction4[M,  M0,  M1,  M2,  M3,  M4]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4]]
}



trait MMFunctionInput5[M[ _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_]](monad: Monad5Apply[M])(func: MFunction5[M,  M0,  M1,  M2,  M3,  M4,  M5]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5]]
}



trait MMFunctionInput6[M[ _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_]](monad: Monad6Apply[M])(func: MFunction6[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6]]
}



trait MMFunctionInput7[M[ _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_]](monad: Monad7Apply[M])(func: MFunction7[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7]]
}



trait MMFunctionInput8[M[ _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_]](monad: Monad8Apply[M])(func: MFunction8[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8]]
}



trait MMFunctionInput9[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_]](monad: Monad9Apply[M])(func: MFunction9[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9]]
}



trait MMFunctionInput10[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_]](monad: Monad10Apply[M])(func: MFunction10[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10]]
}



trait MMFunctionInput11[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_]](monad: Monad11Apply[M])(func: MFunction11[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11]]
}



trait MMFunctionInput12[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_]](monad: Monad12Apply[M])(func: MFunction12[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12]]
}



trait MMFunctionInput13[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_]](monad: Monad13Apply[M])(func: MFunction13[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13]]
}



trait MMFunctionInput14[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_]](monad: Monad14Apply[M])(func: MFunction14[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14]]
}



trait MMFunctionInput15[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_],  M15[_]](monad: Monad15Apply[M])(func: MFunction15[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14,  M15]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14],  F[M15]]
}



trait MMFunctionInput16[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_],  M15[_],  M16[_]](monad: Monad16Apply[M])(func: MFunction16[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14,  M15,  M16]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14],  F[M15],  F[M16]]
}



trait MMFunctionInput17[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_],  M15[_],  M16[_],  M17[_]](monad: Monad17Apply[M])(func: MFunction17[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14,  M15,  M16,  M17]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14],  F[M15],  F[M16],  F[M17]]
}



trait MMFunctionInput18[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_],  M15[_],  M16[_],  M17[_],  M18[_]](monad: Monad18Apply[M])(func: MFunction18[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14,  M15,  M16,  M17,  M18]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14],  F[M15],  F[M16],  F[M17],  F[M18]]
}



trait MMFunctionInput19[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_],  M15[_],  M16[_],  M17[_],  M18[_],  M19[_]](monad: Monad19Apply[M])(func: MFunction19[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14,  M15,  M16,  M17,  M18,  M19]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14],  F[M15],  F[M16],  F[M17],  F[M18],  F[M19]]
}



trait MMFunctionInput20[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_],  M15[_],  M16[_],  M17[_],  M18[_],  M19[_],  M20[_]](monad: Monad20Apply[M])(func: MFunction20[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14,  M15,  M16,  M17,  M18,  M19,  M20]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14],  F[M15],  F[M16],  F[M17],  F[M18],  F[M19],  F[M20]]
}



trait MMFunctionInput21[M[ _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _,  _], F[_[_]]] {
    def input[ M0[_],  M1[_],  M2[_],  M3[_],  M4[_],  M5[_],  M6[_],  M7[_],  M8[_],  M9[_],  M10[_],  M11[_],  M12[_],  M13[_],  M14[_],  M15[_],  M16[_],  M17[_],  M18[_],  M19[_],  M20[_],  M21[_]](monad: Monad21Apply[M])(func: MFunction21[M,  M0,  M1,  M2,  M3,  M4,  M5,  M6,  M7,  M8,  M9,  M10,  M11,  M12,  M13,  M14,  M15,  M16,  M17,  M18,  M19,  M20,  M21]): M[ F[M0],  F[M1],  F[M2],  F[M3],  F[M4],  F[M5],  F[M6],  F[M7],  F[M8],  F[M9],  F[M10],  F[M11],  F[M12],  F[M13],  F[M14],  F[M15],  F[M16],  F[M17],  F[M18],  F[M19],  F[M20],  F[M21]]
}



