package com.karthikRepository.BookAttributes.Entity.Enums;

public enum Bind {
    SOFTBIND(1)
    ,HARDBIND(2);
    private final int VALUE;
    Bind(int value) {
        this.VALUE=value;
    }
    public int getVALUE(){
        return VALUE;
    }
}
