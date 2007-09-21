/**
 * MVEL (The MVFLEX Expression Language)
 *
 * Copyright (C) 2007 Christopher Brock, MVFLEX/Valhalla Project and the Codehaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.mvel;

import static org.mvel.util.PropertyTools.isNumeric;

import static java.lang.String.valueOf;
import java.util.Collection;
import java.io.Serializable;

public class BlankLiteral implements Serializable {
    public static final BlankLiteral INSTANCE = new BlankLiteral();

    public BlankLiteral() {
    }

    public boolean equals(Object obj) {
        if (obj == null || "".equals(valueOf(obj))) {
            return true;
        }
        else if (isNumeric(obj)) {
            return "0".equals(valueOf(obj));
        }
        else if (obj instanceof Collection) {
            return ((Collection) obj).size() == 0;
        }
        else if (obj.getClass().isArray()) {
            return ((Object[]) obj).length == 0;
        }
        return false;
    }
}
