package handler;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.Charsets;

import java.util.List;
import java.util.Map;

@Slf4j
public class GetRequestHandler implements RequestHandler{
    @Override
    public Object handle(FullHttpRequest fullHttpRequest) {
        QueryStringDecoder queryStringDecoder =
                new QueryStringDecoder(fullHttpRequest.uri(), Charsets.toCharset(CharEncoding.UTF_8));
        Map<String, List<String>> uriAttributes = queryStringDecoder.parameters();

        for (Map.Entry<String, List<String>> attr : uriAttributes.entrySet()) {
            for (String attrVal : attr.getValue()) {
                log.info(attr.getKey() + "=" + attrVal);
            }
        }
        return null;
    }
}
