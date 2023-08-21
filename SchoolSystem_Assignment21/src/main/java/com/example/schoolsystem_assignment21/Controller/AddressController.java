package com.example.schoolsystem_assignment21.Controller;

import com.example.schoolsystem_assignment21.Api.ApiResponse;
import com.example.schoolsystem_assignment21.DTO.AddressDTO;
import com.example.schoolsystem_assignment21.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddressInfo(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addNewAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAdress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("new address added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddressInfo( @RequestBody @Valid AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address info updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddresses(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("The address deleted successfully"));
    }
}
