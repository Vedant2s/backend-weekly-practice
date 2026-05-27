public class BookAlreadyExists extends Exception {
    // this was not Runtime exception bcause this is a user defined exception and we
    // want to force the user to handle it using try catch block
    public BookAlreadyExists(String msg) {
        super(msg);
    }
}