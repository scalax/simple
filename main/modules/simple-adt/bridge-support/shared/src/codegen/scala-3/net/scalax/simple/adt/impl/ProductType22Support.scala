
    package net.scalax.simple.adt
    package utils

    import support.S3Support

    object Product22Gen {
      def gen[
        Append1, AppendPositive1[_, _ <: Append1] <: Append1, AppendZero1 <: Append1,
        Append2, AppendPositive2[_, _ <: Append2] <: Append2, AppendZero2 <: Append2,
        M3[_ <: Append1, _ <: Append2, _ <: S3Support.Func[_]],
        M4[_ <: Append1, _ <: Append2, _[_] <: Any]
      ](
        appender: ProductType22Appender[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, S3Support.Func[_], S3Support.Append11, S3Support.Zero, M3],
        tran: S3Support.M1ToM2[Append1, Append2, M3, M4]
      ): ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] =
        new ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] {
          
      override def InstanceImpl0:
        M4[
          AP1#Parameter0,
          AP2#Parameter0,
          Folder22TypeParam#Parameter0#Result
        ] = tran.to[
          AP1#Parameter0,
          AP2#Parameter0,
          Folder22TypeParam#Parameter0#Result
        ](appender.Instance0)
      



      override def InstanceImpl1[I1]:
        M4[
          AP1#Parameter1[I1],
          AP2#Parameter1[I1],
          Folder22TypeParam#Parameter1[I1]#Result
        ] = tran.to[
          AP1#Parameter1[I1],
          AP2#Parameter1[I1],
          Folder22TypeParam#Parameter1[I1]#Result
        ](appender.Instance1[I1])
      



      override def InstanceImpl2[I1,I2]:
        M4[
          AP1#Parameter2[I1,I2],
          AP2#Parameter2[I1,I2],
          Folder22TypeParam#Parameter2[I1,I2]#Result
        ] = tran.to[
          AP1#Parameter2[I1,I2],
          AP2#Parameter2[I1,I2],
          Folder22TypeParam#Parameter2[I1,I2]#Result
        ](appender.Instance2[I1,I2])
      



      override def InstanceImpl3[I1,I2,I3]:
        M4[
          AP1#Parameter3[I1,I2,I3],
          AP2#Parameter3[I1,I2,I3],
          Folder22TypeParam#Parameter3[I1,I2,I3]#Result
        ] = tran.to[
          AP1#Parameter3[I1,I2,I3],
          AP2#Parameter3[I1,I2,I3],
          Folder22TypeParam#Parameter3[I1,I2,I3]#Result
        ](appender.Instance3[I1,I2,I3])
      



      override def InstanceImpl4[I1,I2,I3,I4]:
        M4[
          AP1#Parameter4[I1,I2,I3,I4],
          AP2#Parameter4[I1,I2,I3,I4],
          Folder22TypeParam#Parameter4[I1,I2,I3,I4]#Result
        ] = tran.to[
          AP1#Parameter4[I1,I2,I3,I4],
          AP2#Parameter4[I1,I2,I3,I4],
          Folder22TypeParam#Parameter4[I1,I2,I3,I4]#Result
        ](appender.Instance4[I1,I2,I3,I4])
      



      override def InstanceImpl5[I1,I2,I3,I4,I5]:
        M4[
          AP1#Parameter5[I1,I2,I3,I4,I5],
          AP2#Parameter5[I1,I2,I3,I4,I5],
          Folder22TypeParam#Parameter5[I1,I2,I3,I4,I5]#Result
        ] = tran.to[
          AP1#Parameter5[I1,I2,I3,I4,I5],
          AP2#Parameter5[I1,I2,I3,I4,I5],
          Folder22TypeParam#Parameter5[I1,I2,I3,I4,I5]#Result
        ](appender.Instance5[I1,I2,I3,I4,I5])
      



      override def InstanceImpl6[I1,I2,I3,I4,I5,I6]:
        M4[
          AP1#Parameter6[I1,I2,I3,I4,I5,I6],
          AP2#Parameter6[I1,I2,I3,I4,I5,I6],
          Folder22TypeParam#Parameter6[I1,I2,I3,I4,I5,I6]#Result
        ] = tran.to[
          AP1#Parameter6[I1,I2,I3,I4,I5,I6],
          AP2#Parameter6[I1,I2,I3,I4,I5,I6],
          Folder22TypeParam#Parameter6[I1,I2,I3,I4,I5,I6]#Result
        ](appender.Instance6[I1,I2,I3,I4,I5,I6])
      



      override def InstanceImpl7[I1,I2,I3,I4,I5,I6,I7]:
        M4[
          AP1#Parameter7[I1,I2,I3,I4,I5,I6,I7],
          AP2#Parameter7[I1,I2,I3,I4,I5,I6,I7],
          Folder22TypeParam#Parameter7[I1,I2,I3,I4,I5,I6,I7]#Result
        ] = tran.to[
          AP1#Parameter7[I1,I2,I3,I4,I5,I6,I7],
          AP2#Parameter7[I1,I2,I3,I4,I5,I6,I7],
          Folder22TypeParam#Parameter7[I1,I2,I3,I4,I5,I6,I7]#Result
        ](appender.Instance7[I1,I2,I3,I4,I5,I6,I7])
      



      override def InstanceImpl8[I1,I2,I3,I4,I5,I6,I7,I8]:
        M4[
          AP1#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8],
          AP2#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8],
          Folder22TypeParam#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8]#Result
        ] = tran.to[
          AP1#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8],
          AP2#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8],
          Folder22TypeParam#Parameter8[I1,I2,I3,I4,I5,I6,I7,I8]#Result
        ](appender.Instance8[I1,I2,I3,I4,I5,I6,I7,I8])
      



      override def InstanceImpl9[I1,I2,I3,I4,I5,I6,I7,I8,I9]:
        M4[
          AP1#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9],
          AP2#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9],
          Folder22TypeParam#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9]#Result
        ] = tran.to[
          AP1#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9],
          AP2#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9],
          Folder22TypeParam#Parameter9[I1,I2,I3,I4,I5,I6,I7,I8,I9]#Result
        ](appender.Instance9[I1,I2,I3,I4,I5,I6,I7,I8,I9])
      



      override def InstanceImpl10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10]:
        M4[
          AP1#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],
          AP2#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],
          Folder22TypeParam#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10]#Result
        ] = tran.to[
          AP1#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],
          AP2#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],
          Folder22TypeParam#Parameter10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10]#Result
        ](appender.Instance10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10])
      



      override def InstanceImpl11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11]:
        M4[
          AP1#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],
          AP2#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],
          Folder22TypeParam#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11]#Result
        ] = tran.to[
          AP1#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],
          AP2#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],
          Folder22TypeParam#Parameter11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11]#Result
        ](appender.Instance11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11])
      



      override def InstanceImpl12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12]:
        M4[
          AP1#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],
          AP2#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],
          Folder22TypeParam#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12]#Result
        ] = tran.to[
          AP1#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],
          AP2#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],
          Folder22TypeParam#Parameter12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12]#Result
        ](appender.Instance12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12])
      



      override def InstanceImpl13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13]:
        M4[
          AP1#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],
          AP2#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],
          Folder22TypeParam#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13]#Result
        ] = tran.to[
          AP1#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],
          AP2#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],
          Folder22TypeParam#Parameter13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13]#Result
        ](appender.Instance13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13])
      



      override def InstanceImpl14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14]:
        M4[
          AP1#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],
          AP2#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],
          Folder22TypeParam#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14]#Result
        ] = tran.to[
          AP1#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],
          AP2#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],
          Folder22TypeParam#Parameter14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14]#Result
        ](appender.Instance14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14])
      



      override def InstanceImpl15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15]:
        M4[
          AP1#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],
          AP2#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],
          Folder22TypeParam#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15]#Result
        ] = tran.to[
          AP1#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],
          AP2#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],
          Folder22TypeParam#Parameter15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15]#Result
        ](appender.Instance15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15])
      



      override def InstanceImpl16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16]:
        M4[
          AP1#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],
          AP2#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],
          Folder22TypeParam#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16]#Result
        ] = tran.to[
          AP1#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],
          AP2#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],
          Folder22TypeParam#Parameter16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16]#Result
        ](appender.Instance16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16])
      



      override def InstanceImpl17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17]:
        M4[
          AP1#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],
          AP2#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],
          Folder22TypeParam#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17]#Result
        ] = tran.to[
          AP1#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],
          AP2#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],
          Folder22TypeParam#Parameter17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17]#Result
        ](appender.Instance17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17])
      



      override def InstanceImpl18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18]:
        M4[
          AP1#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],
          AP2#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],
          Folder22TypeParam#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18]#Result
        ] = tran.to[
          AP1#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],
          AP2#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],
          Folder22TypeParam#Parameter18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18]#Result
        ](appender.Instance18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18])
      



      override def InstanceImpl19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19]:
        M4[
          AP1#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],
          AP2#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],
          Folder22TypeParam#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19]#Result
        ] = tran.to[
          AP1#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],
          AP2#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],
          Folder22TypeParam#Parameter19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19]#Result
        ](appender.Instance19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19])
      



      override def InstanceImpl20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20]:
        M4[
          AP1#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],
          AP2#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],
          Folder22TypeParam#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20]#Result
        ] = tran.to[
          AP1#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],
          AP2#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],
          Folder22TypeParam#Parameter20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20]#Result
        ](appender.Instance20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20])
      



      override def InstanceImpl21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21]:
        M4[
          AP1#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],
          AP2#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],
          Folder22TypeParam#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21]#Result
        ] = tran.to[
          AP1#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],
          AP2#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],
          Folder22TypeParam#Parameter21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21]#Result
        ](appender.Instance21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21])
      



      override def InstanceImpl22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22]:
        M4[
          AP1#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],
          AP2#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],
          Folder22TypeParam#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22]#Result
        ] = tran.to[
          AP1#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],
          AP2#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],
          Folder22TypeParam#Parameter22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22]#Result
        ](appender.Instance22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22])
      
        }
    }
  
