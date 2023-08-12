package com.example.demo.service.impl;

import com.example.demo.dto.KhachHangCustom;
import com.example.demo.dto.KhachHangVali;
import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl  implements KhachHangService{

    @Autowired
    private KhachHangRepository repository;

    @Override
    public List<KhachHang> getAll() {
        return repository.findAll();
    }

    @Override
    public KhachHang add(KhachHangVali khachHang) {
        KhachHang kh = khachHang.dto(new KhachHang());
        return repository.save(kh);
    }

    @Override
    public KhachHang update(KhachHangVali khachHang, Long id) {
        Optional<KhachHang> optional = repository.findById(id);
        return optional.map(o -> {
            o.setTen(khachHang.getTen());
            o.setSdt(khachHang.getSdt());
            o.setGioiTinh(Boolean.valueOf(khachHang.getGioiTinh()));
            o.setHangKhachHang(HangKhachHang.builder().ma(Integer.valueOf(khachHang.getMaHang())).build());
            return repository.save(o);
        }).get();
    }

    @Override
    public Boolean delete(Long id) {
       Optional<KhachHang> optional = repository.findById(id);
       if(optional.isPresent()){
           KhachHang kh = optional.get();
           repository.delete(kh);
           return true;
       }else{
           return false;
       }
    }

//    @Override
//    public KhachHang delete(Long id) {
//        Optional<KhachHang> optional = repository.findById(id);
//       return optional.map(o -> {
//           repository.delete(o);
//           return o;
//       }).get();
//    }

    @Override
    public Page<KhachHang> page(Integer number, Integer size) {
        Pageable pageable = PageRequest.of(number, size);
        return repository.findAll(pageable);
    }
}
