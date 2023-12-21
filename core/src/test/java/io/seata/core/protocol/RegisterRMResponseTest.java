/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.seata.core.protocol;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link RegisterRMResponse}.
 *
 * @author Mia0451
 */
class RegisterRMResponseTest {

    @Test
    public void testToString() throws Exception {
        RegisterRMResponse registerRMResponse = new RegisterRMResponse();
        registerRMResponse.setVersion("1");
        registerRMResponse.setIdentified(true);
        registerRMResponse.setResultCode(ResultCode.Failed);
        Assertions.assertEquals(
                "RegisterRMResponse{version='1', extraData='null', identified=true, resultCode=Failed, msg='null'}",
                registerRMResponse.toString()
        );
    }

    @Test
    public void getTypeCode() {
        RegisterRMResponse registerRMResponse = new RegisterRMResponse();

        Assertions.assertEquals(MessageType.TYPE_REG_RM_RESULT, registerRMResponse.getTypeCode());
    }

    @Test
    public void isIdentified() {
        RegisterRMResponse registerRMResponse = new RegisterRMResponse();
        Assertions.assertTrue(registerRMResponse.isIdentified()); // default to true

        RegisterRMResponse registerRMResp = new RegisterRMResponse(false);
        Assertions.assertFalse(registerRMResp.isIdentified());
    }
}