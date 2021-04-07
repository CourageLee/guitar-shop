package com.lee.userservice.mapper;

import com.lee.userservice.entity.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/3/26 22:12
 */
public interface AddressMapper {
    /**
     * 根据用户ID查询所有收货地址
     * @param userId 用户ID
     * @return 所有收货地址
     */
    @Select("SELECT *FROM ADDRESS WHERE USER_ID = #{userId}")
    List<Address> listAddressByUserId(Long userId);

    /**
     * 添加收货地址
     * @param address 收货地址
     */
    @Insert("INSERT INTO ADDRESS VALUES (#{id}, #{userId}, #{provinceId}, #{cityId}, #{boroughId}, #{streetId}, #{fullAddress}, #{consignee}, #{phone}, #{defaultAddr})")
    void insertAddress(Address address);

    /**
     * 修改收货地址信息,不能修改ID,USER_ID
     * @param address 修改后收货地址
     */
    @Update("UPDATE ADDRESS SET PROVINCE_ID = #{provinceId}, CITY_ID = #{cityId}, BOROUGH_ID = #{boroughId}, STREET_ID = #{streetId}, FULL_ADDRESS = #{fullAddress}, DEFAULT_ADDR = #{defaultAddr} WHERE ID = #{id}")
    void updateAddress(Address address);

    /**
     * 根据收货地址ID删除收货地址
     * @param addressId 收货地址ID
     */
    @Delete("DELETE FROM ADDRESS WHERE ID = #{addressId}")
    void deleteAddressByAddressId(Long addressId);
}
