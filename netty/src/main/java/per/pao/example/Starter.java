package per.pao.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.bootstrap.ServerBootstrapConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import per.pao.example.decoder.RequestDecoder;
import per.pao.example.encoder.ResponseEncoder;
import per.pao.example.handler.ProcessingHandler;

@Slf4j
public class Starter
{
    public static void main(String[] args)
    {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 8080;
        new Thread(new Server(port)).start();
    }

    @AllArgsConstructor
    private static class Server
            implements Runnable
    {
        private final int port;

        @Override
        public void run()
        {
            NioEventLoopGroup bossGroup = new NioEventLoopGroup();
            NioEventLoopGroup workGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>()
                        {
                            @Override
                            protected void initChannel(SocketChannel ch)
                                    throws Exception
                            {
                                ch.pipeline().addLast(
                                        new RequestDecoder(),
                                        new ResponseEncoder(),
                                        new ProcessingHandler()
                                );
                            }
                        })
                        .option(ChannelOption.SO_BACKLOG, 128)
                        .childOption(ChannelOption.SO_KEEPALIVE, true);
                ChannelFuture f = b.bind(port).sync();
                log.info("server start");
                f.channel().closeFuture().sync();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                workGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
                log.info("server shutdown");
            }
        }
    }
}
