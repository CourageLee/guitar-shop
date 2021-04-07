package com.lee.userservice.controller;

import com.lee.userservice.entity.Address;
import com.lee.userservice.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收货地址controller
 * @author Lee
 * @version 1.0
 * @date 2021/3/26 21:54
 */
public class AddressController {
    @Resource
    private AddressService addressService;

    @GetMapping("/address/{userId}")
    public List<Address> listAddressByUserId(@PathVariable("userId") Long userId) {
        return addressService.listAddressByUserId(userId);
    }

    @PostMapping("/address")
    public void insertAddress(@RequestBody Address address) {
        addressService.insertAddress(address);
    }

    @PutMapping("/address")
    public void updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
    }

    @DeleteMapping("/address/{userId}")
    public void deleteAddressByUserId(@PathVariable("userId") Long userId) {
        addressService.deleteAddressByAddressId(userId);
    }
}
