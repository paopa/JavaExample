package per.pao.example.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import per.pao.example.model.Model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RequestDecoder
        extends ReplayingDecoder<Model.Request>
{
    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
            throws Exception
    {
        Model.Request request = new Model.Request(in.readInt());
        int strLen = in.readInt();
        request.setStringValue(in.readCharSequence(strLen, charset).toString());
        out.add(request);
    }
}
