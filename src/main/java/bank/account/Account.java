package bank.account;

public class Account {
    private Long money;
    private String owner;

    public Account(){}

    public Account(Long money) {
        this.money = money;
    }

    public Long checkDeposit() {
        return money;
    }

    public void depositMoney(Long money){
        this.money += money;
    }

    public void withdrawalMoney(Long money){
        this.money -= money;
    }
}
