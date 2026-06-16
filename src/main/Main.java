package main;

import model.Player;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();

        player.setName("John");

        System.out.println(player.getName());

        System.out.println(player.getRow());

        System.out.println(player.getColumn());

    }
}