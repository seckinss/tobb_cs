`timescale 1ns / 1ps

module kilit_acici (
    input [2:0] sag_adim,
    input [1:0] sol_adim,
    input [5:0] kilit_sifre,
    output kilit_acik
);
    wire [3:0] tumleyen_sol_adim;
    wire [3:0] sag_adm,sum1, sum2, sum3;
    wire [4:0] sum3x4, sum3x1;
    wire [5:0] sonuc;
    wire Cout;
    buf(sag_adm[0],sag_adim[0]);
    buf(sag_adm[1],sag_adim[1]);
    buf(sag_adm[2],sag_adim[2]);
    buf(sag_adm[3],1'b0);

    fullAdder4Bit FAF1(.A(sag_adm), .B(4'd8), .Cin(1'b0), .Sum(sum1));

    tumleyen t1(.A(sol_adim), .B(tumleyen_sol_adim));
    fullAdder4Bit FAF2(.A(sum1), .B(tumleyen_sol_adim), .Cin(1'b0), .Sum(sum2));
    fullAdder4Bit FAF3(.A(sum2), .B(tumleyen_sol_adim), .Cin(1'b0), .Sum(sum3));


    buf b1(sum3[3],1'b0);
    buf(sum3x1[3],1'b0);
    buf(sum3x1[4],1'b0);
    buf(sum3x4[0],1'b0);
    buf(sum3x4[1],1'b0);
    buf b2(sum3x1[0],sum3[0]);
    buf b3(sum3x1[1],sum3[1]);
    buf b4(sum3x1[2],sum3[2]);
    buf b5(sum3x4[2],sum3[0]);
    buf b6(sum3x4[3],sum3[1]);
    buf b7(sum3x4[4],sum3[2]);

    fullAdder5Bit FAF5(.A(sum3x1), .B(sum3x4), .Cin(1'b0), .Sum(sonuc[4:0]), .Cout(Cout));
    buf b8(sonuc[5], Cout);
    alti_bit_karsilastirici c1(.A(sonuc), .B(kilit_sifre), .AeB(kilit_acik));

endmodule


module fullAdder4Bit(
    input [3:0] A,
    input [3:0] B,
    input Cin,
    output [3:0] Sum,
    output Cout
);

    wire [3:0] C;

    fullAdder FA0(.A(A[0]), .B(B[0]), .Cin(Cin), .Sum(Sum[0]), .Cout(C[0]));
    fullAdder FA1(.A(A[1]), .B(B[1]), .Cin(C[0]), .Sum(Sum[1]), .Cout(C[1]));
    fullAdder FA2(.A(A[2]), .B(B[2]), .Cin(C[1]), .Sum(Sum[2]), .Cout(C[2]));
    fullAdder FA3(.A(A[3]), .B(B[3]), .Cin(C[2]), .Sum(Sum[3]), .Cout(Cout));

endmodule

module fullAdder5Bit(
    input [4:0] A,
    input [4:0] B,
    input Cin,
    output [4:0] Sum,
    output Cout
);

    wire [4:0] C;

    fullAdder FA0(.A(A[0]), .B(B[0]), .Cin(Cin), .Sum(Sum[0]), .Cout(C[0]));
    fullAdder FA1(.A(A[1]), .B(B[1]), .Cin(C[0]), .Sum(Sum[1]), .Cout(C[1]));
    fullAdder FA2(.A(A[2]), .B(B[2]), .Cin(C[1]), .Sum(Sum[2]), .Cout(C[2]));
    fullAdder FA3(.A(A[3]), .B(B[3]), .Cin(C[2]), .Sum(Sum[3]), .Cout(C[3]));
    fullAdder FA4(.A(A[4]), .B(B[4]), .Cin(C[3]), .Sum(Sum[4]), .Cout(Cout));   
endmodule

module fullAdder(
    input A,
    input B,
    input Cin,
    output Sum,
    output Cout
);
    wire C1, C2, C3, AxorB;
    xor x1(AxorB, A, B);
    xor x2(Sum, AxorB, Cin);
    and a1(C1, A, Cin);
    and a2(C2, A, B);
    and a3(C3, B, Cin);
    or o1(Cout, C1, C2, C3);

endmodule


module tumleyen(
    input [1:0] A,
    output [3:0] B
);
    wire [3:0] C;
    wire Cout;
    
    not n1(C[0], A[0]);
    not n2(C[1], A[1]);
    not n3(C[2], 1'b0);
    not n4(C[3], 1'b0);

    fullAdder4Bit FA(.A(C), .B(4'b0001), .Cin(1'b0), .Sum(B), .Cout(Cout));
  
endmodule 

module alti_bit_karsilastirici(
    input[5:0] A,
    input[5:0] B,
    output AeB
);
    wire [5:0] result;
    bit_karsilastirici b0(.A(A[0]), .B(B[0]), .AeB(result[0]));
    bit_karsilastirici b1(.A(A[1]), .B(B[1]), .AeB(result[1]));
    bit_karsilastirici b2(.A(A[2]), .B(B[2]), .AeB(result[2]));
    bit_karsilastirici b3(.A(A[3]), .B(B[3]), .AeB(result[3]));
    bit_karsilastirici b4(.A(A[4]), .B(B[4]), .AeB(result[4]));
    bit_karsilastirici b5(.A(A[5]), .B(B[5]), .AeB(result[5]));


    and a1(AeB, result[0], result[1], result[2], result[3], result[4], result[5]);

endmodule
module bit_karsilastirici(
    input A,
    input B,
    output AeB
);
    wire nA, nB, AkB, AbB;

    not n1(nA,A);
    not n2(nB,B);

    and a1(AkB,nA,B);
    and a2(AbB,A,nB);
    nor nor1(AeB,AbB,AkB);

endmodule

