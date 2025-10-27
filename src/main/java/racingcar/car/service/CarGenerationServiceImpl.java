package racingcar.car.service;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.infrastructure.parser.CarNameParser;
import racingcar.game.infrastructure.validator.UserInputValidator;

public class CarGenerationServiceImpl implements CarGenerationService {

    private final CarNameParser carNameParser;
    private final UserInputValidator userInputValidator;

    public CarGenerationServiceImpl(
            CarNameParser carNameParser,
            UserInputValidator userInputValidator
    ) {
        this.carNameParser = carNameParser;
        this.userInputValidator = userInputValidator;
    }

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
