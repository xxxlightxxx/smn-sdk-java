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
import com.huawei.smn.model.AbstractSmnRequest;

/**
 * list topic
 * 
 * @author huangqiong
 *
 * @date 2017年8月2日
 *
 * @version 0.1
 */
public class ListTopicsRequest extends AbstractSmnRequest {

    private static Logger LOGGER = LoggerFactory.getLogger(ListTopicsRequest.class);

    /**
     * paging list's starting page,default 0
     */
    private int offset;

    /**
     * max returned items for a request,default 100
     */
    private int limit;

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

        if (StringUtils.isBlank(projectId)) {
            LOGGER.error("List topic request, projectId is null.");
            throw new NullPointerException("List topic request, projectId is null.");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(SmnConstants.URL_DELIMITER).append(SmnConstants.V2_VERSION).append(SmnConstants.URL_DELIMITER)
                .append(projectId).append(SmnConstants.SMN_TOPIC_URI);

        if (offset > 0) {
            sb.append("?offset=" + offset);
        } else {
            sb.append("?offset=" + "0");
        }

        if (limit > 0 && limit < 100) {
            sb.append("&limit=" + limit);
        } else {
            sb.append("&limit=").append("100");
        }

        LOGGER.info("Request uri is {}.", sb.toString());
        return sb.toString();
    }

    /**
     * build and get request parameters
     */
    @Override
    public Map<String, Object> getRequestParameterMap() throws RuntimeException {
        Map<String, Object> requestParameterMap = new HashMap<String, Object>();
        return requestParameterMap;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset
     *            the offset to set
     */
    public void setOffset(int offset) {
        if (offset > 0) {
            this.offset = offset;
        }
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit
     *            the limit to set
     */
    public void setLimit(int limit) {
        if (100 > limit && limit > 0) {
            this.limit = limit;
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
        builder.append("ListTopicsRequest [offset=").append(offset).append(", limit=").append(limit)
                .append(", smnEndpoint=").append(smnEndpoint).append(", projectId=").append(projectId).append("]");
        return builder.toString();
    }

}