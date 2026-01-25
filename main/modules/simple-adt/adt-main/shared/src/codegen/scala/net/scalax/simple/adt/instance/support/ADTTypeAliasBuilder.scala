
    package net.scalax.simple.adt
    package instance
    package support

    trait ADTTypeAlias {
      
      type CoProducts1[Target, T1] = ADTValue[AdtCoProduct.Use.One[AdtFunction[Target, T1]]]
      type CoProduct1[T1] = net.scalax.simple.adt.instance.support.CoProduct1[T1]
    

      type CoProducts2[Target, T1,T2] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.One[AdtFunction[Target, T2]]]]
      type CoProduct2[T1,T2] = net.scalax.simple.adt.instance.support.CoProduct2[T1,T2]
    

      type CoProducts3[Target, T1,T2,T3] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.One[AdtFunction[Target, T3]]]]]
      type CoProduct3[T1,T2,T3] = net.scalax.simple.adt.instance.support.CoProduct3[T1,T2,T3]
    

      type CoProducts4[Target, T1,T2,T3,T4] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.One[AdtFunction[Target, T4]]]]]]
      type CoProduct4[T1,T2,T3,T4] = net.scalax.simple.adt.instance.support.CoProduct4[T1,T2,T3,T4]
    

      type CoProducts5[Target, T1,T2,T3,T4,T5] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.One[AdtFunction[Target, T5]]]]]]]
      type CoProduct5[T1,T2,T3,T4,T5] = net.scalax.simple.adt.instance.support.CoProduct5[T1,T2,T3,T4,T5]
    

      type CoProducts6[Target, T1,T2,T3,T4,T5,T6] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.One[AdtFunction[Target, T6]]]]]]]]
      type CoProduct6[T1,T2,T3,T4,T5,T6] = net.scalax.simple.adt.instance.support.CoProduct6[T1,T2,T3,T4,T5,T6]
    

      type CoProducts7[Target, T1,T2,T3,T4,T5,T6,T7] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.One[AdtFunction[Target, T7]]]]]]]]]
      type CoProduct7[T1,T2,T3,T4,T5,T6,T7] = net.scalax.simple.adt.instance.support.CoProduct7[T1,T2,T3,T4,T5,T6,T7]
    

      type CoProducts8[Target, T1,T2,T3,T4,T5,T6,T7,T8] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.One[AdtFunction[Target, T8]]]]]]]]]]
      type CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8] = net.scalax.simple.adt.instance.support.CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8]
    

      type CoProducts9[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.One[AdtFunction[Target, T9]]]]]]]]]]]
      type CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = net.scalax.simple.adt.instance.support.CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
    

      type CoProducts10[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.One[AdtFunction[Target, T10]]]]]]]]]]]]
      type CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] = net.scalax.simple.adt.instance.support.CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
    

      type CoProducts11[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.One[AdtFunction[Target, T11]]]]]]]]]]]]]
      type CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = net.scalax.simple.adt.instance.support.CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
    

      type CoProducts12[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.One[AdtFunction[Target, T12]]]]]]]]]]]]]]
      type CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = net.scalax.simple.adt.instance.support.CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
    

      type CoProducts13[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.One[AdtFunction[Target, T13]]]]]]]]]]]]]]]
      type CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = net.scalax.simple.adt.instance.support.CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
    

      type CoProducts14[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.One[AdtFunction[Target, T14]]]]]]]]]]]]]]]]
      type CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = net.scalax.simple.adt.instance.support.CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
    

      type CoProducts15[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.One[AdtFunction[Target, T15]]]]]]]]]]]]]]]]]
      type CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = net.scalax.simple.adt.instance.support.CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
    

      type CoProducts16[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.Positive[AdtFunction[Target, T15], AdtCoProduct.Use.One[AdtFunction[Target, T16]]]]]]]]]]]]]]]]]]
      type CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = net.scalax.simple.adt.instance.support.CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
    

      type CoProducts17[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.Positive[AdtFunction[Target, T15], AdtCoProduct.Use.Positive[AdtFunction[Target, T16], AdtCoProduct.Use.One[AdtFunction[Target, T17]]]]]]]]]]]]]]]]]]]
      type CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = net.scalax.simple.adt.instance.support.CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
    

      type CoProducts18[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.Positive[AdtFunction[Target, T15], AdtCoProduct.Use.Positive[AdtFunction[Target, T16], AdtCoProduct.Use.Positive[AdtFunction[Target, T17], AdtCoProduct.Use.One[AdtFunction[Target, T18]]]]]]]]]]]]]]]]]]]]
      type CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = net.scalax.simple.adt.instance.support.CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
    

      type CoProducts19[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.Positive[AdtFunction[Target, T15], AdtCoProduct.Use.Positive[AdtFunction[Target, T16], AdtCoProduct.Use.Positive[AdtFunction[Target, T17], AdtCoProduct.Use.Positive[AdtFunction[Target, T18], AdtCoProduct.Use.One[AdtFunction[Target, T19]]]]]]]]]]]]]]]]]]]]]
      type CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = net.scalax.simple.adt.instance.support.CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
    

      type CoProducts20[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.Positive[AdtFunction[Target, T15], AdtCoProduct.Use.Positive[AdtFunction[Target, T16], AdtCoProduct.Use.Positive[AdtFunction[Target, T17], AdtCoProduct.Use.Positive[AdtFunction[Target, T18], AdtCoProduct.Use.Positive[AdtFunction[Target, T19], AdtCoProduct.Use.One[AdtFunction[Target, T20]]]]]]]]]]]]]]]]]]]]]]
      type CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = net.scalax.simple.adt.instance.support.CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
    

      type CoProducts21[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.Positive[AdtFunction[Target, T15], AdtCoProduct.Use.Positive[AdtFunction[Target, T16], AdtCoProduct.Use.Positive[AdtFunction[Target, T17], AdtCoProduct.Use.Positive[AdtFunction[Target, T18], AdtCoProduct.Use.Positive[AdtFunction[Target, T19], AdtCoProduct.Use.Positive[AdtFunction[Target, T20], AdtCoProduct.Use.One[AdtFunction[Target, T21]]]]]]]]]]]]]]]]]]]]]]]
      type CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = net.scalax.simple.adt.instance.support.CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
    

      type CoProducts22[Target, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = ADTValue[AdtCoProduct.Use.Positive[AdtFunction[Target, T1], AdtCoProduct.Use.Positive[AdtFunction[Target, T2], AdtCoProduct.Use.Positive[AdtFunction[Target, T3], AdtCoProduct.Use.Positive[AdtFunction[Target, T4], AdtCoProduct.Use.Positive[AdtFunction[Target, T5], AdtCoProduct.Use.Positive[AdtFunction[Target, T6], AdtCoProduct.Use.Positive[AdtFunction[Target, T7], AdtCoProduct.Use.Positive[AdtFunction[Target, T8], AdtCoProduct.Use.Positive[AdtFunction[Target, T9], AdtCoProduct.Use.Positive[AdtFunction[Target, T10], AdtCoProduct.Use.Positive[AdtFunction[Target, T11], AdtCoProduct.Use.Positive[AdtFunction[Target, T12], AdtCoProduct.Use.Positive[AdtFunction[Target, T13], AdtCoProduct.Use.Positive[AdtFunction[Target, T14], AdtCoProduct.Use.Positive[AdtFunction[Target, T15], AdtCoProduct.Use.Positive[AdtFunction[Target, T16], AdtCoProduct.Use.Positive[AdtFunction[Target, T17], AdtCoProduct.Use.Positive[AdtFunction[Target, T18], AdtCoProduct.Use.Positive[AdtFunction[Target, T19], AdtCoProduct.Use.Positive[AdtFunction[Target, T20], AdtCoProduct.Use.Positive[AdtFunction[Target, T21], AdtCoProduct.Use.One[AdtFunction[Target, T22]]]]]]]]]]]]]]]]]]]]]]]]
      type CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = net.scalax.simple.adt.instance.support.CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
    
    }
  