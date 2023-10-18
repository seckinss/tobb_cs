`timescale 1ns / 1ps

module odev1_devre(
        input A,
        input B,
        input C,
        output F,
        output Q
   
    );
    wire bA;
    buf b1(bA,A);
    
    wire bAnorB;
    nor o1(bAnorB,bA,B);

    wire nC;
    not n2(nC,C);
    
    wire nCa0;
    and a1(nCa0,nC,1'b0);
    
    wire w5;
    nand na1(w5,bAnorB,nC);
    
    xor x1(F,w5,nCa0);
    
    wire w6;
    xnor xn1(w6,w5,nCa0);
    
    or o2(Q,F,w6);
    
endmodule
