package by.tsarionok.controller.command.impl;

import by.tsarionok.controller.command.Command;
import by.tsarionok.service.MatrixService;
import by.tsarionok.service.exception.ServiceException;
import by.tsarionok.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LockCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(
            LockCommand.class);

    private static final String APPENDER = "\n";

    private static final String DEL = " ";

    @Override
    public String execute(final String request) {

        StringBuilder response = new StringBuilder();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        try {
            int[][] array = matrixService.fillByLocks();

            response.append(APPENDER);
            response.append(Arrays.stream(array)
                    .map(s -> Arrays.stream(s)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(DEL)))
                    .collect(Collectors.joining(System.lineSeparator())));
        } catch (ServiceException e) {
            response.append(e.getMessage());
            LOGGER.error(response);
        }

        return response.toString();
    }
}
