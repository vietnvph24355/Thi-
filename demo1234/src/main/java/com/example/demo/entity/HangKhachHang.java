package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HangKhachHang")
@Entity
public class HangKhachHang {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MaHang")
    private Integer ma;

    @Column(name = "TenHang")
    private String ten;

}
