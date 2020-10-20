package bank.account;

import bank.money.Money;

public class Account {
    private Money money;
    private String owner;

    public Account(){}

    public Account(String ownerName){
        this.owner = ownerName;
    }

    public Account(Long money) {
        this.money = new Money(money);
    }

    public Long checkDeposit() {
        return money.amount();
    }

    public void depositMoney(Long money){
        this.money.plusMoney(money);
    }

    public void withdrawalMoney(Long money){
        this.money.minusMoney(money);
    }
}
