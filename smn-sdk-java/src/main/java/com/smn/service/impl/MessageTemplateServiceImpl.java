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

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smn.common.HttpResponse;
import com.smn.common.utils.HttpUtil;
import com.smn.model.request.template.CreateMessageTemplateRequest;
import com.smn.model.request.template.DeleteMessageTemplateRequest;
import com.smn.model.request.template.ListMessageTemplatesRequest;
import com.smn.model.request.template.QueryMessageTemplateDetailRequest;
import com.smn.model.request.template.UpdateMessageTemplateRequest;
import com.smn.service.AbstractCommonService;
import com.smn.service.MessageTemplateService;

/**
 * Message template service implemented
 * 
 * @author huangqiong
 *
 * @date 2017年8月2日
 *
 * @version 0.1
 * @author yangyanping
 * @date 2017年8月25日
 * @version  0.2
 */
public class MessageTemplateServiceImpl extends AbstractCommonService implements MessageTemplateService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageTemplateServiceImpl.class);

    /**
     * smn host url
     */
    private String smnEndpoint;

    /**
     * project id
     */
    private String projectId;

    /**
     * create template
     * 
     * @param smnRequest
     * @return
     * @throws RuntimeException
     */
    public HttpResponse createMessageTemplate(CreateMessageTemplateRequest smnRequest) throws RuntimeException {
        LOGGER.info("Start to create message template.");

        try {
            Map<String, String> requestHeader = smnRequest.getRequestHeaderMap();
            Map<String, Object> requestParam = smnRequest.getRequestParameterMap();
            projectId = getIAMService().getAuthentication().getProjectId();
            smnEndpoint = smnConfiguration.getSmnEndpoint();
            smnRequest.setSmnEndpoint(smnEndpoint);
            smnRequest.setProjectId(projectId);
            String url = buildRequestUrl(smnRequest.getRequestUri());
            buildRequestHeader(requestHeader);
            HttpResponse httpResponse = HttpUtil.post(requestHeader, requestParam, url);
            return httpResponse;
        } catch (Exception e) {
            LOGGER.error("Failed to create message template.", e);
            throw new RuntimeException("Failed to create message template.", e);
        }
    }

    /**
     * update template
     * 
     * @param smnRequest
     * @return
     * @throws RuntimeException
     */
    public HttpResponse updateMessageTemplate(UpdateMessageTemplateRequest smnRequest) throws RuntimeException {
        LOGGER.info("Start to update message template.");

        try {
            Map<String, String> requestHeader = smnRequest.getRequestHeaderMap();
            Map<String, Object> requestParam = smnRequest.getRequestParameterMap();
            projectId = getIAMService().getAuthentication().getProjectId();
            smnEndpoint = smnConfiguration.getSmnEndpoint();
            smnRequest.setSmnEndpoint(smnEndpoint);
            smnRequest.setProjectId(projectId);
            String url = buildRequestUrl(smnRequest.getRequestUri());
            buildRequestHeader(requestHeader);
            HttpResponse httpResponse = HttpUtil.put(requestHeader, requestParam, url);
            return httpResponse;
        } catch (Exception e) {
            LOGGER.error("Failed to update message template.", e);
            throw new RuntimeException("Failed to update message template.", e);
        }
    }

    /**
     * delete template
     * 
     * @param smnRequest
     * @return
     * @throws RuntimeException
     */
    public HttpResponse deleteMessageTemplate(DeleteMessageTemplateRequest smnRequest) throws RuntimeException {
        LOGGER.info("Start to delete message template.");

        try {
            Map<String, String> requestHeader = smnRequest.getRequestHeaderMap();
            projectId = getIAMService().getAuthentication().getProjectId();
            smnEndpoint = smnConfiguration.getSmnEndpoint();
            smnRequest.setSmnEndpoint(smnEndpoint);
            smnRequest.setProjectId(projectId);
            String url = buildRequestUrl(smnRequest.getRequestUri());
            buildRequestHeader(requestHeader);
            HttpResponse httpResponse = HttpUtil.delete(requestHeader, url);
            return httpResponse;
        } catch (Exception e) {
            LOGGER.error("Failed to delete message template.", e);
            throw new RuntimeException("Failed to delete message template.", e);
        }
    }

    /**
     * query template list
     * 
     * @param smnRequest
     * @return
     * @throws RuntimeException
     */
    public HttpResponse listMessageTemplates(ListMessageTemplatesRequest smnRequest) throws RuntimeException {
        LOGGER.info("Start to list message template.");

        try {
            Map<String, String> requestHeader = smnRequest.getRequestHeaderMap();
            projectId = getIAMService().getAuthentication().getProjectId();
            smnEndpoint = smnConfiguration.getSmnEndpoint();
            smnRequest.setSmnEndpoint(smnEndpoint);
            smnRequest.setProjectId(projectId);
            String url = buildRequestUrl(smnRequest.getRequestUri());
            buildRequestHeader(requestHeader);
            HttpResponse httpResponse = HttpUtil.get(requestHeader, url);
            return httpResponse;
        } catch (Exception e) {
            LOGGER.error("Failed to list message templates.", e);
            throw new RuntimeException("Failed to list message templates.", e);
        }
    }

    /**
     * query template detail
     * 
     * @param smnRequest
     * @return
     * @throws RuntimeException
     */
    public HttpResponse queryMsgTemplateDetail(QueryMessageTemplateDetailRequest smnRequest)
            throws RuntimeException {
        LOGGER.info("Start to query message template detail.");

        try {
            Map<String, String> requestHeader = smnRequest.getRequestHeaderMap();
            projectId = getIAMService().getAuthentication().getProjectId();
            smnEndpoint = smnConfiguration.getSmnEndpoint();
            smnRequest.setSmnEndpoint(smnEndpoint);
            smnRequest.setProjectId(projectId);
            String url = buildRequestUrl(smnRequest.getRequestUri());
            buildRequestHeader(requestHeader);
            HttpResponse httpResponse = HttpUtil.get(requestHeader, url);
            return httpResponse;
        } catch (Exception e) {
            LOGGER.error("Failed to query message templates.", e);
            throw new RuntimeException("Failed to query message templates.", e);
        }
    }

}
