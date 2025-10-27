package racingcar.game.controller;

import java.util.List;
import racingcar.car.domain.Cars;
import racingcar.game.service.facade.GameFacade;
import racingcar.game.view.InputView;
import racingcar.game.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameFacade gameFacade;

    public GameController(InputView inputView, OutputView outputView, GameFacade gameFacade) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameFacade = gameFacade;
    }

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
