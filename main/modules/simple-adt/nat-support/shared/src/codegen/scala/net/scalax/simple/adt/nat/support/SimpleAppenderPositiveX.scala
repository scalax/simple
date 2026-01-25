
    package net.scalax.simple.adt
    package nat
    package support

    
      trait SimpleAppender1Positive[M[_]] {
        
      def append[A1, B1, C1]
        (f1: ABCFunc[A1, B1, C1])
        (a: M[A1], b: M[B1])
        : M[C1]
    
      }
    

      trait SimpleAppender2Positive[M[_,_]] {
        
      def append[A1,A2, B1,B2, C1,C2]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2])
        (a: M[A1,A2], b: M[B1,B2])
        : M[C1,C2]
    
      }
    

      trait SimpleAppender3Positive[M[_,_,_]] {
        
      def append[A1,A2,A3, B1,B2,B3, C1,C2,C3]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3])
        (a: M[A1,A2,A3], b: M[B1,B2,B3])
        : M[C1,C2,C3]
    
      }
    

      trait SimpleAppender4Positive[M[_,_,_,_]] {
        
      def append[A1,A2,A3,A4, B1,B2,B3,B4, C1,C2,C3,C4]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4])
        (a: M[A1,A2,A3,A4], b: M[B1,B2,B3,B4])
        : M[C1,C2,C3,C4]
    
      }
    

      trait SimpleAppender5Positive[M[_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5, B1,B2,B3,B4,B5, C1,C2,C3,C4,C5]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5])
        (a: M[A1,A2,A3,A4,A5], b: M[B1,B2,B3,B4,B5])
        : M[C1,C2,C3,C4,C5]
    
      }
    

      trait SimpleAppender6Positive[M[_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6, B1,B2,B3,B4,B5,B6, C1,C2,C3,C4,C5,C6]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6])
        (a: M[A1,A2,A3,A4,A5,A6], b: M[B1,B2,B3,B4,B5,B6])
        : M[C1,C2,C3,C4,C5,C6]
    
      }
    

      trait SimpleAppender7Positive[M[_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7, B1,B2,B3,B4,B5,B6,B7, C1,C2,C3,C4,C5,C6,C7]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7])
        (a: M[A1,A2,A3,A4,A5,A6,A7], b: M[B1,B2,B3,B4,B5,B6,B7])
        : M[C1,C2,C3,C4,C5,C6,C7]
    
      }
    

      trait SimpleAppender8Positive[M[_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8, B1,B2,B3,B4,B5,B6,B7,B8, C1,C2,C3,C4,C5,C6,C7,C8]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8], b: M[B1,B2,B3,B4,B5,B6,B7,B8])
        : M[C1,C2,C3,C4,C5,C6,C7,C8]
    
      }
    

      trait SimpleAppender9Positive[M[_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9, B1,B2,B3,B4,B5,B6,B7,B8,B9, C1,C2,C3,C4,C5,C6,C7,C8,C9]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9]
    
      }
    

      trait SimpleAppender10Positive[M[_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10]
    
      }
    

      trait SimpleAppender11Positive[M[_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11]
    
      }
    

      trait SimpleAppender12Positive[M[_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12]
    
      }
    

      trait SimpleAppender13Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13]
    
      }
    

      trait SimpleAppender14Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14]
    
      }
    

      trait SimpleAppender15Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15]
    
      }
    

      trait SimpleAppender16Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15],f16: ABCFunc[A16, B16, C16])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16]
    
      }
    

      trait SimpleAppender17Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15],f16: ABCFunc[A16, B16, C16],f17: ABCFunc[A17, B17, C17])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17]
    
      }
    

      trait SimpleAppender18Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15],f16: ABCFunc[A16, B16, C16],f17: ABCFunc[A17, B17, C17],f18: ABCFunc[A18, B18, C18])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18]
    
      }
    

      trait SimpleAppender19Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15],f16: ABCFunc[A16, B16, C16],f17: ABCFunc[A17, B17, C17],f18: ABCFunc[A18, B18, C18],f19: ABCFunc[A19, B19, C19])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19]
    
      }
    

      trait SimpleAppender20Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19,A20, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15],f16: ABCFunc[A16, B16, C16],f17: ABCFunc[A17, B17, C17],f18: ABCFunc[A18, B18, C18],f19: ABCFunc[A19, B19, C19],f20: ABCFunc[A20, B20, C20])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19,A20], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20]
    
      }
    

      trait SimpleAppender21Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19,A20,A21, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15],f16: ABCFunc[A16, B16, C16],f17: ABCFunc[A17, B17, C17],f18: ABCFunc[A18, B18, C18],f19: ABCFunc[A19, B19, C19],f20: ABCFunc[A20, B20, C20],f21: ABCFunc[A21, B21, C21])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19,A20,A21], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21]
    
      }
    

      trait SimpleAppender22Positive[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def append[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19,A20,A21,A22, B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22, C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22]
        (f1: ABCFunc[A1, B1, C1],f2: ABCFunc[A2, B2, C2],f3: ABCFunc[A3, B3, C3],f4: ABCFunc[A4, B4, C4],f5: ABCFunc[A5, B5, C5],f6: ABCFunc[A6, B6, C6],f7: ABCFunc[A7, B7, C7],f8: ABCFunc[A8, B8, C8],f9: ABCFunc[A9, B9, C9],f10: ABCFunc[A10, B10, C10],f11: ABCFunc[A11, B11, C11],f12: ABCFunc[A12, B12, C12],f13: ABCFunc[A13, B13, C13],f14: ABCFunc[A14, B14, C14],f15: ABCFunc[A15, B15, C15],f16: ABCFunc[A16, B16, C16],f17: ABCFunc[A17, B17, C17],f18: ABCFunc[A18, B18, C18],f19: ABCFunc[A19, B19, C19],f20: ABCFunc[A20, B20, C20],f21: ABCFunc[A21, B21, C21],f22: ABCFunc[A22, B22, C22])
        (a: M[A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19,A20,A21,A22], b: M[B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22])
        : M[C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22]
    
      }
    
  