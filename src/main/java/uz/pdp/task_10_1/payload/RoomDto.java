package uz.pdp.task_10_1.payload;

import lombok.Data;

@Data
public class RoomDto {
    private Integer number;

    private Integer floor;

    private Integer size;

    private Integer hotelId;
}
