package com.karthikRepository.BookAttributes.Entity.Enums;

public enum BookType {
    PHYSICAL(1), SOFTCOPY(2);
    private final int VALUE;

    BookType(int value){
        this.VALUE=value;
    }
    public int getValue(){
        return this.VALUE;
    }
}
