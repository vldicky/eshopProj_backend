package com.fsse2406.eshopproject.data.transaction.data.request;

import jakarta.transaction.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestData {
    private Integer tid;
    private Integer uid;
    private LocalDateTime transactDate;
    private Status status;
    private BigDecimal total;

    enum Status{Preparing, Processing, Finish}


}
