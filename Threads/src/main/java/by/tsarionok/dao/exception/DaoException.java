package by.tsarionok.dao.exception;

public class DaoException extends Exception {

    public DaoException() {
        super();
    }

    public DaoException(final String message) {
        super(message);
    }

    public DaoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DaoException(final Throwable cause) {
        super(cause);
    }
}
