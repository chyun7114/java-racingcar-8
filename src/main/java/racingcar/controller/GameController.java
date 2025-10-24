package racingcar.controller;

import racingcar.service.CarGenerationService;
import racingcar.service.CarGenerationServiceImpl;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final CarGenerationService carGenerationService = new CarGenerationServiceImpl();

    public void start() {
        String userInputCarName = inputView.inputCarName();
        carGenerationService.generateCars(userInputCarName);
    }
}
