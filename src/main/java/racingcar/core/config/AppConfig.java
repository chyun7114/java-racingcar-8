package racingcar.core.config;

import racingcar.car.service.CarGenerationService;
import racingcar.car.service.CarGenerationServiceImpl;
import racingcar.car.service.CarMoveService;
import racingcar.car.service.CarMoveServiceImpl;
import racingcar.car.service.CarWinnerService;
import racingcar.car.service.CarWinnerServiceImpl;
import racingcar.game.controller.GameController;
import racingcar.game.service.facade.GameFacade;
import racingcar.game.view.InputView;
import racingcar.game.view.OutputView;

public class AppConfig {

    private static AppConfig instance;

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public GameController gameController() {
        return new GameController(inputView(), outputView(), gameFacade());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public GameFacade gameFacade() {
        return new GameFacade(carGenerationService(), carMoveService(), carWinnerService());
    }

    public CarGenerationService carGenerationService() {
        return new CarGenerationServiceImpl();
    }

    public CarMoveService carMoveService() {
        return new CarMoveServiceImpl();
    }

    public CarWinnerService carWinnerService() {
        return new CarWinnerServiceImpl();
    }

}
