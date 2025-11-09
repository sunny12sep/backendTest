package business.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class PaymentDTO {
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;

    public PaymentDTO(String checkNumber, Date paymentDate, BigDecimal amount) {
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}