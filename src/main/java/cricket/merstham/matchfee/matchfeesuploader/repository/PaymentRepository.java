package cricket.merstham.matchfee.matchfeesuploader.repository;

import cricket.merstham.matchfee.matchfeesuploader.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {}
