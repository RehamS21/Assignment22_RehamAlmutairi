package com.example.schoolsystem_assignment21.Repository;

import com.example.schoolsystem_assignment21.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.imageio.ImageTranscoder;

public interface AddressRepository extends JpaRepository<Address , Integer> {

    Address findAddressById(Integer id);
    void deleteAddressesById(Integer id);
}
