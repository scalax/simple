
package net.scalax.simple
package adt
package impl

import temp._







trait TypeAdtAlias {
    
        type CoProducts1[A, 
      I1 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeZero 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX1[A, ADTExtension, 
      I1 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeZero 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts2[A, 
      I1   ,  I2 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeZero 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX2[A, ADTExtension, 
      I1   ,  I2 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeZero 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts3[A, 
      I1   ,  I2   ,  I3 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeZero 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX3[A, ADTExtension, 
      I1   ,  I2   ,  I3 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeZero 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts4[A, 
      I1   ,  I2   ,  I3   ,  I4 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeZero 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX4[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeZero 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts5[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeZero 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX5[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeZero 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts6[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX6[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts7[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX7[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts8[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX8[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts9[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX9[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts10[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX10[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts11[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX11[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts12[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX12[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts13[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX13[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts14[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX14[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts15[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX15[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts16[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX16[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts17[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX17[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts18[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX18[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts19[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX19[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts20[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeData[AdtFunction[A, I20], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX20[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeData[AdtFunction[A, I20], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts21[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeData[AdtFunction[A, I20], 
     RuntimeData[AdtFunction[A, I21], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX21[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeData[AdtFunction[A, I20], 
     RuntimeData[AdtFunction[A, I21], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
        type CoProducts22[A, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21   ,  I22 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeData[AdtFunction[A, I20], 
     RuntimeData[AdtFunction[A, I21], 
     RuntimeData[AdtFunction[A, I22], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTPassedFunction.type with ADTTypeParameterFetch.type]
        type CoProductsX22[A, ADTExtension, 
      I1   ,  I2   ,  I3   ,  I4   ,  I5   ,  I6   ,  I7   ,  I8   ,  I9   ,  I10   ,  I11   ,  I12   ,  I13   ,  I14   ,  I15   ,  I16   ,  I17   ,  I18   ,  I19   ,  I20   ,  I21   ,  I22 
] = ADTData[
     RuntimeData[AdtFunction[A, I1], 
     RuntimeData[AdtFunction[A, I2], 
     RuntimeData[AdtFunction[A, I3], 
     RuntimeData[AdtFunction[A, I4], 
     RuntimeData[AdtFunction[A, I5], 
     RuntimeData[AdtFunction[A, I6], 
     RuntimeData[AdtFunction[A, I7], 
     RuntimeData[AdtFunction[A, I8], 
     RuntimeData[AdtFunction[A, I9], 
     RuntimeData[AdtFunction[A, I10], 
     RuntimeData[AdtFunction[A, I11], 
     RuntimeData[AdtFunction[A, I12], 
     RuntimeData[AdtFunction[A, I13], 
     RuntimeData[AdtFunction[A, I14], 
     RuntimeData[AdtFunction[A, I15], 
     RuntimeData[AdtFunction[A, I16], 
     RuntimeData[AdtFunction[A, I17], 
     RuntimeData[AdtFunction[A, I18], 
     RuntimeData[AdtFunction[A, I19], 
     RuntimeData[AdtFunction[A, I20], 
     RuntimeData[AdtFunction[A, I21], 
     RuntimeData[AdtFunction[A, I22], 
     RuntimeZero 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
] 
, ADTExtension with ADTTypeParameterFetch.type]
    
}
