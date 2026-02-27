package com.oleksdr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

/**
 * author: user,
 * date: 27.02.2026
 */
@ToString
public class Balance {
    @Getter
    private BigInteger moneyAmount;
    @Getter
    @Setter
    private Currency currency;

    public Balance(BigInteger amount, Currency currency) {
        this.moneyAmount = amount;
        this.currency = currency;
    }
    public void subtractMoney(BigInteger amount){
        moneyAmount = moneyAmount.subtract(amount);
    }
    public void addMoney(BigInteger amount){
        moneyAmount = moneyAmount.add(amount);
    }
}
