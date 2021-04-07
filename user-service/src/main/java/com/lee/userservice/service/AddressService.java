package com.lee.userservice.service;

import com.lee.userservice.entity.Address;

import java.util.List;

/**
 * 收货地址API
 * @author Lee
 * @version 1.0
 * @date 2021/3/26 21:55
 */
public interface AddressService {
    /**
     * 根据用户ID获取所有收货地址
     * @param userId 用户ID
     * @return 所有收货地址
     */
    List<Address> listAddressByUserId(Long userId);

    /**
     * 添加收货地址
     * @param address 收货地址
     */
    void insertAddress(Address address);

    /**
     * 修改收货地址信息
     * @param address 修改后收货地址
     */
    void updateAddress(Address address);

    /**
     * 根据收货地址ID删除收货地址
     * @param addressId 收货地址ID
     */
    void deleteAddressByAddressId(Long addressId);
}
