package com.spring.dynamic.web.controller;

import com.spring.dynamic.web.model.Hotel;
import com.spring.dynamic.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HotelController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listHotels(ModelMap model) {
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.addAll(hotelService.findAll());
        model.addAttribute("hotels", hotels);
        return new ModelAndView("index", "command", new Hotel());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addHotel(@ModelAttribute("SpringWeb") Hotel hotel, ModelMap model) {
        hotelService.save(hotel);
        return new ModelAndView("redirect:/");
    }

}