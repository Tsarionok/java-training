package by.tsarionok.datahandler.factory;

import by.tsarionok.datahandler.DataReader;
import by.tsarionok.datahandler.DataWriter;
import by.tsarionok.datahandler.impl.DataReaderImpl;
import by.tsarionok.datahandler.impl.DataWriterImpl;

/**
 * Class Data Handler factory used to proceed the data that need to read or
 * write to the file.
 *
 * @author Sergey Tsarionok
 */
public final class DataHandlerFactory {

    /**
     * The factory instance will be created at the start of the execution of
     * DataHandlerFactory class.
     */
    private static DataHandlerFactory instance = new DataHandlerFactory();

    /**
     * Provides the access to DataReader class methods.
     */
    private final DataReader dataReader = new DataReaderImpl();

    /**
     * Provides the access to DataWriter class methods.
     */
    private final DataWriter dataWriter = new DataWriterImpl();

    /**
     * Private constructor. Forbids the explicit object creation.
     */
    private DataHandlerFactory() {
    }

    /**
     * Global point for access to factory methods.
     *
     * @return the instance of Data Handler factory.
     */
    public static DataHandlerFactory getInstance() {
        return instance;
    }

    /**
     * Returns the implementation of the Data Reader interface and provides
     * the access to its methods.
     *
     * @return an instance of Data Reader implementation.
     */
    public DataReader getDataReader() {
        return dataReader;
    }

    /**
     * Returns the implementation of the Data Writer interface and provides
     * the access to its methods.
     *
     * @return an instance of Data Writer implementation.
     */
    public DataWriter getDataWriter() {
        return dataWriter;
    }
}
