package per.pao.example.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringHandler
        extends SimpleChannelInboundHandler<ByteBuf>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg)
            throws Exception
    {
        StringBuilder builder = new StringBuilder();
        while (msg.isReadable()) {
            builder.append((char) msg.readByte());
        }
        log.info("server get request: {}", builder);
    }
}
