package com.example.demo.repository;

import com.example.demo.dto.KhachHangCustom;
import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    @Query(value = "select kh.MaKhachHang, kh.TenKhachHang, kh.SoDienThoai, kh.GioiTinh, hkh.MaHang, hkh.TenHang \n " +
            " from KhachHang kh \n " +
            " join HangKhachHang hkh \n " +
            " on kh.HangKhachHang = hkh.maHang " ,nativeQuery = true)
    List<KhachHangCustom> getAllKhachHang();
}
