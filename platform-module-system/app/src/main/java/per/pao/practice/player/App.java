package per.pao.practice.player;

import per.pao.modules.api.player.Player;

public class App
{
    public static void main(String[] args)
    {
        Player.provide("ConsolePlayer").play("xxxx");
    }
}
