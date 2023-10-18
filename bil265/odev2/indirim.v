`timescale 1ns / 1ps

module indirim(
    input[12:0] urun_fiyati,
    input[1:0] pazarlik,
    input[2:0] musteri_tipi,
    input[1:0] musteri_davranisi,
    input[3:0] urun_tipi,
    output[19:0] indirimli_fiyat // 19:7 Tam say?, 6:0 k?sm? Küsürat? ifade ediyor.
    );
    reg [4:0] indirim_pazarlik[3:0];
    reg [3:0] indirim_tip[4:0];
    real gecici_fiyat;
    real urun_fiyati_as_real;
    initial begin
        indirim_pazarlik[0]= 5'b00000;
        indirim_pazarlik[1]= 5'b00011;
        indirim_pazarlik[2]= 5'b01000;
        indirim_pazarlik[3]= 5'b10011;
        indirim_tip[0]= 4'b0010;
        indirim_tip[1]= 4'b1010;
        indirim_tip[2]= 4'b1111;
        indirim_tip[3]= 4'b0000;
        indirim_tip[4]= 4'b0001;
    end
    always @(urun_fiyati, pazarlik, musteri_tipi, musteri_davranisi, urun_tipi) begin
        gecici_fiyat = urun_fiyati;
        urun_fiyati_as_real= urun_fiyati;
        if(musteri_davranisi==0)begin
          gecici_fiyat = gecici_fiyat - (gecici_fiyat*(urun_tipi==0||urun_tipi==2 ? 0:(indirim_tip[musteri_tipi] > indirim_pazarlik[pazarlik] ? indirim_tip[musteri_tipi]:indirim_pazarlik[pazarlik])))/100; // urun tipi 0 veya 2 ise indirim yap?lm?yor sadece bindirim.
          gecici_fiyat = gecici_fiyat + (gecici_fiyat*4'b1010)/100;
          gecici_fiyat = gecici_fiyat > 5000 ? 5000: gecici_fiyat;
        end
        else begin
            gecici_fiyat = gecici_fiyat - (gecici_fiyat*indirim_pazarlik[pazarlik])/100; // pazarlik indirim
            gecici_fiyat = gecici_fiyat - (gecici_fiyat*indirim_tip[musteri_tipi])/100; // tip indirim
            gecici_fiyat = gecici_fiyat - (gecici_fiyat*(musteri_tipi==2 ? indirim_tip[1] : 0 ))/100; // universite ogrencisi ise genc indirimi.
            gecici_fiyat = gecici_fiyat - (gecici_fiyat*(musteri_davranisi==2 ? 3'b101 : 0 ))/100; // davranis indirim, kaba notr de islem notr.
            if(urun_tipi==0 || urun_tipi==2) begin
                gecici_fiyat = urun_fiyati; 
            end
            if(urun_tipi==5 || urun_tipi==8) begin
                gecici_fiyat = urun_fiyati_as_real *3/4 > gecici_fiyat ? urun_fiyati_as_real *3/4 : gecici_fiyat;
            end
        end
    end
    assign indirimli_fiyat[6:0]=$rtoi($floor(100*(gecici_fiyat - $floor(gecici_fiyat))));
    assign indirimli_fiyat[19:7]=$rtoi($floor(gecici_fiyat));
endmodule
