package main.interfaces;

import state.StateEnum;

public interface StateMachine {
    void changeState(StateEnum target);
    void performAction();
}
