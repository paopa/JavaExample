package per.pao.practice.encoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import per.pao.practice.model.Model;

public class ResponseEncoder
        extends MessageToByteEncoder<Model.Response>
{
    @Override
    protected void encode(ChannelHandlerContext ctx, Model.Response msg, ByteBuf out)
            throws Exception
    {
        out.writeInt(msg.getIntValue());
    }
}
