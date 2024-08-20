
package net.scalax.simple
package adt
package impl

import temp._
import net.scalax.simple.ghdmzsk.ghdmzsk
import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}
import builder.{coproducter, producter_build, DataTaker}





trait TypeAdtAliasModelUnapply {
    object CoProduct1 {
        def unapply[I1, ADTExtension](data: ADTData[RuntimeData[I1, RuntimeNat], ADTExtension]): Option[I1] = data.toGHDMZSK match {
            case dt: DataTaker => Some(dt.data.asInstanceOf[I1])
            case _ => None
        }
    }

    
        object CoProduct2 {
            def unapply[   I1   ,  I2  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeNat 
] 
] 
, ADTExtension]): Option[I2] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options1GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I2])
                  case _ => None
                }
            }
        }
    
        object CoProduct3 {
            def unapply[   I1   ,  I2   ,  I3  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeNat 
] 
] 
] 
, ADTExtension]): Option[I3] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options2GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I3])
                  case _ => None
                }
            }
        }
    
        object CoProduct4 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeNat 
] 
] 
] 
] 
, ADTExtension]): Option[I4] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options3GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I4])
                  case _ => None
                }
            }
        }
    
        object CoProduct5 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeNat 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I5] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options4GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I5])
                  case _ => None
                }
            }
        }
    
        object CoProduct6 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I6] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options5GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I6])
                  case _ => None
                }
            }
        }
    
        object CoProduct7 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I7] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options6GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I7])
                  case _ => None
                }
            }
        }
    
        object CoProduct8 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I8] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options7GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I8])
                  case _ => None
                }
            }
        }
    
        object CoProduct9 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I9] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options8GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I9])
                  case _ => None
                }
            }
        }
    
        object CoProduct10 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I10] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options9GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I10])
                  case _ => None
                }
            }
        }
    
        object CoProduct11 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I11] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options10GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I11])
                  case _ => None
                }
            }
        }
    
        object CoProduct12 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I12] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options11GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I12])
                  case _ => None
                }
            }
        }
    
        object CoProduct13 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I13] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options12GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I13])
                  case _ => None
                }
            }
        }
    
        object CoProduct14 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I14] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options13GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I14])
                  case _ => None
                }
            }
        }
    
        object CoProduct15 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I15] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options14GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I15])
                  case _ => None
                }
            }
        }
    
        object CoProduct16 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeData[I16, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I16] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options15GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I16])
                  case _ => None
                }
            }
        }
    
        object CoProduct17 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeData[I16, 
     RuntimeData[I17, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I17] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options16GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I17])
                  case _ => None
                }
            }
        }
    
        object CoProduct18 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeData[I16, 
     RuntimeData[I17, 
     RuntimeData[I18, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I18] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options17GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I18])
                  case _ => None
                }
            }
        }
    
        object CoProduct19 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeData[I16, 
     RuntimeData[I17, 
     RuntimeData[I18, 
     RuntimeData[I19, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I19] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options18GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I19])
                  case _ => None
                }
            }
        }
    
        object CoProduct20 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeData[I16, 
     RuntimeData[I17, 
     RuntimeData[I18, 
     RuntimeData[I19, 
     RuntimeData[I20, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I20] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options19GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I20])
                  case _ => None
                }
            }
        }
    
        object CoProduct21 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeData[I16, 
     RuntimeData[I17, 
     RuntimeData[I18, 
     RuntimeData[I19, 
     RuntimeData[I20, 
     RuntimeData[I21, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I21] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options20GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I21])
                  case _ => None
                }
            }
        }
    
        object CoProduct22 {
            def unapply[   I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21   ,  I22  , ADTExtension](data: ADTData[
     RuntimeData[I1, 
     RuntimeData[I2, 
     RuntimeData[I3, 
     RuntimeData[I4, 
     RuntimeData[I5, 
     RuntimeData[I6, 
     RuntimeData[I7, 
     RuntimeData[I8, 
     RuntimeData[I9, 
     RuntimeData[I10, 
     RuntimeData[I11, 
     RuntimeData[I12, 
     RuntimeData[I13, 
     RuntimeData[I14, 
     RuntimeData[I15, 
     RuntimeData[I16, 
     RuntimeData[I17, 
     RuntimeData[I18, 
     RuntimeData[I19, 
     RuntimeData[I20, 
     RuntimeData[I21, 
     RuntimeData[I22, 
     RuntimeNat 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension]): Option[I22] = {
                val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options21GHDMZSK)

                dataInstance match {
                  case dt: DataTaker => Some(dt.data.asInstanceOf[I22])
                  case _ => None
                }
            }
        }
    
}

package impl {
    object TypeAdtAliasModelUnapplyGhdmzsk {
        val options1GHDMZSK: ghdmzsk = coproducter.failedOrOnlyTaker
        
            val options2GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options1GHDMZSK)
        
            val options3GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options2GHDMZSK)
        
            val options4GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options3GHDMZSK)
        
            val options5GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options4GHDMZSK)
        
            val options6GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options5GHDMZSK)
        
            val options7GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options6GHDMZSK)
        
            val options8GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options7GHDMZSK)
        
            val options9GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options8GHDMZSK)
        
            val options10GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options9GHDMZSK)
        
            val options11GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options10GHDMZSK)
        
            val options12GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options11GHDMZSK)
        
            val options13GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options12GHDMZSK)
        
            val options14GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options13GHDMZSK)
        
            val options15GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options14GHDMZSK)
        
            val options16GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options15GHDMZSK)
        
            val options17GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options16GHDMZSK)
        
            val options18GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options17GHDMZSK)
        
            val options19GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options18GHDMZSK)
        
            val options20GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options19GHDMZSK)
        
            val options21GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options20GHDMZSK)
        
            val options22GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options21GHDMZSK)
        
            val options23GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options22GHDMZSK)
        
            val options24GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options23GHDMZSK)
        
            val options25GHDMZSK: ghdmzsk = coproducter.appender.inputGHDMZSK(() => options24GHDMZSK)
        
    }
}
