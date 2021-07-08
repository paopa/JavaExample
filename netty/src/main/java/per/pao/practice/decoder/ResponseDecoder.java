package per.pao.practice.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import per.pao.practice.model.Model;

import java.util.List;

public class ResponseDecoder
        extends ReplayingDecoder<Model.Response>
{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
            throws Exception
    {
        Model.Response response = new Model.Response(in.readInt());
        out.add(response);
    }
}
