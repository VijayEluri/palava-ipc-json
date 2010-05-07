/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.palava.ipc.json;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decodes a json string into a {@link List} or a {@link Map}.
 *
 * @since 1.0
 * @author Willi Schoenborn
 */
final class JsonDecoder extends OneToOneDecoder {

    private static final Logger LOG = LoggerFactory.getLogger(JsonDecoder.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, Object message) throws Exception {
        if (message instanceof String) {
            final String content = String.class.cast(message);
            if (content.startsWith("[")) {
                LOG.trace("Decoding list from {}", content);
                return MAPPER.readValue(content, List.class);
            } else if (content.startsWith("{")) {
                LOG.trace("Decoding map from {}", content);
                return MAPPER.readValue(content, Map.class);
            } else {
                return message;
            }
        } else {
            return message;
        }
    }
    
    
}
