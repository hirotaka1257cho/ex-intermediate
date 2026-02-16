package com.example.ex_intermediate.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex_intermediate.Service.HotelService;
import com.example.ex_intermediate.domain.Hotel;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * ホテルを検索する
     * @param requestparam リクエストパラメータからpriceという名前を受け取る
     * @param model requestスコープ
     * @return スコープの中身を返す
    */
    @GetMapping("/hotels")
public String search(@RequestParam(name = "price", required = false) Integer price, Model model) {
    List<Hotel> hotels;

    if (price != null) {
        hotels = hotelService.searchByPrice(price);
    } else {
        hotels = hotelService.findAll();
    }

    model.addAttribute("hotels", hotels);
    return "hotel/hotel_list";
}
}
