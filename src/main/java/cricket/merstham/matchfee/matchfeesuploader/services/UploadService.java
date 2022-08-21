package cricket.merstham.matchfee.matchfeesuploader.services;

import com.opencsv.bean.CsvToBeanBuilder;
import cricket.merstham.matchfee.matchfeesuploader.model.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class UploadService {

    private static final Logger LOG = LogManager.getLogger(UploadService.class);

    public List<Payment> uploadFile(InputStream inputStream) {
        List<Payment> payments = new CsvToBeanBuilder(new InputStreamReader(inputStream))
                .withType(Payment.class)
                .build().parse();

        for (int i = 0; i < payments.size(); i++) {
            var payment = payments.get(i);
            if (isNull(payment.getCreated())) {
                payment.setCreated(payments.get(i-1).getCreated());
            }
            if (isNull(payment.getOrderNumber())
                    || payment.getOrderNumber().isBlank()) {
                payment.setOrderNumber(payments.get(i-1).getOrderNumber());
                payment.setLineNumber(payments.get(i-1).getLineNumber() + 1);
            }
            LOG.info("Order = {}, Line = {}, Product = {}, Price = {}",
                    payment.getOrderNumber(),
                    payment.getLineNumber(),
                    payment.getProduct(),
                    payment.getPrice().setScale(2).doubleValue());
        }
        return payments;
    }
}
