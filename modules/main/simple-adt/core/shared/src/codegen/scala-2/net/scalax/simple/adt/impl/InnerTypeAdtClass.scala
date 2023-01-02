package net.scalax.simple.adt
package impl

import core._







object InnerTypeAdtClass {
    
        class CusInnerApply1[   I1  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T  ): T = adtList.method1(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl1 extends HelperIO[Any] {
            override type Out = CusInnerApply1[   Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply1[   Any  ] = new CusInnerApply1(adtList)
        }
    
        class CusInnerApply2[   I1   ,  I2  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl2 extends HelperIO[Any] {
            override type Out = CusInnerApply2[   Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply2[   Any   ,  Any  ] = new CusInnerApply2(adtList)
        }
    
        class CusInnerApply3[   I1   ,  I2   ,  I3  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl3 extends HelperIO[Any] {
            override type Out = CusInnerApply3[   Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply3[   Any   ,  Any   ,  Any  ] = new CusInnerApply3(adtList)
        }
    
        class CusInnerApply4[   I1   ,  I2   ,  I3   ,  I4  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl4 extends HelperIO[Any] {
            override type Out = CusInnerApply4[   Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply4[   Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply4(adtList)
        }
    
        class CusInnerApply5[   I1   ,  I2   ,  I3   ,  I4   ,  I5  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl5 extends HelperIO[Any] {
            override type Out = CusInnerApply5[   Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply5[   Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply5(adtList)
        }
    
        class CusInnerApply6[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl6 extends HelperIO[Any] {
            override type Out = CusInnerApply6[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply6[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply6(adtList)
        }
    
        class CusInnerApply7[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl7 extends HelperIO[Any] {
            override type Out = CusInnerApply7[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply7[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply7(adtList)
        }
    
        class CusInnerApply8[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl8 extends HelperIO[Any] {
            override type Out = CusInnerApply8[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply8[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply8(adtList)
        }
    
        class CusInnerApply9[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl9 extends HelperIO[Any] {
            override type Out = CusInnerApply9[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply9[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply9(adtList)
        }
    
        class CusInnerApply10[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl10 extends HelperIO[Any] {
            override type Out = CusInnerApply10[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply10[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply10(adtList)
        }
    
        class CusInnerApply11[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl11 extends HelperIO[Any] {
            override type Out = CusInnerApply11[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply11[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply11(adtList)
        }
    
        class CusInnerApply12[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl12 extends HelperIO[Any] {
            override type Out = CusInnerApply12[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply12[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply12(adtList)
        }
    
        class CusInnerApply13[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl13 extends HelperIO[Any] {
            override type Out = CusInnerApply13[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply13[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply13(adtList)
        }
    
        class CusInnerApply14[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl14 extends HelperIO[Any] {
            override type Out = CusInnerApply14[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply14[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply14(adtList)
        }
    
        class CusInnerApply15[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl15 extends HelperIO[Any] {
            override type Out = CusInnerApply15[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply15[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply15(adtList)
        }
    
        class CusInnerApply16[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T   ,  func16: I16 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func16.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl16 extends HelperIO[Any] {
            override type Out = CusInnerApply16[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply16[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply16(adtList)
        }
    
        class CusInnerApply17[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T   ,  func16: I16 => T   ,  func17: I17 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func17.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func16.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl17 extends HelperIO[Any] {
            override type Out = CusInnerApply17[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply17[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply17(adtList)
        }
    
        class CusInnerApply18[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T   ,  func16: I16 => T   ,  func17: I17 => T   ,  func18: I18 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func18.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func17.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func16.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl18 extends HelperIO[Any] {
            override type Out = CusInnerApply18[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply18[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply18(adtList)
        }
    
        class CusInnerApply19[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T   ,  func16: I16 => T   ,  func17: I17 => T   ,  func18: I18 => T   ,  func19: I19 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func19.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func18.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func17.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func16.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl19 extends HelperIO[Any] {
            override type Out = CusInnerApply19[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply19[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply19(adtList)
        }
    
        class CusInnerApply20[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T   ,  func16: I16 => T   ,  func17: I17 => T   ,  func18: I18 => T   ,  func19: I19 => T   ,  func20: I20 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func20.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func19.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func18.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func17.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func16.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl20 extends HelperIO[Any] {
            override type Out = CusInnerApply20[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply20[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply20(adtList)
        }
    
        class CusInnerApply21[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T   ,  func16: I16 => T   ,  func17: I17 => T   ,  func18: I18 => T   ,  func19: I19 => T   ,  func20: I20 => T   ,  func21: I21 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func21.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func20.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func19.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func18.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func17.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func16.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl21 extends HelperIO[Any] {
            override type Out = CusInnerApply21[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply21[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply21(adtList)
        }
    
        class CusInnerApply22[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21   ,  I22  ](adtList: AdtList) {
            @inline def fold[T](   func1: I1 => T   ,  func2: I2 => T   ,  func3: I3 => T   ,  func4: I4 => T   ,  func5: I5 => T   ,  func6: I6 => T   ,  func7: I7 => T   ,  func8: I8 => T   ,  func9: I9 => T   ,  func10: I10 => T   ,  func11: I11 => T   ,  func12: I12 => T   ,  func13: I13 => T   ,  func14: I14 => T   ,  func15: I15 => T   ,  func16: I16 => T   ,  func17: I17 => T   ,  func18: I18 => T   ,  func19: I19 => T   ,  func20: I20 => T   ,  func21: I21 => T   ,  func22: I22 => T  ): T = adtList.method1(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  new FoldListPositive(  FoldList.zero ) with (Any => Any) {
    override def apply(value: Any): Any = func22.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func21.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func20.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func19.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func18.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func17.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func16.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func15.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func14.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func13.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func12.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func11.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func10.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func9.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func8.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func7.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func6.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func5.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func4.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func3.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func2.asInstanceOf[Any => Any](value)
} ) with (Any => Any) {
    override def apply(value: Any): Any = func1.asInstanceOf[Any => Any](value)
} ).asInstanceOf[T]
        }
        object HelperIOImpl22 extends HelperIO[Any] {
            override type Out = CusInnerApply22[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ]
            @inline override def helper(adtList: AdtList): CusInnerApply22[   Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any   ,  Any  ] = new CusInnerApply22(adtList)
        }
    
}
