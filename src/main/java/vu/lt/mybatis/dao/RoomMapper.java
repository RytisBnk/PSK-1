package vu.lt.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Room;

@Mapper
public interface RoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    int insert(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    Room selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    List<Room> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ROOM
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    int updateByPrimaryKey(Room record);
    /**
     * Select rooms for given hotel
     * Written manually
     */
    List<Room> selectRoomsForHotel(Long id);
}