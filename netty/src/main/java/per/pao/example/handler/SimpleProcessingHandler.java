package per.pao.example.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import per.pao.example.model.Model;

@Slf4j
public class SimpleProcessingHandler
        extends ChannelInboundHandlerAdapter
{
    private ByteBuf tmp;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx)
            throws Exception
    {
        log.info("handler registered");
        tmp = ctx.alloc().buffer(4);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx)
            throws Exception
    {
        log.info("handler unregistered");
        tmp.release();
        tmp = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception
    {
        ByteBuf m = (ByteBuf) msg;
        tmp.writeBytes(m);
        m.release();
        if (tmp.readableBytes() >= 4) {
            Model.Request request = new Model.Request(tmp.readInt());
            Model.Response response = new Model.Response(request.getIntValue() * 2);
            ChannelFuture future = ctx.writeAndFlush(response);
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
