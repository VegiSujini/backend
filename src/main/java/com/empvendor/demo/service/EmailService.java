package com.empvendor.demo.service;

import com.empvendor.demo.entity.EmailLog;
import com.empvendor.demo.entity.Vendor;
import com.empvendor.demo.repository.EmailLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailLogRepository emailLogRepository;

    public List<EmailLog> getAllEmailLogs() {
        return emailLogRepository.findAll();
    }

    public void sendEmails(List<String> vendorEmails, List<Vendor> vendors) {
        for (String email : vendorEmails) {
            Vendor vendor = vendors.stream().filter(v -> v.getEmail().equals(email)).findFirst().orElse(null);
            if (vendor != null) {
                String message = "Sending payments to vendor " + vendor.getName() + " at UPI " + vendor.getUpi();
                mockSendEmail(vendor.getEmail(), message);
                EmailLog log = new EmailLog();
                log.setMessage(message);
                emailLogRepository.save(log);
            }
        }
    }

    private void mockSendEmail(String to, String message) {
        System.out.println("Mock Email Sent To: " + to);
        System.out.println("Message: " + message);
    }
}