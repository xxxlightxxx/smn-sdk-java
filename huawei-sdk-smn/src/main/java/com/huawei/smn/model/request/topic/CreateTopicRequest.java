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
package com.huawei.smn.model.request.topic;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.smn.common.SmnConstants;
import com.huawei.smn.common.utils.ValidationUtil;
import com.huawei.smn.model.AbstractSmnRequest;

/**
 * @author huangqiong
 *
 * @date 2017年8月2日
 *
 * @version 0.1
 */
public class CreateTopicRequest extends AbstractSmnRequest {

    private static Logger LOGGER = LoggerFactory.getLogger(CreateTopicRequest.class);

    /**
     * final string "name"
     */
    final static String NAME = "name";

    /**
     * final string "displayName"
     */
    final static String DISPLAY_NAME = "displayName";

    /**
     * topic name
     */
    private String name;

    /**
     * topic's descriptions
     */
    private String displayName;

    /**
     * smn endpoint
     */
    private String smnEndpoint;

    /**
     * project id
     */
    private String projectId;

    /**
     * xAuthToken
     */
    private String xAuthToken;

    /**
     * build and get request uri
     */
    public String getRequestUri() throws RuntimeException {

        if (StringUtils.isBlank(getProjectId())) {
            LOGGER.error("Create topic request, projectId is null.");
            throw new NullPointerException("Create topic request, projectId is null.");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(SmnConstants.URL_DELIMITER).append(SmnConstants.V2_VERSION).append(SmnConstants.URL_DELIMITER)
                .append(getProjectId()).append(SmnConstants.SMN_TOPIC_URI);

        LOGGER.info("Request uri is {}.", sb.toString());
        return sb.toString();
    }

    /**
     * build and get request parameters
     */
    @Override
    public Map<String, Object> getRequestParameterMap() {
        Map<String, Object> requestParameterMap = new HashMap<String, Object>();
        requestParameterMap.put(DISPLAY_NAME, getDisplayName());
        requestParameterMap.put(NAME, getName());
        return requestParameterMap;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {

        if (!ValidationUtil.validateTopicName(name)) {
            throw new RuntimeException("Topic name is illegal.");
        }

        this.name = name;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * set displayName
     * <p>
     * validate display length before set the value
     * 
     * @param displayName
     *            the displayName to set
     */
    public void setDisplayName(String displayName) {

        if (StringUtils.isNoneEmpty(displayName)) {
            if (ValidationUtil.validateDisplayName(displayName)) {
                this.displayName = displayName;
            } else {
                throw new RuntimeException("Display name is oversized.");
            }
        } else {
            this.displayName = displayName;
        }
    }

    /**
     * @return the smnEndpoint
     */
    public String getSmnEndpoint() {
        return smnEndpoint;
    }

    /**
     * @param smnEndpoint
     *            the smnEndpoint to set
     */
    public void setSmnEndpoint(String smnEndpoint) {
        this.smnEndpoint = smnEndpoint;
    }

    /**
     * @return the projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     *            the projectId to set
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the xAuthToken
     */
    public String getxAuthToken() {
        return xAuthToken;
    }

    public void setxAuthToken(String xAuthToken) {
        this.xAuthToken = xAuthToken;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CreateTopicRequest [name=").append(name).append(", displayName=").append(displayName)
                .append(", smnEndpoint=").append(smnEndpoint).append(", projectId=").append(projectId).append("]");
        return builder.toString();
    }

}
