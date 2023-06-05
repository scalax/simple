
package net.scalax.simple
package adt
package impl

import implemention._



trait TypeAdtAliasModel {
    
        type Option1[  T1 ] = InnerApply[T1,   NatFuncZero ]
    
        type Option2[  T1   ,  T2 ] = InnerApply[T1,  
    NatFuncPositive[T2,   NatFuncZero ]
]
    
        type Option3[  T1   ,  T2   ,  T3 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,   NatFuncZero ]
]
]
    
        type Option4[  T1   ,  T2   ,  T3   ,  T4 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,   NatFuncZero ]
]
]
]
    
        type Option5[  T1   ,  T2   ,  T3   ,  T4   ,  T5 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,   NatFuncZero ]
]
]
]
]
    
        type Option6[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,   NatFuncZero ]
]
]
]
]
]
    
        type Option7[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,   NatFuncZero ]
]
]
]
]
]
]
    
        type Option8[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,   NatFuncZero ]
]
]
]
]
]
]
]
    
        type Option9[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,   NatFuncZero ]
]
]
]
]
]
]
]
]
    
        type Option10[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
    
        type Option11[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
    
        type Option12[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option13[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option14[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option15[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option16[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15   ,  T16 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,  
    NatFuncPositive[T16,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option17[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15   ,  T16   ,  T17 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,  
    NatFuncPositive[T16,  
    NatFuncPositive[T17,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option18[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15   ,  T16   ,  T17   ,  T18 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,  
    NatFuncPositive[T16,  
    NatFuncPositive[T17,  
    NatFuncPositive[T18,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option19[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15   ,  T16   ,  T17   ,  T18   ,  T19 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,  
    NatFuncPositive[T16,  
    NatFuncPositive[T17,  
    NatFuncPositive[T18,  
    NatFuncPositive[T19,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option20[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15   ,  T16   ,  T17   ,  T18   ,  T19   ,  T20 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,  
    NatFuncPositive[T16,  
    NatFuncPositive[T17,  
    NatFuncPositive[T18,  
    NatFuncPositive[T19,  
    NatFuncPositive[T20,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option21[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15   ,  T16   ,  T17   ,  T18   ,  T19   ,  T20   ,  T21 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,  
    NatFuncPositive[T16,  
    NatFuncPositive[T17,  
    NatFuncPositive[T18,  
    NatFuncPositive[T19,  
    NatFuncPositive[T20,  
    NatFuncPositive[T21,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
        type Option22[  T1   ,  T2   ,  T3   ,  T4   ,  T5   ,  T6   ,  T7   ,  T8   ,  T9   ,  T10   ,  T11   ,  T12   ,  T13   ,  T14   ,  T15   ,  T16   ,  T17   ,  T18   ,  T19   ,  T20   ,  T21   ,  T22 ] = InnerApply[T1,  
    NatFuncPositive[T2,  
    NatFuncPositive[T3,  
    NatFuncPositive[T4,  
    NatFuncPositive[T5,  
    NatFuncPositive[T6,  
    NatFuncPositive[T7,  
    NatFuncPositive[T8,  
    NatFuncPositive[T9,  
    NatFuncPositive[T10,  
    NatFuncPositive[T11,  
    NatFuncPositive[T12,  
    NatFuncPositive[T13,  
    NatFuncPositive[T14,  
    NatFuncPositive[T15,  
    NatFuncPositive[T16,  
    NatFuncPositive[T17,  
    NatFuncPositive[T18,  
    NatFuncPositive[T19,  
    NatFuncPositive[T20,  
    NatFuncPositive[T21,  
    NatFuncPositive[T22,   NatFuncZero ]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
]
    
}
