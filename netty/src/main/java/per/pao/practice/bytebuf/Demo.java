package per.pao.practice.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

public class Demo
{
    public static void main(String[] args)
    {
        ByteBuf byteBuf = Unpooled.buffer(4);
        byteBuf.writeBytes("hello~".getBytes(StandardCharsets.UTF_8));
        while (byteBuf.isReadable()) {
            System.out.println(byteBuf.readShort());
        }
    }
}
