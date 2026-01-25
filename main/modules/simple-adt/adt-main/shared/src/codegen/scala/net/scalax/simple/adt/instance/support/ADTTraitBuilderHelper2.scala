
    package net.scalax.simple.adt
    package instance
    package support

    trait helper2 {
      helper2Self: ADTApplyFunction2 =>

      
      trait CoProduct1ApplyHelper[T1] {
        FoldApplySelf: helper2Self.CoProduct1Apply[T1] =>
        
        def instance1(t: T1): CoProduct1[T1] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct2ApplyHelper[T1,T2] {
        FoldApplySelf: helper2Self.CoProduct2Apply[T1,T2] =>
        
        def instance1(t: T1): CoProduct2[T1,T2] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct2[T1,T2] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct3ApplyHelper[T1,T2,T3] {
        FoldApplySelf: helper2Self.CoProduct3Apply[T1,T2,T3] =>
        
        def instance1(t: T1): CoProduct3[T1,T2,T3] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct3[T1,T2,T3] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct3[T1,T2,T3] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct4ApplyHelper[T1,T2,T3,T4] {
        FoldApplySelf: helper2Self.CoProduct4Apply[T1,T2,T3,T4] =>
        
        def instance1(t: T1): CoProduct4[T1,T2,T3,T4] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct4[T1,T2,T3,T4] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct4[T1,T2,T3,T4] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct4[T1,T2,T3,T4] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct5ApplyHelper[T1,T2,T3,T4,T5] {
        FoldApplySelf: helper2Self.CoProduct5Apply[T1,T2,T3,T4,T5] =>
        
        def instance1(t: T1): CoProduct5[T1,T2,T3,T4,T5] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct5[T1,T2,T3,T4,T5] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct5[T1,T2,T3,T4,T5] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct5[T1,T2,T3,T4,T5] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct5[T1,T2,T3,T4,T5] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct6ApplyHelper[T1,T2,T3,T4,T5,T6] {
        FoldApplySelf: helper2Self.CoProduct6Apply[T1,T2,T3,T4,T5,T6] =>
        
        def instance1(t: T1): CoProduct6[T1,T2,T3,T4,T5,T6] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct6[T1,T2,T3,T4,T5,T6] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct6[T1,T2,T3,T4,T5,T6] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct6[T1,T2,T3,T4,T5,T6] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct6[T1,T2,T3,T4,T5,T6] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct6[T1,T2,T3,T4,T5,T6] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct7ApplyHelper[T1,T2,T3,T4,T5,T6,T7] {
        FoldApplySelf: helper2Self.CoProduct7Apply[T1,T2,T3,T4,T5,T6,T7] =>
        
        def instance1(t: T1): CoProduct7[T1,T2,T3,T4,T5,T6,T7] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct7[T1,T2,T3,T4,T5,T6,T7] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct7[T1,T2,T3,T4,T5,T6,T7] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct7[T1,T2,T3,T4,T5,T6,T7] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct7[T1,T2,T3,T4,T5,T6,T7] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct7[T1,T2,T3,T4,T5,T6,T7] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct7[T1,T2,T3,T4,T5,T6,T7] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct8ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8] {
        FoldApplySelf: helper2Self.CoProduct8Apply[T1,T2,T3,T4,T5,T6,T7,T8] =>
        
        def instance1(t: T1): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct9ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9] {
        FoldApplySelf: helper2Self.CoProduct9Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9] =>
        
        def instance1(t: T1): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct10ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] {
        FoldApplySelf: helper2Self.CoProduct10Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] =>
        
        def instance1(t: T1): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct11ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] {
        FoldApplySelf: helper2Self.CoProduct11Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] =>
        
        def instance1(t: T1): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct12ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] {
        FoldApplySelf: helper2Self.CoProduct12Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] =>
        
        def instance1(t: T1): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct13ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] {
        FoldApplySelf: helper2Self.CoProduct13Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] =>
        
        def instance1(t: T1): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct14ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] {
        FoldApplySelf: helper2Self.CoProduct14Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] =>
        
        def instance1(t: T1): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct15ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
        FoldApplySelf: helper2Self.CoProduct15Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] =>
        
        def instance1(t: T1): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct16ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
        FoldApplySelf: helper2Self.CoProduct16Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] =>
        
        def instance1(t: T1): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      

        def instance16(t: T16): CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct17ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
        FoldApplySelf: helper2Self.CoProduct17Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] =>
        
        def instance1(t: T1): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance16(t: T16): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      

        def instance17(t: T17): CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct18ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
        FoldApplySelf: helper2Self.CoProduct18Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] =>
        
        def instance1(t: T1): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance16(t: T16): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance17(t: T17): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      

        def instance18(t: T18): CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct19ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
        FoldApplySelf: helper2Self.CoProduct19Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] =>
        
        def instance1(t: T1): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance16(t: T16): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance17(t: T17): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance18(t: T18): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      

        def instance19(t: T19): CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct20ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
        FoldApplySelf: helper2Self.CoProduct20Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] =>
        
        def instance1(t: T1): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance16(t: T16): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance17(t: T17): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance18(t: T18): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance19(t: T19): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      

        def instance20(t: T20): CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct21ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
        FoldApplySelf: helper2Self.CoProduct21Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] =>
        
        def instance1(t: T1): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance16(t: T16): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance17(t: T17): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance18(t: T18): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance19(t: T19): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance20(t: T20): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      

        def instance21(t: T21): CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          FoldApplySelf.instance(t)
        }
      
      }
    

      trait CoProduct22ApplyHelper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
        FoldApplySelf: helper2Self.CoProduct22Apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] =>
        
        def instance1(t: T1): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance2(t: T2): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance3(t: T3): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance4(t: T4): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance5(t: T5): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance6(t: T6): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance7(t: T7): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance8(t: T8): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance9(t: T9): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance10(t: T10): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance11(t: T11): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance12(t: T12): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance13(t: T13): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance14(t: T14): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance15(t: T15): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance16(t: T16): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance17(t: T17): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance18(t: T18): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance19(t: T19): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance20(t: T20): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance21(t: T21): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      

        def instance22(t: T22): CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          FoldApplySelf.instance(t)
        }
      
      }
    
    }
  