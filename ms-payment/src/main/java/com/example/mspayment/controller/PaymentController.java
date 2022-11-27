package com.example.mspayment.controller;

import com.example.mspayment.model.request.PaymentRequest;
import com.example.mspayment.model.response.PaymentResponse;
import com.example.mspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePayment(@RequestBody PaymentRequest request) {
        paymentService.savePayment(request);
    }

    @GetMapping
    public List<PaymentResponse> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentResponse getPayment(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/edit/{id}")
    public void updatePayment(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {
        paymentService.updatePayment(id, paymentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
    }
}
