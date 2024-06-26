package com.empvendor.demo.controller;


        import com.empvendor.demo.entity.EmailLog;
        import com.empvendor.demo.service.EmailService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public void sendEmailToVendors(@RequestBody List<String> vendorEmails) {
        emailService.sendEmailToVendors(vendorEmails);
    }

    @GetMapping
    public List<EmailLog> getAllEmailLogs() {
        return emailService.getAllEmailLogs();
    }
}
