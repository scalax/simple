
      package net.scalax.simple.adt
      package utils

      trait ProductType22Appender[
        Append1, AppendPositive1[_, _ <: Append1] <: Append1, AppendZero1 <: Append1,
        Append2, AppendPositive2[_, _ <: Append2] <: Append2, AppendZero2 <: Append2,
        Append3, AppendPositive3[_, _ <: Append3] <: Append3, AppendZero3 <: Append3,
        M3[_ <: Append1, _ <: Append2, _ <: Append3]
      ] {
        type AP1 = ProductType22[Append1, AppendPositive1, AppendZero1]
        type AP2 = ProductType22[Append2, AppendPositive2, AppendZero2]
        type AP3 = ProductType22[Append3, AppendPositive3, AppendZero3]

        
      def Instance0: M3[
        AP1#Parameter0,
        AP2#Parameter0,
        AP3#Parameter0
      ]
    



      def Instance1[I1]: M3[
        AP1#Parameter1[I1],
        AP2#Parameter1[I1],
        AP3#Parameter1[I1]
      ]
    



      def Instance2[I1,I2]: M3[
        AP1#Parameter2[I1,I2],
        AP2#Parameter2[I1,I2],
        AP3#Parameter2[I1,I2]
      ]
    



      def Instance3[I1,I2,I3]: M3[
        AP1#Parameter3[I1,I2,I3],
        AP2#Parameter3[I1,I2,I3],
        AP3#Parameter3[I1,I2,I3]
      ]
    



      def Instance4[I1,I2,I3,I4]: M3[
        AP1#Parameter4[I1,I2,I3,I4],
        AP2#Parameter4[I1,I2,I3,I4],
        AP3#Parameter4[I1,I2,I3,I4]
      ]
    



      def Instance5[I1,I2,I3,I4,I5]: M3[
        AP1#Parameter5[I1,I2,I3,I4,I5],
        AP2#Parameter5[I1,I2,I3,I4,I5],
        AP3#Parameter5[I1,I2,I3,I4,I5]
      ]
    



      def Instance6[I1,I2,I3,I4,I5,I6]: M3[
        AP1#Parameter6[I1,I2,I3,I4,I5,I6],
        AP2#Parameter6[I1,I2,I3,I4,I5,I6],
        AP3#Parameter6[I1,I2,I3,I4,I5,I6]
      ]
    



      def Instance7[I1,I2,I3,I4,I5,I6,I7]: M3[
        AP1#Parameter7[I1,I2,I3,I4,I5,I6,I7],
        AP2#Parameter7[I1,I2,I3,I4,I5,I6,I7],
        AP3#Parameter7[I1,I2,I3,I4,I5,I6,I7]
      ]
    



      def Instance8[I1,I2,I3,I4,I5,I6,I7,I8]: M3[
        AP1#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8],
        AP2#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8],
        AP3#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8]
      ]
    



      def Instance9[I1,I2,I3,I4,I5,I6,I7,I8,I9]: M3[
        AP1#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9],
        AP2#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9],
        AP3#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9]
      ]
    



      def Instance10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10]: M3[
        AP1#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],
        AP2#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],
        AP3#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10]
      ]
    



      def Instance11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11]: M3[
        AP1#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],
        AP2#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],
        AP3#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11]
      ]
    



      def Instance12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12]: M3[
        AP1#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],
        AP2#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],
        AP3#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12]
      ]
    



      def Instance13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13]: M3[
        AP1#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],
        AP2#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],
        AP3#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13]
      ]
    



      def Instance14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14]: M3[
        AP1#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],
        AP2#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],
        AP3#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14]
      ]
    



      def Instance15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15]: M3[
        AP1#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],
        AP2#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],
        AP3#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15]
      ]
    



      def Instance16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16]: M3[
        AP1#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],
        AP2#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],
        AP3#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16]
      ]
    



      def Instance17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17]: M3[
        AP1#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],
        AP2#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],
        AP3#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17]
      ]
    



      def Instance18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18]: M3[
        AP1#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],
        AP2#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],
        AP3#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18]
      ]
    



      def Instance19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19]: M3[
        AP1#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],
        AP2#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],
        AP3#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19]
      ]
    



      def Instance20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20]: M3[
        AP1#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],
        AP2#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],
        AP3#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20]
      ]
    



      def Instance21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21]: M3[
        AP1#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],
        AP2#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],
        AP3#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21]
      ]
    



      def Instance22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22]: M3[
        AP1#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],
        AP2#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],
        AP3#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22]
      ]
    
      }
    
