package per.pao.example.handler;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import per.pao.example.model.Model;

@Slf4j
public class ProcessingHandler
        extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception
    {
        Model.Request request = (Model.Request) msg;
        Model.Response response = new Model.Response(request.getIntValue() * 2);
        ChannelFuture future = ctx.writeAndFlush(response);
        future.addListener(ChannelFutureListener.CLOSE);
        log.info(request.toString());
    }
}
