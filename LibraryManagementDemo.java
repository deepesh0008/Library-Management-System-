public class LibraryManagementDemo {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(1, "Anita");

        librarian.addBookToLibrary(library, new Book(101, "Java Fundamentals", "A. Author"));
        librarian.addBookToLibrary(library, new Book(102, "Data Structures", "B. Writer"));
        librarian.addBookToLibrary(library, new Book(103, "Database Systems", "C. Scholar"));

        librarian.addStudentToLibrary(library, new Student(201, "Rahul", "Computer Science"));
        librarian.addStudentToLibrary(library, new Student(202, "Maya", "Information Technology"));

        System.out.println("=== Library Book List ===");
        library.viewAllBooks();

        try {
            librarian.issueBook(library, 101, 201);
            librarian.issueBook(library, 102, 201);
            librarian.issueBook(library, 103, 201);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        System.out.println("\n=== Student Details ===");
        try {
            library.viewStudentDetails(201);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        try {
            librarian.acceptReturnedBook(library, 102, 201);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        System.out.println("\n=== Library Book List After Return ===");
        library.viewAllBooks();
    }
}
