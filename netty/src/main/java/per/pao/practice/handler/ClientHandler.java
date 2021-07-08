package per.pao.practice.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import per.pao.practice.model.Model;

@Slf4j
public class ClientHandler
        extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception
    {
        Model.Request request = new Model.Request(123);
        request.setStringValue("all work and no play makes jack a dull boy");
        ctx.writeAndFlush(request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception
    {
        log.info("response data:{}", (Model.Response) msg);
        ctx.close();
    }
}
