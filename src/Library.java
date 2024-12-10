class Library {
    private Book[] books = new Book[100];
    private int count = 0;

    Library() {
    }

    public void addBook(Book book) {
        if (this.count < this.books.length) {
            this.books[this.count++] = book;
        } else {
            System.out.println("Library is full!");
        }

    }

    public void removeBook(String title) {
        for(int i = 0; i < this.count; ++i) {
            if (this.books[i].getTitle().equalsIgnoreCase(title)) {
                this.books[i] = this.books[--this.count];
                this.books[this.count] = null;
                break;
            }
        }

    }

    public Book[] searchByAuthor(String author) {
        Book[] result = new Book[this.count];
        int resultCount = 0;

        for(int i = 0; i < this.count; ++i) {
            if (this.books[i].getAuthor().equalsIgnoreCase(author)) {
                result[resultCount++] = this.books[i];
            }
        }

        return this.trimArray(result, resultCount);
    }

    public Book[] searchByTitle(String title) {
        Book[] result = new Book[this.count];
        int resultCount = 0;

        for(int i = 0; i < this.count; ++i) {
            if (this.books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                result[resultCount++] = this.books[i];
            }
        }

        return this.trimArray(result, resultCount);
    }

    private Book[] trimArray(Book[] array, int size) {
        Book[] trimmed = new Book[size];
        System.arraycopy(array, 0, trimmed, 0, size);
        return trimmed;
    }

    public int countBooks() {
        return this.count;
    }
}