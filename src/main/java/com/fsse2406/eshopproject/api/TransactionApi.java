package com.fsse2406.eshopproject.api;

import com.fsse2406.eshopproject.data.transaction.data.response.TransactionResponseData;
import com.fsse2406.eshopproject.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.repository.TransactionRepository;
import com.fsse2406.eshopproject.service.TransactionService;
import com.fsse2406.eshopproject.util.JwtUtil;
import jakarta.validation.constraints.Positive;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionApi {
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;

    public TransactionApi(TransactionService transactionService, TransactionRepository transactionRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/prepare")
    public TransactionResponseDto createprepareTransaction(JwtAuthenticationToken jwt,
                                                           @RequestBody TransactionResponseDto transactionResponseDto){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        TransactionResponseData transactionResponseData = transactionService.createprepareTransaction(firebaseUserData);
        return new TransactionResponseDto(transactionResponseData);
    }

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransactById(JwtAuthenticationToken jwt,
                                                  @Positive @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        TransactionEntity transactionEntity = transactionService.getTransactById(firebaseUserData, tid);
        TransactionResponseData transactionResponseData = new TransactionResponseData(transactionEntity);
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(transactionResponseData);
        return transactionResponseDto;
    }

    @PatchMapping("/{tid}/pay")
    public void updateTransaction(JwtAuthenticationToken jwt,
                                  @Positive @PathVariable Integer tid){


    }
}
