`timescale 1ns / 1ps

module odev1_fonk(
        input A,
        input B,
        input C,
        input D,
        input E,
        output F
   
    );
    
    
    wire w1,w2,w3,w4,w5,w6,nw3,nA,nC,nD,nE;
    
    not(nA,A);
    not(nC,C);
    not(nD,D);
    not(nE,E);

    and(w1,nA,B,C,nD);
    and(w2,B,C,nE);
    or(w3,w1,w2);
    not(nw3,w3);
    and(w4,nC,nD);
    and(w5,A,B,D);
    or(w6,w4,w5);
    or(F,w6,nw3);
    
    endmodule