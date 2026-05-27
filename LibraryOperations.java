public interface LibraryOperations {
    void issueBook(int bookId, int studentId) throws Exception;
    void returnBook(int bookId, int studentId) throws Exception;
}
