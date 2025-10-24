package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.infrastructure.parser.CarNameParser;
import racingcar.infrastructure.parser.CarNameParserImpl;
import racingcar.infrastructure.validator.UserInputValidator;

public class CarGenerationServiceImpl implements CarGenerationService {

    private final CarNameParser carNameParser = new CarNameParserImpl();
    private final UserInputValidator userInputValidator = new UserInputValidator();

    public Cars generateCars(String userInput) {

        List<String> carNames = carNameParser.parse(userInput);

        validateCarNames(carNames);

        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }

    private void validateCarNames(List<String> carNames) {

        for (String carName : carNames) {
            userInputValidator.carNameEmptyValidator(carName);
            userInputValidator.carNameLengthValidator(carName);
        }
    }
}
