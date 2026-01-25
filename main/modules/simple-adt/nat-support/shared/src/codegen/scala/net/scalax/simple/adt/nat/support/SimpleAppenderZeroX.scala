
    package net.scalax.simple.adt
    package nat
    package support

    
      trait SimpleAppender1Zero[M[_]] {
        
      def zero[N1](p1: N1): M[N1]
    
      }
    

      trait SimpleAppender2Zero[M[_,_]] {
        
      def zero[N1,N2](p1: N1,p2: N2): M[N1,N2]
    
      }
    

      trait SimpleAppender3Zero[M[_,_,_]] {
        
      def zero[N1,N2,N3](p1: N1,p2: N2,p3: N3): M[N1,N2,N3]
    
      }
    

      trait SimpleAppender4Zero[M[_,_,_,_]] {
        
      def zero[N1,N2,N3,N4](p1: N1,p2: N2,p3: N3,p4: N4): M[N1,N2,N3,N4]
    
      }
    

      trait SimpleAppender5Zero[M[_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5): M[N1,N2,N3,N4,N5]
    
      }
    

      trait SimpleAppender6Zero[M[_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6): M[N1,N2,N3,N4,N5,N6]
    
      }
    

      trait SimpleAppender7Zero[M[_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7): M[N1,N2,N3,N4,N5,N6,N7]
    
      }
    

      trait SimpleAppender8Zero[M[_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8): M[N1,N2,N3,N4,N5,N6,N7,N8]
    
      }
    

      trait SimpleAppender9Zero[M[_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9): M[N1,N2,N3,N4,N5,N6,N7,N8,N9]
    
      }
    

      trait SimpleAppender10Zero[M[_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10]
    
      }
    

      trait SimpleAppender11Zero[M[_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11]
    
      }
    

      trait SimpleAppender12Zero[M[_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12]
    
      }
    

      trait SimpleAppender13Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13]
    
      }
    

      trait SimpleAppender14Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14]
    
      }
    

      trait SimpleAppender15Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15]
    
      }
    

      trait SimpleAppender16Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15,p16: N16): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16]
    
      }
    

      trait SimpleAppender17Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15,p16: N16,p17: N17): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17]
    
      }
    

      trait SimpleAppender18Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15,p16: N16,p17: N17,p18: N18): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18]
    
      }
    

      trait SimpleAppender19Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15,p16: N16,p17: N17,p18: N18,p19: N19): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19]
    
      }
    

      trait SimpleAppender20Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15,p16: N16,p17: N17,p18: N18,p19: N19,p20: N20): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20]
    
      }
    

      trait SimpleAppender21Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15,p16: N16,p17: N17,p18: N18,p19: N19,p20: N20,p21: N21): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21]
    
      }
    

      trait SimpleAppender22Zero[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] {
        
      def zero[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22](p1: N1,p2: N2,p3: N3,p4: N4,p5: N5,p6: N6,p7: N7,p8: N8,p9: N9,p10: N10,p11: N11,p12: N12,p13: N13,p14: N14,p15: N15,p16: N16,p17: N17,p18: N18,p19: N19,p20: N20,p21: N21,p22: N22): M[N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22]
    
      }
    
  