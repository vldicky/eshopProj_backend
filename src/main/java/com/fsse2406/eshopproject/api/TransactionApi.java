package com.fsse2406.eshopproject.api;

import com.fsse2406.eshopproject.data.transaction.data.response.TransactionResponseData;
import com.fsse2406.eshopproject.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2406.eshopproject.data.transaction.dto.response.TransactionSuccessDto;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.repository.TransactionRepository;
import com.fsse2406.eshopproject.service.TransactionService;
import com.fsse2406.eshopproject.util.JwtUtil;
import jakarta.validation.constraints.Positive;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionApi {
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionApi(TransactionService transactionService, TransactionRepository transactionRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/prepare")
    public TransactionResponseDto createprepareTransaction(JwtAuthenticationToken jwt){

        return new TransactionResponseDto(transactionService.createprepareTransaction(
                JwtUtil.getFirebaseUserData(jwt))
        );
    }

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransactById(JwtAuthenticationToken jwt,
                                                  @Positive @PathVariable Integer tid){
        TransactionResponseData transactionResponseData = transactionService.getTransactById(JwtUtil.getFirebaseUserData(jwt), tid);
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(transactionResponseData);
        return transactionResponseDto;

//       Lv3
//            return new TransactionResponseDto(
//                    transactionService.getTransactById(JwtUtil.getFirebaseUserData(jwt), tid)
//            );
    }

    @PatchMapping("/{tid}/pay")
    public TransactionSuccessDto payTransaction(JwtAuthenticationToken jwt,
                                                @Positive @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        transactionService.payTransaction(firebaseUserData, tid);
        return new TransactionSuccessDto();

    }

    @PatchMapping("/{tid}/finish")
    public TransactionResponseDto finishTransaction(JwtAuthenticationToken jwt,
                                                    @Positive @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        TransactionResponseData transactionResponseData = transactionService.finishTransaction(firebaseUserData,tid);
        return new TransactionResponseDto(transactionResponseData);
    }
}
