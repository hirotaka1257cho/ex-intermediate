package com.example.ex_intermediate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex_intermediate.Repository.HotelRepository;
import com.example.ex_intermediate.domain.Hotel;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repository;

    /**
     * 金額ごとに分岐するメソッド
     * @param price 金額
     * @return 結果を返す
     */
    public List<Hotel> searchByPrice(Integer price){
        if(price == null){
            return repository.findAll();
        }
        return repository.findByPriceLessThanEqual(price);
    }

    public List<Hotel> findAll() { 
        return repository.findAll(); 
    }
}
