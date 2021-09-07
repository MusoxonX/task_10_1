package uz.pdp.task_10_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task_10_1.entity.Hotel;
import uz.pdp.task_10_1.repository.HotelRepository;

import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @PostMapping()
    public String addHotel(@RequestBody Hotel hotelDto){
        Optional<Hotel> optionalHotel = hotelRepository.findByName(hotelDto.getName());
        if (optionalHotel.isPresent()){
            return "like this hotel exists";
        }
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotelRepository.save(hotel);
        return "hotel added";
    }
}
