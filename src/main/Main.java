package main;

import model.Direction;
import model.Player;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();

        System.out.println(player.getDirection());

        player.setDirection(
                player.getDirection().turnRight());

        System.out.println(player.getDirection());

        player.setDirection(
                player.getDirection().turnRight());

        System.out.println(player.getDirection());

    }

}