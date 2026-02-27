package com.oleksdr.dto;

import lombok.Getter;

import java.util.Arrays;

/**
 * author: user,
 * date: 27.02.2026
 */
@Getter
public enum Currency {
    USD(43),
    EUR(52),
    UAH(1),
    GBP(58),
    BAH(100),
    POINT(1);

    private final int point;

    Currency(int point) {
        this.point = point;
    }
}