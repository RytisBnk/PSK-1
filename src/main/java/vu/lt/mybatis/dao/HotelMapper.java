package vu.lt.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Hotel;

@Mapper
public interface HotelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.HOTEL
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.HOTEL
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    int insert(Hotel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.HOTEL
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    Hotel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.HOTEL
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    List<Hotel> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.HOTEL
     *
     * @mbg.generated Sun Mar 31 17:17:07 EEST 2019
     */
    int updateByPrimaryKey(Hotel record);
}