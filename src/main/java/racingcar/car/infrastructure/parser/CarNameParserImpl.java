package racingcar.car.infrastructure.parser;

import java.util.Arrays;
import java.util.List;

public class CarNameParserImpl implements CarNameParser {

    private static final String CAR_NAME_DELIMITER = ",";

    @Override
    public List<String> parse(String userInput) {
        String[] splitByDelimiter = userInput.split(CAR_NAME_DELIMITER);

        return Arrays.stream(splitByDelimiter).toList();
    }
}
