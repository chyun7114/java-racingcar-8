package racingcar.controller;

import racingcar.service.facade.GameFacade;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final GameFacade gameFacade = new GameFacade();

    public void start() {
        String userInputCarName = inputView.inputCarName();

        int tryCount = Integer.parseInt(inputView.inputTryCount());

        gameFacade.start(userInputCarName, tryCount);
    }
}
