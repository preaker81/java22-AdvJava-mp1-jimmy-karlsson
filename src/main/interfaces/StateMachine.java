package main.interfaces;

import java.util.Scanner;

import state.StateEnum;

public interface StateMachine {
    void changeState(StateEnum target);
    void performAction(Scanner sc);
}
