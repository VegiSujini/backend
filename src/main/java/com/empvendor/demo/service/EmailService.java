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

    @Autowired
    private VendorService vendorService;

    public void sendEmailToVendors(List<String> vendorEmails) {
        for (String email : vendorEmails) {
            Vendor vendor = vendorService.getAllVendors().stream().filter(v -> v.getEmail().equals(email)).findFirst().orElse(null);
            if (vendor != null) {
                String message = "Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
                System.out.println("Mock Email Sent: " + message);
                EmailLog emailLog = new EmailLog();
                emailLog.setEmail(vendor.getEmail());
                emailLog.setMessage(message);
                emailLogRepository.save(emailLog);
            }
        }
    }

    public List<EmailLog> getAllEmailLogs() {
        return emailLogRepository.findAll();
    }
}

