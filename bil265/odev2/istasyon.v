    `timescale 1ns / 1ps
    
    module istasyon#(parameter ARAC_SAYISI = 200)(
        input saat,
        input reset,
        input[1:0] islem,
        output reg amorti,
        output reg[4:0] amorti_gunu
        );
        integer toplam_kar = 0;
        reg [4:0] gun = 1;
        reg onceki_gun_arac_yikama=0;
        initial begin
            amorti=0;
            amorti_gunu=5'b0;
        end
        always @(posedge saat or posedge reset) begin
            if (reset) begin
                toplam_kar = 0;
                gun =1;
                onceki_gun_arac_yikama =0;
                amorti =0;
                amorti_gunu =5'b0;
            end
            else begin
                if(gun<31) begin
                    if(onceki_gun_arac_yikama)begin
                         toplam_kar = toplam_kar + ARAC_SAYISI*250;
                         
                    end
                    else begin 
                        case (islem)
                                2'b00: toplam_kar =toplam_kar +  ARAC_SAYISI * 250; 
                                2'b01: toplam_kar =toplam_kar +  ARAC_SAYISI * 0; 
                                2'b10: toplam_kar =toplam_kar +  ARAC_SAYISI * 50;  
                                2'b11: toplam_kar =toplam_kar +  ARAC_SAYISI * 30;
                        endcase 
                    end
                    onceki_gun_arac_yikama = onceki_gun_arac_yikama ? 0:islem==2 ? 1:0;
                    if(toplam_kar >=200000 && amorti==0) begin
                        amorti =1;
                        amorti_gunu = gun;
                    end
                    gun <= gun+1;
                end
            end
        end
        
endmodule
