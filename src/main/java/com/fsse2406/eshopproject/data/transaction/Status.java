package com.fsse2406.eshopproject.data.transaction;

public enum Status {

    Preparing("PREPARE"),
    Processing("PROCESS"),
    Finish("SUCCESS");

    private String result;

    Status(String result){
        this.result = result;
    }
    public String getResult(){
        return result;
    }

    @Override
    public String toString(){
        return "status: " + result;
    }

}
