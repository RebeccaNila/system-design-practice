package dev.nila.practice.lld.DesignPatterns.CreationalPatterns.Singleton;

// Not a Singleton class
class Game {
    public Game() {
        System.out.println("Instance created!");
    }
    public void play() {

    }
}
public class Main {
    public static void main(String[] args) {
        Game game1 = new Game();
        Game game2 = new Game();
        game1.play();
        game2.play();
        System.out.println(game1 == game2);
    }

}
