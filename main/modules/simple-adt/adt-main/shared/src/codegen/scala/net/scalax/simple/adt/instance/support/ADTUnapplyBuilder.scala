
    package net.scalax.simple.adt
    package instance
    package support

    trait ADTUnapplyBuilder {
      
      trait ADTOptionsUnapply1 {
        
            def unapply[T1](
              p: CoProduct1[T1]
            ): Some[T1] = Some(p.drop1)
          

            def unapply[T1,T2](
              p: CoProduct2[T1,T2]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3](
              p: CoProduct3[T1,T2,T3]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4](
              p: CoProduct4[T1,T2,T3,T4]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5](
              p: CoProduct5[T1,T2,T3,T4,T5]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6](
              p: CoProduct6[T1,T2,T3,T4,T5,T6]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7](
              p: CoProduct7[T1,T2,T3,T4,T5,T6,T7]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T1] = AppendTail6[T1].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply2 {
        
            def unapply[T1,T2](
              p: CoProduct2[T1,T2]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3](
              p: CoProduct3[T1,T2,T3]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4](
              p: CoProduct4[T1,T2,T3,T4]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5](
              p: CoProduct5[T1,T2,T3,T4,T5]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6](
              p: CoProduct6[T1,T2,T3,T4,T5,T6]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7](
              p: CoProduct7[T1,T2,T3,T4,T5,T6,T7]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T2] = AppendTail6[T2].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply3 {
        
            def unapply[T1,T2,T3](
              p: CoProduct3[T1,T2,T3]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4](
              p: CoProduct4[T1,T2,T3,T4]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5](
              p: CoProduct5[T1,T2,T3,T4,T5]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6](
              p: CoProduct6[T1,T2,T3,T4,T5,T6]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7](
              p: CoProduct7[T1,T2,T3,T4,T5,T6,T7]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T3] = AppendTail6[T3].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply4 {
        
            def unapply[T1,T2,T3,T4](
              p: CoProduct4[T1,T2,T3,T4]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5](
              p: CoProduct5[T1,T2,T3,T4,T5]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6](
              p: CoProduct6[T1,T2,T3,T4,T5,T6]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7](
              p: CoProduct7[T1,T2,T3,T4,T5,T6,T7]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T4] = AppendTail6[T4].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply5 {
        
            def unapply[T1,T2,T3,T4,T5](
              p: CoProduct5[T1,T2,T3,T4,T5]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6](
              p: CoProduct6[T1,T2,T3,T4,T5,T6]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7](
              p: CoProduct7[T1,T2,T3,T4,T5,T6,T7]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T5] = AppendTail6[T5].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply6 {
        
            def unapply[T1,T2,T3,T4,T5,T6](
              p: CoProduct6[T1,T2,T3,T4,T5,T6]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7](
              p: CoProduct7[T1,T2,T3,T4,T5,T6,T7]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T6] = AppendTail6[T6].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply7 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7](
              p: CoProduct7[T1,T2,T3,T4,T5,T6,T7]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T7] = AppendTail6[T7].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply8 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8](
              p: CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T8] = AppendTail6[T8].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply9 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9](
              p: CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T9] = AppendTail6[T9].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply10 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](
              p: CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T10] = AppendTail6[T10].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply11 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](
              p: CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T11] = AppendTail6[T11].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply12 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](
              p: CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T12] = AppendTail6[T12].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply13 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](
              p: CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T13] = AppendTail6[T13].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply14 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](
              p: CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T14] = AppendTail6[T14].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply15 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](
              p: CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T15] = AppendTail6[T15].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply16 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](
              p: CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
            ): Option[T16] = AppendTail6[T16].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T16] = AppendTail6[T16].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T16] = AppendTail6[T16].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T16] = AppendTail6[T16].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T16] = AppendTail6[T16].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T16] = AppendTail6[T16].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T16] = AppendTail6[T16].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply17 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](
              p: CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
            ): Option[T17] = AppendTail6[T17].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T17] = AppendTail6[T17].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T17] = AppendTail6[T17].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T17] = AppendTail6[T17].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T17] = AppendTail6[T17].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T17] = AppendTail6[T17].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply18 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](
              p: CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
            ): Option[T18] = AppendTail6[T18].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T18] = AppendTail6[T18].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T18] = AppendTail6[T18].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T18] = AppendTail6[T18].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T18] = AppendTail6[T18].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply19 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](
              p: CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
            ): Option[T19] = AppendTail6[T19].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T19] = AppendTail6[T19].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T19] = AppendTail6[T19].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T19] = AppendTail6[T19].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply20 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](
              p: CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
            ): Option[T20] = AppendTail6[T20].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T20] = AppendTail6[T20].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T20] = AppendTail6[T20].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply21 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](
              p: CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
            ): Option[T21] = AppendTail6[T21].take(AppendTail6.toValue(p))
          

            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T21] = AppendTail6[T21].take(AppendTail6.toValue(p))
          
      }
    

      trait ADTOptionsUnapply22 {
        
            def unapply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](
              p: CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
            ): Option[T22] = AppendTail6[T22].take(AppendTail6.toValue(p))
          
      }
    
    }
  