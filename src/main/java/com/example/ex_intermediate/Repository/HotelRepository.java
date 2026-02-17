package com.example.ex_intermediate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ex_intermediate.domain.Hotel;

/**
 * 値段で取得するメソッド
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    List<Hotel> findByPriceLessThanEqual(Integer price);
}
