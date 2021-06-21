package per.pao.example;

import lombok.AllArgsConstructor;

public class Starter
{
    public static void main(String[] args)
    {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 8080;
        new Server(port).run();
    }

    @AllArgsConstructor
    private static class Server
            implements Runnable
    {
        private final int port;

        @Override
        public void run()
        {
            //todo
        }
    }
}
