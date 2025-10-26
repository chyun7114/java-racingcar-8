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

    public void start(String carNamesInput, int tryCount) {
        Cars cars = carGenerationService.generateCars(carNamesInput);

        System.out.println("\n실행 결과");

        carMoveService.moveCars(cars, tryCount);

        List<String> winnerList = carWinnerService.getWinner(cars);

        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }
}
