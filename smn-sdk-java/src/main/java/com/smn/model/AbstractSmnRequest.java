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
/**
 * @author huangqiong
 * @date 2017年8月3日 下午5:28:21
 * @version 0.1
 * 
 */
package com.smn.model;

import java.util.HashMap;
import java.util.Map;

import com.smn.common.SmnConstants;

/**
 * @author huangqiong
 * @date 2017年8月3日 下午5:28:21
 * @version 0.1
 */
public abstract class AbstractSmnRequest implements SmnRequest {
    /**
     * smn endpoint
     */
    protected String smnEndpoint;

    /**
     * project id
     */
    protected String projectId;

    /**
     * xAuthToken
     */
    protected String xAuthToken;

    /**
     * Build common http's request header
     */
    public Map<String, String> getRequestHeaderMap() {
        Map<String, String> requestHeaderMap = new HashMap<String, String>();
        requestHeaderMap.put(SmnConstants.CONTENT_TYPE_TAG, SmnConstants.DEFAULT_CONTENT_TYPE);
        return requestHeaderMap;
    }

    /**
     * Get request URL from different API
     */
    public abstract String getRequestUri();

    /**
     * Get request body parameters from different API
     */
    public abstract Map<String, Object> getRequestParameterMap();


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

    /**
     * @param xAuthToken the xAuthToken to set
     */
    public void setxAuthToken(String xAuthToken) {
        this.xAuthToken = xAuthToken;
    }
}
