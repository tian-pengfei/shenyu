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

package org.apache.shenyu.client.core.client.registrar;

import org.apache.shenyu.client.core.client.ApiBean;
import org.apache.shenyu.client.core.client.matcher.Matcher;

import java.util.List;

public final class ApiBeanRegistrar<T> extends AbstractRegistrar<ApiBean<T>> {

    AbstractRegistrar<ApiBean<T>.ApiDefinition> apiRegistrar;

    public ApiBeanRegistrar(Matcher<ApiBean<T>> matcher,
                            AbstractRegistrar<ApiBean<T>.ApiDefinition> apiRegistrar) {
        super(matcher);
        this.apiRegistrar = apiRegistrar;
    }

    @Override
    protected void doRegister(ApiBean<T> element) {
        List<ApiBean<T>.ApiDefinition> apiDefinition = element.getApiDefinitions();
        apiDefinition.forEach(api -> apiRegistrar.register(api));
    }


}
