package com.example.mspayment.repository;
import com.example.mspayment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
