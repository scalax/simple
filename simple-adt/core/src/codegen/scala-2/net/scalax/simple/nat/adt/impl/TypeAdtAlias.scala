package net.scalax.simple.nat.adt.impl
import net.scalax.simple.nat.adt.TypeAdt



trait TypeAdtAlias {
    
        type TypeOptions1[A,   I1  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,   HListTypeAdtZero  ]
 ]
        type TypeOptions1F[F[_], A,   I1  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,   HListTypeAdtZero  ]
 ]
    
        type TypeOptions2[A,   I1    , I2  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,   HListTypeAdtZero  ]
 ]
 ]
        type TypeOptions2F[F[_], A,   I1    , I2  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,   HListTypeAdtZero  ]
 ]
 ]
    
        type TypeOptions3[A,   I1    , I2    , I3  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,   HListTypeAdtZero  ]
 ]
 ]
 ]
        type TypeOptions3F[F[_], A,   I1    , I2    , I3  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,   HListTypeAdtZero  ]
 ]
 ]
 ]
    
        type TypeOptions4[A,   I1    , I2    , I3    , I4  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
        type TypeOptions4F[F[_], A,   I1    , I2    , I3    , I4  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
    
        type TypeOptions5[A,   I1    , I2    , I3    , I4    , I5  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
        type TypeOptions5F[F[_], A,   I1    , I2    , I3    , I4    , I5  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
    
        type TypeOptions6[A,   I1    , I2    , I3    , I4    , I5    , I6  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
        type TypeOptions6F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
    
        type TypeOptions7[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
        type TypeOptions7F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
    
        type TypeOptions8[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
        type TypeOptions8F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
    
        type TypeOptions9[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
        type TypeOptions9F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,   HListTypeAdtZero  ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
 ]
    
        type TypeOptions10[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,   HListTypeAdtZero  ]
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
        type TypeOptions10F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,   HListTypeAdtZero  ]
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
    
        type TypeOptions11[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,   HListTypeAdtZero  ]
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
        type TypeOptions11F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,   HListTypeAdtZero  ]
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
    
        type TypeOptions12[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,   HListTypeAdtZero  ]
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
        type TypeOptions12F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,   HListTypeAdtZero  ]
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
    
        type TypeOptions13[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,   HListTypeAdtZero  ]
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
        type TypeOptions13F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,   HListTypeAdtZero  ]
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
    
        type TypeOptions14[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,   HListTypeAdtZero  ]
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
        type TypeOptions14F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,   HListTypeAdtZero  ]
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
    
        type TypeOptions15[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,   HListTypeAdtZero  ]
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
        type TypeOptions15F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,   HListTypeAdtZero  ]
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
    
        type TypeOptions16[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,   HListTypeAdtZero  ]
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
        type TypeOptions16F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,   HListTypeAdtZero  ]
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
    
        type TypeOptions17[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,   HListTypeAdtZero  ]
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
        type TypeOptions17F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,   HListTypeAdtZero  ]
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
    
        type TypeOptions18[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,   HListTypeAdtZero  ]
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
        type TypeOptions18F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,   HListTypeAdtZero  ]
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
    
        type TypeOptions19[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,   HListTypeAdtZero  ]
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
        type TypeOptions19F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,   HListTypeAdtZero  ]
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
    
        type TypeOptions20[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19    , I20  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,  
    HListTypeAdtPositive[I20,   HListTypeAdtZero  ]
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
        type TypeOptions20F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19    , I20  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,  
    HListTypeAdtPositive[I20,   HListTypeAdtZero  ]
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
    
        type TypeOptions21[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19    , I20    , I21  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,  
    HListTypeAdtPositive[I20,  
    HListTypeAdtPositive[I21,   HListTypeAdtZero  ]
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
        type TypeOptions21F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19    , I20    , I21  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,  
    HListTypeAdtPositive[I20,  
    HListTypeAdtPositive[I21,   HListTypeAdtZero  ]
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
    
        type TypeOptions22[A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19    , I20    , I21    , I22  ] = TypeAdt[A,  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,  
    HListTypeAdtPositive[I20,  
    HListTypeAdtPositive[I21,  
    HListTypeAdtPositive[I22,   HListTypeAdtZero  ]
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
 ]
        type TypeOptions22F[F[_], A,   I1    , I2    , I3    , I4    , I5    , I6    , I7    , I8    , I9    , I10    , I11    , I12    , I13    , I14    , I15    , I16    , I17    , I18    , I19    , I20    , I21    , I22  ] = TypeAdt[F[A],  
    HListTypeAdtPositive[I1,  
    HListTypeAdtPositive[I2,  
    HListTypeAdtPositive[I3,  
    HListTypeAdtPositive[I4,  
    HListTypeAdtPositive[I5,  
    HListTypeAdtPositive[I6,  
    HListTypeAdtPositive[I7,  
    HListTypeAdtPositive[I8,  
    HListTypeAdtPositive[I9,  
    HListTypeAdtPositive[I10,  
    HListTypeAdtPositive[I11,  
    HListTypeAdtPositive[I12,  
    HListTypeAdtPositive[I13,  
    HListTypeAdtPositive[I14,  
    HListTypeAdtPositive[I15,  
    HListTypeAdtPositive[I16,  
    HListTypeAdtPositive[I17,  
    HListTypeAdtPositive[I18,  
    HListTypeAdtPositive[I19,  
    HListTypeAdtPositive[I20,  
    HListTypeAdtPositive[I21,  
    HListTypeAdtPositive[I22,   HListTypeAdtZero  ]
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
 ]
    
}
