`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 08/15/2023 03:11:27 AM
// Design Name: 
// Module Name: vivado_stations_imp
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module vivado_stations_imp(
    input clk,
    input ilk_yon,
    input [5:0] switchler_input,
    output reg [5:0] ledler_out,
    output reg [3:0] an,
    output reg [6:0] seg
    );
    reg [31:0] sayac;
    reg [31:0] sayac1=10**8/2*24;
    reg yavas_clk;
    reg yon;
    reg [2:0] current_station;
    reg [2:0] istasyon_sayac=1;
    reg [2:0] istasyon_sayac2=0;
    reg [2:0] istasyon_sayac3=5;
    integer a=1;
    integer x=0;
    integer y=0;
    integer i=0;
    

    localparam RIGHT = 0;
    localparam LEFT = 1;
    
    reg yavas_clk1=0;
    reg[1:0] c=0;
    integer len[5:0];
    reg[80:0] istasyon[5:0];
    reg[6:0] sevenform[3:0];
    reg[7:0] displays[3:0];
    integer konum;
    integer L=0;
    integer u=1000000;
    integer v=0;
    initial begin
        istasyon[0]="ANABINA";
        istasyon[1]="BAHCE";
        istasyon[2]="SPORSALONU";
        istasyon[3]="GARAJ";
        istasyon[4]="YDB";
        istasyon[5]="TN";
        len[0]=7;
        len[1]=5;
        len[2]=10;
        len[3]=5;
        len[4]=3;
        len[5]=2;
        
    end    
     
    always @(posedge yavas_clk1)
        begin
            if(a == 1)
                begin
                    a = 0;
                    ledler_out = 0;
                     for (i = 0; i < 6; i = i+1) 
                        begin
                            if (switchler_input[i] == 1)
                                begin
                                    current_station = i;                               
                                end
                        end     
                        ledler_out[current_station] = 1;
                        if(current_station==0 || current_station == 5) y=1;
                end 
                
            else
                begin
                if(ilk_yon == RIGHT)
                    begin
                        if(x==0) begin x=1; yon= RIGHT; end
                        if((ledler_out==6'b100000 || ledler_out==6'b000001) && y!=1)
                            begin
                                yon=~yon;
                            end
                            y=0;
                        if(yon==RIGHT)
                            begin
                                ledler_out=ledler_out<<1;
                            end
                        if(yon==LEFT)
                            begin
                                ledler_out=ledler_out>>1;
                            end
                    end   
                if(ilk_yon == LEFT)
                    begin
                        if(x==0) begin x=1; yon= LEFT; end
                        if((ledler_out==6'b100000 || ledler_out==6'b000001) && y!=1)
                            begin
                                yon=~yon;
                            end
                            y=0;
                        if(yon==RIGHT)
                            begin
                                ledler_out=ledler_out<<1;
                            end
                        if(yon==LEFT)
                            begin
                                ledler_out=ledler_out>>1;
                            end
                    end   
                end
    end
        
        always@(posedge yavas_clk) begin
            case(yon)
                1'b0: begin
                    for(L=0;L<6;L = L + 1) begin
                       if(ledler_out[L]==1)begin
                            konum=L;
                       end
                   end
                 end
                 
                1'b1: begin
                   for(L=5;L>=0;L = L - 1) begin
                       if(ledler_out[L]==1)begin
                            konum=L;
                       end
                   end
                end
            endcase
            
            v =((len[konum]-(u%len[konum]))*8);
            case(v)
                8: displays[3]=istasyon[konum][7:0];
                16: displays[3]=istasyon[konum][15:8];
                24: displays[3]=istasyon[konum][23:16];
                32: displays[3]=istasyon[konum][31:24];
                40: displays[3]=istasyon[konum][39:32];
                48: displays[3]=istasyon[konum][47:40];
                56: displays[3]=istasyon[konum][55:48];
                64: displays[3]=istasyon[konum][63:56];
                72: displays[3]=istasyon[konum][73:64];
                80: displays[3]=istasyon[konum][79:72];
            endcase
            v=((len[konum]-((u+1)%len[konum]))*8);
            case(v)
                8: displays[2]=istasyon[konum][7:0];
                16: displays[2]=istasyon[konum][15:8];
                24: displays[2]=istasyon[konum][23:16];
                32: displays[2]=istasyon[konum][31:24];
                40: displays[2]=istasyon[konum][39:32];
                48: displays[2]=istasyon[konum][47:40];
                56: displays[2]=istasyon[konum][55:48];
                64: displays[2]=istasyon[konum][63:56];
                72: displays[2]=istasyon[konum][73:64];
                80: displays[2]=istasyon[konum][79:72];
            endcase
            v=((len[konum]-((u+2)%len[konum]))*8);
            case(v)
                8: displays[1]=istasyon[konum][7:0];
                16: displays[1]=istasyon[konum][15:8];
                24: displays[1]=istasyon[konum][23:16];
                32: displays[1]=istasyon[konum][31:24];
                40: displays[1]=istasyon[konum][39:32];
                48: displays[1]=istasyon[konum][47:40];
                56: displays[1]=istasyon[konum][55:48];
                64: displays[1]=istasyon[konum][63:56];
                72: displays[1]=istasyon[konum][73:64];
                80: displays[1]=istasyon[konum][79:72];
            endcase
            v=((len[konum]-((u+3)%len[konum]))*8);
            case(v)
                8: displays[0]=istasyon[konum][7:0];
                16: displays[0]=istasyon[konum][15:8];
                24: displays[0]=istasyon[konum][23:16];
                32: displays[0]=istasyon[konum][31:24];
                40: displays[0]=istasyon[konum][39:32];
                48: displays[0]=istasyon[konum][47:40];
                56: displays[0]=istasyon[konum][55:48];
                64: displays[0]=istasyon[konum][63:56];
                72: displays[0]=istasyon[konum][73:64];
                80: displays[0]=istasyon[konum][79:72];
            endcase
             u = u - 1;
             
             case(displays[3])
                "A": sevenform[3]=7'h77;
                "B": sevenform[3]=7'h1F;
                "C": sevenform[3]=7'h4E;
                "D": sevenform[3]=7'h3D;
                "E": sevenform[3]=7'h4F;
                "G": sevenform[3]=7'h5E;
                "H": sevenform[3]=7'h37;
                "I": sevenform[3]=7'h06;
                "N": sevenform[3]=7'h76;
                "O": sevenform[3]=7'h7E;
                "L": sevenform[3]=7'h0E;
                "U": sevenform[3]=7'h3E;
                "S": sevenform[3]=7'h5B;
                "J": sevenform[3]=7'h3C;
                "R": sevenform[3]=7'h46;
                "T": sevenform[3]=7'h0F;
                "Y": sevenform[3]=7'h3B;
                "P": sevenform[3]=7'h67;
             endcase
             case(displays[2])
                "A": sevenform[2]=7'h77;
                "B": sevenform[2]=7'h1F;
                "C": sevenform[2]=7'h4E;
                "D": sevenform[2]=7'h3D;
                "E": sevenform[2]=7'h4F;
                "G": sevenform[2]=7'h5E;
                "H": sevenform[2]=7'h37;
                "I": sevenform[2]=7'h06;
                "N": sevenform[2]=7'h76;
                "O": sevenform[2]=7'h7E;
                "L": sevenform[2]=7'h0E;
                "U": sevenform[2]=7'h3E;
                "S": sevenform[2]=7'h5B;
                "J": sevenform[2]=7'h3C;
                "R": sevenform[2]=7'h46;
                "T": sevenform[2]=7'h0F;
                "Y": sevenform[2]=7'h3B;
                "P": sevenform[2]=7'h67;
             endcase
             case(displays[1])
                "A": sevenform[1]=7'h77;
                "B": sevenform[1]=7'h1F;
                "C": sevenform[1]=7'h4E;
                "D": sevenform[1]=7'h3D;
                "E": sevenform[1]=7'h4F;
                "G": sevenform[1]=7'h5E;
                "H": sevenform[1]=7'h37;
                "I": sevenform[1]=7'h06;
                "N": sevenform[1]=7'h76;
                "O": sevenform[1]=7'h7E;
                "L": sevenform[1]=7'h0E;
                "U": sevenform[1]=7'h3E;
                "S": sevenform[1]=7'h5B;
                "J": sevenform[1]=7'h3C;
                "R": sevenform[1]=7'h46;
                "T": sevenform[1]=7'h0F;
                "Y": sevenform[1]=7'h3B;
                "P": sevenform[1]=7'h67;
             endcase
             case(displays[0])
                "A": sevenform[0]=7'h77;
                "B": sevenform[0]=7'h1F;
                "C": sevenform[0]=7'h4E;
                "D": sevenform[0]=7'h3D;
                "E": sevenform[0]=7'h4F;
                "G": sevenform[0]=7'h5E;
                "H": sevenform[0]=7'h37;
                "I": sevenform[0]=7'h06;
                "N": sevenform[0]=7'h76;
                "O": sevenform[0]=7'h7E;
                "L": sevenform[0]=7'h0E;
                "U": sevenform[0]=7'h3E;
                "S": sevenform[0]=7'h5B;
                "J": sevenform[0]=7'h3C;
                "R": sevenform[0]=7'h46;
                "T": sevenform[0]=7'h0F;
                "Y": sevenform[0]=7'h3B;
                "P": sevenform[0]=7'h67; 
             endcase
        end
        
        
    always@(*) begin
        case(c)
            2'b00 : begin an[3:0]=4'b1110; end
            2'b01 : begin an[3:0]=4'b1101; end
            2'b10 : begin an[3:0]=4'b1011; end
            2'b11 : begin an[3:0]=4'b0111; end
        endcase
        case(an[3:0])          
           4'b1110:begin seg[6:0]=~sevenform[0];end
           4'b1101:begin seg[6:0]=~sevenform[1];end
           4'b1011:begin seg[6:0]=~sevenform[2];end
           4'b0111:begin seg[6:0]=~sevenform[3];end
        endcase
    end
    
  always @(posedge clk) //yavas clock1
    begin
        if(sayac1==10**8/2*24) begin
        sayac1=0;
        yavas_clk1=~yavas_clk1;
        end
        sayac1=sayac1+1;
    end
  
  always @(posedge clk) //yavas clock
    begin
        c=sayac/100000; 
        if(sayac==10**8/2) begin
        sayac=0;
        yavas_clk=~yavas_clk;
        end
        sayac=sayac+1;
    end

endmodule