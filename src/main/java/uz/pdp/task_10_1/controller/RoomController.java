package uz.pdp.task_10_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_10_1.entity.Hotel;
import uz.pdp.task_10_1.entity.Room;
import uz.pdp.task_10_1.payload.RoomDto;
import uz.pdp.task_10_1.repository.HotelRepository;
import uz.pdp.task_10_1.repository.RoomRepository;

import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @PostMapping()
    public String addRoom(@RequestBody RoomDto roomDto){
        Room room = new Room();
        room.setNumber(roomDto.getNumber());
        room.setFloor(roomDto.getFloor());
        room.setSize(roomDto.getSize());
        Optional<Hotel> optionalHotel = hotelRepository.findById(roomDto.getHotelId());
        if (!optionalHotel.isPresent()){
            return "hotel not found";
        }
        room.setHotel(optionalHotel.get());
        roomRepository.save(room);
        return "room saved";
    }


    @GetMapping("/hotelId/{hotelId}")
    public Page<Room> getRooms(@PathVariable Integer hotelId,@RequestParam int page){
            Pageable pageable =PageRequest.of(page,10);
            Page<Room> roomPage = roomRepository.findAllByHotelId(hotelId, pageable);
            return roomPage;
    }
}
