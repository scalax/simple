
  package net.scalax.simple.adt
  package impl

  import temp._
  import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}

  trait TypeAdtRuntimeApply {
    
      def CoProduct1[I1]:  CoProduct1Apply[I1] = new CoProduct1Apply[I1] {
        //
      }

      trait CoProduct1Apply[I1] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeZero] })#F1, RuntimeData[I1, RuntimeZero]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra1(b).fold(Tuple1(t => option1(t.adtFunctionApply(a))))
         }

      }
      def CoProduct2[I1 , I2]:  CoProduct2Apply[I1 , I2] = new CoProduct2Apply[I1 , I2] {
        //
      }

      trait CoProduct2Apply[I1 , I2] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeZero]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeZero]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra2(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)))
         }

      }
      def CoProduct3[I1 , I2 , I3]:  CoProduct3Apply[I1 , I2 , I3] = new CoProduct3Apply[I1 , I2 , I3] {
        //
      }

      trait CoProduct3Apply[I1 , I2 , I3] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeZero]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeZero]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra3(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)))
         }

      }
      def CoProduct4[I1 , I2 , I3 , I4]:  CoProduct4Apply[I1 , I2 , I3 , I4] = new CoProduct4Apply[I1 , I2 , I3 , I4] {
        //
      }

      trait CoProduct4Apply[I1 , I2 , I3 , I4] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeZero]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeZero]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra4(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)))
         }

      }
      def CoProduct5[I1 , I2 , I3 , I4 , I5]:  CoProduct5Apply[I1 , I2 , I3 , I4 , I5] = new CoProduct5Apply[I1 , I2 , I3 , I4 , I5] {
        //
      }

      trait CoProduct5Apply[I1 , I2 , I3 , I4 , I5] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeZero]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeZero]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra5(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)))
         }

      }
      def CoProduct6[I1 , I2 , I3 , I4 , I5 , I6]:  CoProduct6Apply[I1 , I2 , I3 , I4 , I5 , I6] = new CoProduct6Apply[I1 , I2 , I3 , I4 , I5 , I6] {
        //
      }

      trait CoProduct6Apply[I1 , I2 , I3 , I4 , I5 , I6] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeZero]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeZero]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra6(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)))
         }

      }
      def CoProduct7[I1 , I2 , I3 , I4 , I5 , I6 , I7]:  CoProduct7Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7] = new CoProduct7Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7] {
        //
      }

      trait CoProduct7Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeZero]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeZero]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra7(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)))
         }

      }
      def CoProduct8[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8]:  CoProduct8Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8] = new CoProduct8Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8] {
        //
      }

      trait CoProduct8Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeZero]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeZero]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra8(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)))
         }

      }
      def CoProduct9[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9]:  CoProduct9Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9] = new CoProduct9Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9] {
        //
      }

      trait CoProduct9Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeZero]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeZero]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra9(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)))
         }

      }
      def CoProduct10[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10]:  CoProduct10Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10] = new CoProduct10Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10] {
        //
      }

      trait CoProduct10Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeZero]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeZero]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra10(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)))
         }

      }
      def CoProduct11[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11]:  CoProduct11Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11] = new CoProduct11Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11] {
        //
      }

      trait CoProduct11Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeZero]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeZero]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra11(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)))
         }

      }
      def CoProduct12[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12]:  CoProduct12Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12] = new CoProduct12Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12] {
        //
      }

      trait CoProduct12Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeZero]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeZero]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra12(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)))
         }

      }
      def CoProduct13[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13]:  CoProduct13Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13] = new CoProduct13Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13] {
        //
      }

      trait CoProduct13Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeZero]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeZero]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra13(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)))
         }

      }
      def CoProduct14[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14]:  CoProduct14Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14] = new CoProduct14Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14] {
        //
      }

      trait CoProduct14Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeZero]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeZero]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra14(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)))
         }

      }
      def CoProduct15[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15]:  CoProduct15Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15] = new CoProduct15Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15] {
        //
      }

      trait CoProduct15Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeZero]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeZero]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra15(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)))
         }

      }
      def CoProduct16[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16]:  CoProduct16Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16] = new CoProduct16Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16] {
        //
      }

      trait CoProduct16Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeData[AdtFunction[ParamType, I16], RuntimeZero]]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeZero]]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))
def option16(iData: I16): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra16(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)) , t => option16(t.adtFunctionApply(a)))
         }

      }
      def CoProduct17[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17]:  CoProduct17Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17] = new CoProduct17Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17] {
        //
      }

      trait CoProduct17Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeData[AdtFunction[ParamType, I16], RuntimeData[AdtFunction[ParamType, I17], RuntimeZero]]]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeZero]]]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))
def option16(iData: I16): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))
def option17(iData: I17): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra17(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)) , t => option16(t.adtFunctionApply(a)) , t => option17(t.adtFunctionApply(a)))
         }

      }
      def CoProduct18[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18]:  CoProduct18Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18] = new CoProduct18Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18] {
        //
      }

      trait CoProduct18Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeData[AdtFunction[ParamType, I16], RuntimeData[AdtFunction[ParamType, I17], RuntimeData[AdtFunction[ParamType, I18], RuntimeZero]]]]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeZero]]]]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))
def option16(iData: I16): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))
def option17(iData: I17): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))
def option18(iData: I18): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra18(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)) , t => option16(t.adtFunctionApply(a)) , t => option17(t.adtFunctionApply(a)) , t => option18(t.adtFunctionApply(a)))
         }

      }
      def CoProduct19[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19]:  CoProduct19Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19] = new CoProduct19Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19] {
        //
      }

      trait CoProduct19Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeData[AdtFunction[ParamType, I16], RuntimeData[AdtFunction[ParamType, I17], RuntimeData[AdtFunction[ParamType, I18], RuntimeData[AdtFunction[ParamType, I19], RuntimeZero]]]]]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeZero]]]]]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))
def option16(iData: I16): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))
def option17(iData: I17): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))
def option18(iData: I18): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))
def option19(iData: I19): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra19(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)) , t => option16(t.adtFunctionApply(a)) , t => option17(t.adtFunctionApply(a)) , t => option18(t.adtFunctionApply(a)) , t => option19(t.adtFunctionApply(a)))
         }

      }
      def CoProduct20[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20]:  CoProduct20Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20] = new CoProduct20Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20] {
        //
      }

      trait CoProduct20Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeData[AdtFunction[ParamType, I16], RuntimeData[AdtFunction[ParamType, I17], RuntimeData[AdtFunction[ParamType, I18], RuntimeData[AdtFunction[ParamType, I19], RuntimeData[AdtFunction[ParamType, I20], RuntimeZero]]]]]]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeZero]]]]]]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))
def option16(iData: I16): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))
def option17(iData: I17): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))
def option18(iData: I18): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))
def option19(iData: I19): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))))
def option20(iData: I20): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra20(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)) , t => option16(t.adtFunctionApply(a)) , t => option17(t.adtFunctionApply(a)) , t => option18(t.adtFunctionApply(a)) , t => option19(t.adtFunctionApply(a)) , t => option20(t.adtFunctionApply(a)))
         }

      }
      def CoProduct21[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21]:  CoProduct21Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21] = new CoProduct21Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21] {
        //
      }

      trait CoProduct21Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeData[AdtFunction[ParamType, I16], RuntimeData[AdtFunction[ParamType, I17], RuntimeData[AdtFunction[ParamType, I18], RuntimeData[AdtFunction[ParamType, I19], RuntimeData[AdtFunction[ParamType, I20], RuntimeData[AdtFunction[ParamType, I21], RuntimeZero]]]]]]]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeData[I21, RuntimeZero]]]]]]]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))
def option16(iData: I16): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))
def option17(iData: I17): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))
def option18(iData: I18): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))
def option19(iData: I19): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))))
def option20(iData: I20): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))))
def option21(iData: I21): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra21(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)) , t => option16(t.adtFunctionApply(a)) , t => option17(t.adtFunctionApply(a)) , t => option18(t.adtFunctionApply(a)) , t => option19(t.adtFunctionApply(a)) , t => option20(t.adtFunctionApply(a)) , t => option21(t.adtFunctionApply(a)))
         }

      }
      def CoProduct22[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21 , I22]:  CoProduct22Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21 , I22] = new CoProduct22Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21 , I22] {
        //
      }

      trait CoProduct22Apply[I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , I11 , I12 , I13 , I14 , I15 , I16 , I17 , I18 , I19 , I20 , I21 , I22] extends ApplyFactory[({ type F1[ParamType] = RuntimeData[AdtFunction[ParamType, I1], RuntimeData[AdtFunction[ParamType, I2], RuntimeData[AdtFunction[ParamType, I3], RuntimeData[AdtFunction[ParamType, I4], RuntimeData[AdtFunction[ParamType, I5], RuntimeData[AdtFunction[ParamType, I6], RuntimeData[AdtFunction[ParamType, I7], RuntimeData[AdtFunction[ParamType, I8], RuntimeData[AdtFunction[ParamType, I9], RuntimeData[AdtFunction[ParamType, I10], RuntimeData[AdtFunction[ParamType, I11], RuntimeData[AdtFunction[ParamType, I12], RuntimeData[AdtFunction[ParamType, I13], RuntimeData[AdtFunction[ParamType, I14], RuntimeData[AdtFunction[ParamType, I15], RuntimeData[AdtFunction[ParamType, I16], RuntimeData[AdtFunction[ParamType, I17], RuntimeData[AdtFunction[ParamType, I18], RuntimeData[AdtFunction[ParamType, I19], RuntimeData[AdtFunction[ParamType, I20], RuntimeData[AdtFunction[ParamType, I21], RuntimeData[AdtFunction[ParamType, I22], RuntimeZero]]]]]]]]]]]]]]]]]]]]]] })#F1, RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeData[I21, RuntimeData[I22, RuntimeZero]]]]]]]]]]]]]]]]]]]]]]] {

        
def option1(iData: I1): this.NatModelType = ADTData.success(iData)
def option2(iData: I2): this.NatModelType = ADTData.copyTail(ADTData.success(iData))
def option3(iData: I3): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))
def option4(iData: I4): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))
def option5(iData: I5): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))
def option6(iData: I6): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))
def option7(iData: I7): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))
def option8(iData: I8): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))
def option9(iData: I9): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))
def option10(iData: I10): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))
def option11(iData: I11): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))
def option12(iData: I12): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))
def option13(iData: I13): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))
def option14(iData: I14): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))
def option15(iData: I15): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))
def option16(iData: I16): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))
def option17(iData: I17): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))
def option18(iData: I18): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))
def option19(iData: I19): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))))
def option20(iData: I20): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))))
def option21(iData: I21): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData)))))))))))))))))))))
def option22(iData: I22): this.NatModelType = ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.copyTail(ADTData.success(iData))))))))))))))))))))))

        override def apply[ParamType, ADTExtension](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTExtension with ADTTypeParameterFetch.type]): NatModelType = {
           new ADTPassedFunction.extra22(b).fold(t => option1(t.adtFunctionApply(a)) , t => option2(t.adtFunctionApply(a)) , t => option3(t.adtFunctionApply(a)) , t => option4(t.adtFunctionApply(a)) , t => option5(t.adtFunctionApply(a)) , t => option6(t.adtFunctionApply(a)) , t => option7(t.adtFunctionApply(a)) , t => option8(t.adtFunctionApply(a)) , t => option9(t.adtFunctionApply(a)) , t => option10(t.adtFunctionApply(a)) , t => option11(t.adtFunctionApply(a)) , t => option12(t.adtFunctionApply(a)) , t => option13(t.adtFunctionApply(a)) , t => option14(t.adtFunctionApply(a)) , t => option15(t.adtFunctionApply(a)) , t => option16(t.adtFunctionApply(a)) , t => option17(t.adtFunctionApply(a)) , t => option18(t.adtFunctionApply(a)) , t => option19(t.adtFunctionApply(a)) , t => option20(t.adtFunctionApply(a)) , t => option21(t.adtFunctionApply(a)) , t => option22(t.adtFunctionApply(a)))
         }

      }
  }
  
