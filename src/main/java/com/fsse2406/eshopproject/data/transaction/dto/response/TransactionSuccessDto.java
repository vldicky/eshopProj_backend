package com.fsse2406.eshopproject.data.transaction.dto.response;

public class TransactionSuccessDto {
    private String result;

    public TransactionSuccessDto(){
        setResult("SUCCESS");
    }

    public String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = result;           // wanted the result type that authenicated user to see, not set to public
    }
}
