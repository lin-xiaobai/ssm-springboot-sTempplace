package com.com;

/**
 * @date 2021/6/25 -11:34
 */
public class AccountBean {
    private int cardId;
    private String name;
    private int balance;

    public AccountBean() {
    }

    public AccountBean(int cardId, String name, int balance) {
        this.cardId = cardId;
        this.name = name;
        this.balance = balance;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
