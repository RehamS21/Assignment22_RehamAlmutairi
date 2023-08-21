package com.example.schoolsystem_assignment21.Service;

import com.example.schoolsystem_assignment21.Api.ApiException;
import com.example.schoolsystem_assignment21.DTO.AddressDTO;
import com.example.schoolsystem_assignment21.Model.Address;
import com.example.schoolsystem_assignment21.Model.Teacher;
import com.example.schoolsystem_assignment21.Repository.AddressRepository;
import com.example.schoolsystem_assignment21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAdress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null)
            throw new ApiException("Sorry teacher not found");

        Address address = new Address(null, addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null)
            throw new ApiException("Sorry teacher not found");

        Address address = new Address(addressDTO.getTeacher_id(),addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        Address address = addressRepository.findAddressById(id);

        if (teacher == null || address == null)
            throw new ApiException("Sorry, the id is wrong");

        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }



}
