package com.example.demo.controller;

import com.example.demo.dto.KhachHangVali;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.impl.KhachHangServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangServiceImpl service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/pageNo")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", name = "pageNo")Integer pageNo){
        return ResponseEntity.ok(service.page(pageNo, 5));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid KhachHangVali kh, BindingResult result){
       if(result.hasErrors()){
           List<ObjectError> list = result.getAllErrors();
           return ResponseEntity.ok(list);
       }else{
           return ResponseEntity.ok(service.add(kh) + " " + "Them thanh cong");
       }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(service.delete(id)){
             return ResponseEntity.ok("Xoa Thanh Cong");
        }else {
           return ResponseEntity.ok("Xoa That Bai");
        }
            //return ResponseEntity.ok(service.delete(id)+ " " + "Xoa Thanh Cong");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid  KhachHangVali kh, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list + " " + "Sua That bai");
        }else{
            return ResponseEntity.ok(service.update(kh, id) + " " + "Sua thanh cong");
        }
    }
}
