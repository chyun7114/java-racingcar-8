package racingcar.game.service.facade;

import java.util.List;
import racingcar.car.domain.Cars;
import racingcar.car.service.CarGenerationService;
import racingcar.car.service.CarMoveService;
import racingcar.car.service.CarWinnerService;

public class GameFacade {

    private final CarGenerationService carGenerationService;
    private final CarMoveService carMoveService;
    private final CarWinnerService carWinnerService;

    public GameFacade(
            CarGenerationService carGenerationService,
            CarMoveService carMoveService,
            CarWinnerService carWinnerService
    ) {
        this.carGenerationService = carGenerationService;
        this.carMoveService = carMoveService;
        this.carWinnerService = carWinnerService;
    }

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
