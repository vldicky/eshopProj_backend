package com.fsse2406.eshopproject.data.cartitem.dto.response;

public class SuccessResponseDto {
    private String result;


    public String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = "SUCCESS";           // wanted the result type that authenicated user to see, not set to public
    }
}
