package per.pao.modules.impl.player;

import per.pao.modules.api.player.Player;

public class ConsolePlayer
        implements Player
{
    @Override
    public void play(String video)
    {
        System.out.println(String.format("playing %s now", video));
    }
}
