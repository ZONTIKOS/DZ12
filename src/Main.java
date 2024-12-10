public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("Brave New World", "Aldous Huxley", 1932));

        System.out.println("Total books: " + library.countBooks());
        for (Book book : library.searchByAuthor("George Orwell")) {
            System.out.println(book);
        }
        Bank bank = new Bank();
        bank.createAccount("12345", 1000);

        BankAccount account = bank.getAccount("12345");
        if (account != null) {
            account.deposit(500);
            account.withdraw(2000); // Недостатньо коштів
            account.withdraw(300); // Успішно

            System.out.println("Баланс: " + account.getBalance());
        }
    }
}