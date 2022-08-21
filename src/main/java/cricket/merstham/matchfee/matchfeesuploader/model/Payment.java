package cricket.merstham.matchfee.matchfeesuploader.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import cricket.merstham.matchfee.matchfeesuploader.converters.InstantConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @CsvCustomBindByName(column = "Created", converter = InstantConverter.class)
    @Column(name = "created", nullable = false)
    private Instant created;

    @CsvBindByName(column = "Order Number")
    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @CsvBindByName(column = "Customer Name")
    @Transient
    private String customerName;

    @CsvBindByName(column = "Customer Email")
    @Transient
    private String customerEmail;

    @CsvBindByName(column = "Category")
    @Column(name = "category", nullable = true)
    private String category;

    @CsvBindByName(column = "Product")
    @Column(name = "product", nullable = false)
    private String product;

    @CsvBindByName(column = "Price £")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @CsvBindByName(column = "Type")
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "line_number", nullable = false)
    private int lineNumber = 1;

    @Column(name = "matched_artefact", nullable = true)
    private String matchedArtefact;

    @Column(name = "sage_id", nullable = true)
    private String sageId;
}
