package racingcar.game.service.facade;

import java.util.List;
import racingcar.car.domain.Cars;
import racingcar.car.service.CarGenerationService;
import racingcar.car.service.CarGenerationServiceImpl;
import racingcar.car.service.CarMoveService;
import racingcar.car.service.CarMoveServiceImpl;
import racingcar.car.service.CarWinnerService;
import racingcar.car.service.CarWinnerServiceImpl;

public class GameFacade {

    private final CarGenerationService carGenerationService = new CarGenerationServiceImpl();
    private final CarMoveService carMoveService = new CarMoveServiceImpl();
    private final CarWinnerService carWinnerService = new CarWinnerServiceImpl();

    public Cars startGame(String carNamesInput) {
        return carGenerationService.generateCars(carNamesInput);
    }

    public void proceedOneTurn(Cars cars) {
        carMoveService.moveCars(cars);
    }

    public List<String> endGame(Cars cars) {
        return carWinnerService.getWinner(cars);
    }
}
