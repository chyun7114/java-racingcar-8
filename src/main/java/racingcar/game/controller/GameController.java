package racingcar.game.controller;

import java.util.List;
import racingcar.car.domain.Cars;
import racingcar.game.service.facade.GameFacade;
import racingcar.game.view.InputView;
import racingcar.game.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameFacade gameFacade = new GameFacade();

    public void start() {
        String userInputCarName = inputView.inputCarName();
        Cars cars = gameFacade.startGame(userInputCarName);

        int tryCount = Integer.parseInt(inputView.inputTryCount());

        outputView.printResultString();
        proceedGame(cars, tryCount);

        List<String> winnerList = gameFacade.endGame(cars);
        outputView.printWinners(winnerList);
    }

    private void proceedGame(Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            gameFacade.proceedOneTurn(cars);
            outputView.printProcessOutput(cars);
            outputView.printBlankLine();
        }
    }
}
