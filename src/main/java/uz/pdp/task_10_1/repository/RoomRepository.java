package uz.pdp.task_10_1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task_10_1.entity.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    Page<Room> findAllByHotelId(Integer hotel_id, Pageable pageable);
}
