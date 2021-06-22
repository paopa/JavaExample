package per.pao.example.encoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import per.pao.example.model.Model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RequestEncoder
        extends MessageToByteEncoder<Model.Request>
{
    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void encode(ChannelHandlerContext ctx, Model.Request msg, ByteBuf out)
            throws Exception
    {
        out.writeInt(msg.getIntValue());
        out.writeInt(msg.getStringValue().length());
        out.writeCharSequence(msg.getStringValue(), charset);
    }
}
