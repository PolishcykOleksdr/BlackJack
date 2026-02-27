package com.oleksdr.dto;

import lombok.Getter;

/**
 * author: user,
 * date: 27.02.2026
 */
@Getter
public enum GameResult {
    PLAYER("Player won"),
    COMPUTER("Computer won"),
    LOSE("Both lose"),
    DRAW("It`s draw");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }

}
