package cricket.merstham.matchfee.matchfeesuploader.controller;

import cricket.merstham.matchfee.matchfeesuploader.repository.PaymentRepository;
import cricket.merstham.matchfee.matchfeesuploader.services.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Controller
public class UploadController {

    private final UploadService uploadService;
    private final PaymentRepository paymentRepository;

    public UploadController(UploadService uploadService, PaymentRepository paymentRepository) {
        this.uploadService = uploadService;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping(value = "/", name = "home")
    public ModelAndView home() {
        var items = paymentRepository.findAll();
        return new ModelAndView("home/index", Map.of(
                "items", paymentRepository.findAll(),
                "total", items
                        .stream()
                        .map(payment -> payment.getPrice())
                        .reduce(BigDecimal::add)
                        .get()
        ));
    }

    @GetMapping(value = "/upload", name = "upload")
    public String upload() {
        return "upload/index";
    }

    @PostMapping(value = "/upload-file", name = "upload-file")
    public String fileUpload(@RequestParam("upload") MultipartFile file) throws IOException {
        var data = uploadService.uploadFile(file.getInputStream());
        paymentRepository.saveAll(data);

        return "redirect:/";
    }
}
