package com.empvendor.demo.controller;

import com.empvendor.demo.entity.EmailLog;
import com.empvendor.demo.entity.Vendor;
import com.empvendor.demo.service.EmailService;
import com.empvendor.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private VendorService vendorService;
    @GetMapping
    public List<EmailLog> getAllEmailLogs() {
        return emailService.getAllEmailLogs();
    }

    @PostMapping("/send")
    public void sendEmails(@RequestBody List<String> vendorEmails) {
        List<Vendor> vendors = vendorService.getAllVendors().stream().collect(Collectors.toList());
        emailService.sendEmails(vendorEmails, vendors);
    }
}
