/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.smn.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smn.common.utils.HttpUtil;
import com.smn.model.request.publish.PublishMsgRequest;
import com.smn.service.AbstractCommonService;
import com.smn.service.PublishService;

/**
 * Publish service implemented
 * @author huangqiong
 * @version 0.1
 * @author yangyanping
 *
 * @date 2017年8月24日
 *
 * @version 0.1
 */
public class PublishServiceImpl extends AbstractCommonService implements PublishService {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PublishServiceImpl.class);

    /**
     * smn host url
     */
    private String smnEndpoint;

    /**
     * project id
     */
    private String projectId;

    /**
     * message publish
     * 
     * @param smnRequest
     * @return
     * @throws RuntimeException
     */
    public Map<String, Object> publish(PublishMsgRequest smnRequest) throws RuntimeException, UnsupportedEncodingException {
        LOGGER.info("Start to publish message.");

        try {
            Map<String, String> requestHeader = smnRequest.getRequestHeaderMap();
            Map<String, Object> requestParam = smnRequest.getRequestParameterMap();
            projectId = getIAMService().getAuthentication().getProjectId();
            smnEndpoint = smnConfiguration.getSmnEndpoint();
            smnRequest.setSmnEndpoint(smnEndpoint);
            smnRequest.setProjectId(projectId);
            String url = buildRequestUrl(smnRequest.getRequestUri());
            buildRequestHeader(requestHeader);
            Map<String, Object> responseMap = HttpUtil.post(requestHeader, requestParam, url);
            return responseMap;
        } catch (Exception e) {
            LOGGER.error("Failed to publish message.", e);
            throw new RuntimeException("Failed to publish message.", e);
        }
    }

   

}