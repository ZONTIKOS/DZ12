class BankAccount {
    private String accountNumber;
    private double balance;
    private boolean ban;
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public boolean deposit(double amount) {
        if(isBan()){
            System.out.println("Аккаунт заблоковано!!!!.");
            return false;
        }
        if (amount <= (double)0.0F) {
            System.out.println("Сума має бути більше нуля.");
            return false;
        } else {
            this.balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount) {
        if(isBan()){
            System.out.println("Аккаунт заблоковано!!!!.");
            return false;
        }
        if (amount <= (double)0.0F) {
            System.out.println("Сума має бути більше нуля.");
            return false;
        } else if (amount > this.balance) {
            System.out.println("Недостатньо коштів.");
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }
}
