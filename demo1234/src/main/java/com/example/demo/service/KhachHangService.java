package com.example.demo.service;

import com.example.demo.dto.KhachHangCustom;
import com.example.demo.dto.KhachHangVali;
import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang add(KhachHangVali khachHang);

    KhachHang update(KhachHangVali khachHang, Long id);

    Boolean delete(Long id);

    Page<KhachHang> page(Integer number, Integer size);
}
