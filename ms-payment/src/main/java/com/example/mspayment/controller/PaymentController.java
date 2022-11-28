package com.example.mspayment.controller;
import com.example.mspayment.model.request.PaymentCriteria;
import com.example.mspayment.model.request.PaymentRequest;
import com.example.mspayment.model.response.PageablePaymentResponse;
import com.example.mspayment.model.response.PaymentResponse;
import com.example.mspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePayment(@Valid @RequestBody PaymentRequest request) {
        paymentService.savePayment(request);
    }

    @GetMapping
    public PageablePaymentResponse getAllPayments(@RequestParam int page,
                                                  @RequestParam int count,
                                                  PaymentCriteria paymentCriteria) {
        System.out.println(paymentService.getAllPayments(page, count, paymentCriteria));
        return paymentService.getAllPayments(page, count, paymentCriteria);

    }

    @GetMapping("/{id}")
    public PaymentResponse getPayment(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/edit/{id}")
    public void updatePayment(@Valid@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {
        paymentService.updatePayment(id, paymentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
    }
}
