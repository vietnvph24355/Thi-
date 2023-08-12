package com.example.demo.dto;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KhachHangVali {

    @NotBlank(message = "Ten Khong duoc De trong ")
    private String ten;

    @NotBlank(message = "sdt Khong duoc De trong ")
    private String sdt;

    @NotBlank(message = "gioi tinh Khong duoc De trong ")
    private String gioiTinh;

    @NotBlank(message = "ma hang Khong duoc De trong ")
    private String maHang;

    public KhachHang dto(KhachHang khachHang){
        khachHang.setTen(this.getTen());
        khachHang.setSdt(this.getSdt());
        khachHang.setGioiTinh( Boolean.valueOf(this.getGioiTinh()));
        khachHang.setHangKhachHang(HangKhachHang.builder().ma(Integer.valueOf(this.getMaHang())).build());
        return khachHang;
    }

}
