package com.mycompany.crossborderbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@Controller
public class CrossBorderBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrossBorderBackendApplication.class, args);
    }

    @GetMapping("/upload-demo")
    public String uploadDemo() {
        return "upload-demo";
    }

    @PostMapping("/upload-batch")
    public String uploadBatch(@RequestParam("file") MultipartFile file, Model model) throws Exception {
        int count = 0;
        double total = 0.0;
        StringBuilder details = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("recipient")) continue; // skip header
                String[] parts = line.split(",");
                if (parts.length < 5) continue;
                String name = parts[0].trim();
                String bank = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());
                String currency = parts[3].trim();
                String country = parts[4].trim();
                total += amount;
                count++;
                details.append("Payout: ").append(name).append(", ").append(bank).append(", ")
                        .append(amount).append(" ").append(currency).append(", ").append(country).append("<br>");
                System.out.println("Payout: " + name + ", " + bank + ", " + amount + " " + currency + ", " + country);
            }
        }
        String summary = "Received " + count + " payouts. Total amount: $" + total;
        model.addAttribute("summary", summary);
        model.addAttribute("details", details.toString());
        return "upload-demo";
    }
}