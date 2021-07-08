package per.pao.practice;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import per.pao.practice.decoder.ResponseDecoder;
import per.pao.practice.encoder.RequestEncoder;
import per.pao.practice.handler.ClientHandler;
import per.pao.practice.handler.StringHandler;

@Slf4j
public class Starter
{
    @SneakyThrows
    public static void main(String[] args)
    {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 8080;
        new Thread(new Server(port)).start();
//        Thread.sleep(3000);
//        new Thread(new Client("localhost", port)).start();
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
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup, workGroup);
                bootstrap.channel(NioServerSocketChannel.class);
                bootstrap.childHandler(new ChannelInitializer<SocketChannel>()
                {
                    @Override
                    protected void initChannel(SocketChannel ch)
                            throws Exception
                    {
//                        ch.pipeline().addLast(
//                                new RequestDecoder(),
//                                new ResponseEncoder(),
//                                new ProcessingHandler());
//                        ch.pipeline().addLast(new SimpleProcessingHandler());
                        ch.pipeline().addLast(new StringHandler());
                    }
                });
                bootstrap.option(ChannelOption.SO_BACKLOG, 128);
                bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
                ChannelFuture future = bootstrap.bind(port).sync();
                if (future.isSuccess()) {
                    log.info("server start");
                }
                future.channel().closeFuture().sync();
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

    @AllArgsConstructor
    private static class Client
            implements Runnable
    {
        private final String host;
        private final int port;

        @Override
        public void run()
        {
            NioEventLoopGroup workGroup = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(workGroup);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
                bootstrap.handler(new ChannelInitializer<SocketChannel>()
                {
                    @Override
                    protected void initChannel(SocketChannel ch)
                            throws Exception
                    {
                        ch.pipeline().addLast(
                                new RequestEncoder(),
                                new ResponseDecoder(),
                                new ClientHandler());
                    }
                });

                while (true) {
                    ChannelFuture future = bootstrap.connect(host, port).sync();
                    future.channel().closeFuture().sync();
                    Thread.sleep(2000);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                workGroup.shutdownGracefully();
                log.info("client shutdown");
            }
        }
    }
}
