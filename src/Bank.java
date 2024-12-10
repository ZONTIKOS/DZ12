class Bank {
    private BankAccount[] accounts = new BankAccount[100];
    private int count = 0;

    Bank() {
    }

    public boolean createAccount(String accountNumber, double initialBalance) {
        if (this.count >= this.accounts.length) {
            System.out.println("Банк заповнений.");
            return false;
        } else {
            this.accounts[this.count++] = new BankAccount(accountNumber, initialBalance);
            return true;
        }
    }

    public BankAccount getAccount(String accountNumber) {
        for(int i = 0; i < this.count; ++i) {
            if (this.accounts[i].getAccountNumber().equals(accountNumber)) {
                return this.accounts[i];
            }
        }

        System.out.println("Рахунок не знайдено.");
        return null;
    }
    public boolean blockAccount(String accountNumber) {
        return  blockUnblockAccount(accountNumber, true);
    }
    public boolean unblockAccount(String accountNumber) {
        return blockUnblockAccount(accountNumber, false);
    }
    private boolean blockUnblockAccount(String accountNumber, boolean status) {
        for(int i = 0; i < this.count; ++i) {
            if (this.accounts[i].getAccountNumber().equals(accountNumber)) {
                this.accounts[i].setBan(status);
            }
        }
        return false;
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = this.getAccount(fromAccountNumber);
        BankAccount toAccount = this.getAccount(toAccountNumber);
        if(fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }
        return false;
    }
}
