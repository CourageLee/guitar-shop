package com.lee.userservice.service.imp;

import com.lee.userservice.entity.Address;
import com.lee.userservice.mapper.AddressMapper;
import com.lee.userservice.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/3/26 21:55
 */
@Service
public class AddressServiceImpl implements AddressService{
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> listAddressByUserId(Long userId) {
        return addressMapper.listAddressByUserId(userId);
    }

    @Override
    public void insertAddress(Address address) {
        addressMapper.insertAddress(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }

    @Override
    public void deleteAddressByAddressId(Long addressId) {
        addressMapper.deleteAddressByAddressId(addressId);
    }
}
