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

/**
 * Static constant holder class for json config key names.
 *
 * @since 1.1 
 * @author Willi Schoenborn
 */
final class JsonConfig {

    public static final String PREFIX = "json.";
    
    public static final String ESITMATED_RESPONSE_LENGTH = PREFIX + "estimatedResponseLength";

    private JsonConfig() {
        
    }
    
}
