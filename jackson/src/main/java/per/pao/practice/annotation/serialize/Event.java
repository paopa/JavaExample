package per.pao.practice.annotation.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@RequiredArgsConstructor
public class Event
{
    private final String name;

    @JsonSerialize(using = Serializer.class)
    private final Date date;

    public static class Serializer
            extends StdSerializer<Date>
    {
        private static final SimpleDateFormat formatter
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        public Serializer()
        {
            this(null);
        }

        public Serializer(Class<Date> t)
        {
            super(t);
        }

        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider provider)
                throws IOException
        {
            gen.writeString(formatter.format(value));
        }
    }
}
