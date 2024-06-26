package com.empvendor.demo.service;

import com.empvendor.demo.entity.Vendor;
import com.empvendor.demo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public Vendor saveVendor(Vendor vendor) {
        Optional<Vendor> existingVendor = vendorRepository.findByEmail(vendor.getEmail());
        if (existingVendor.isPresent()) {
            throw new IllegalArgumentException("Vendor with this email already exists");
        }
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}


