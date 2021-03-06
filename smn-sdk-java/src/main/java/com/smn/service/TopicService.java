/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http: //www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.smn.service;

import com.smn.common.HttpResponse;
import com.smn.model.request.topic.CreateTopicRequest;
import com.smn.model.request.topic.DeleteTopicAttributeByNameRequest;
import com.smn.model.request.topic.DeleteTopicAttributesRequest;
import com.smn.model.request.topic.DeleteTopicRequest;
import com.smn.model.request.topic.ListTopicAttributesRequest;
import com.smn.model.request.topic.ListTopicsRequest;
import com.smn.model.request.topic.QueryTopicDetailRequest;
import com.smn.model.request.topic.UpdateTopicAttributeRequest;
import com.smn.model.request.topic.UpdateTopicRequest;

/**
 * topic service
 *
 * @author huangqiong
 * @version 0.1
 */
public interface TopicService extends CommonService {

    /**
     * create topic
     * <p>
     * failed，return request_id and status
     *
     * @param smnRequest
     *            {@link CreateTopicRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse createTopic(CreateTopicRequest smnRequest) throws RuntimeException;

    /**
     * delete topic
     * <p>
     * failed，return request_id and status
     *
     * @param smnRequest
     *            {@link DeleteTopicRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse deleteTopic(DeleteTopicRequest smnRequest) throws RuntimeException;

    /**
     * query topic list
     * <p>
     *
     * @param smnRequest
     *            {@link ListTopicsRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse listTopics(ListTopicsRequest smnRequest) throws RuntimeException;

    /**
     * query topic detail
     *
     * @param smnRequest
     *            {@link QueryTopicDetailRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse queryTopicDetail(QueryTopicDetailRequest smnRequest) throws RuntimeException;

    /**
     * update topic display name
     *
     * @param smnRequest
     *            {@link UpdateTopicRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse updateTopic(UpdateTopicRequest smnRequest) throws RuntimeException;

    /**
     * query topic attributes
     *
     * @param smnRequest
     *            {@link ListTopicAttributesRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse listTopicAttributes(ListTopicAttributesRequest smnRequest) throws RuntimeException;

    /**
     * update topic attributes
     *
     * @param smnRequest
     *            {@link UpdateTopicAttributeRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse updateTopicAttribute(UpdateTopicAttributeRequest smnRequest) throws RuntimeException;

    /**
     * delete designated topic attribute by name
     *
     * @param smnRequest
     *            {@link DeleteTopicAttributeByNameRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse deleteTopicAttributeByName(DeleteTopicAttributeByNameRequest smnRequest)
            throws RuntimeException;

    /**
     * delete all topic attributes
     * <p>
     *
     * @param smnRequest
     *            {@link DeleteTopicAttributesRequest} request
     * @return {@link HttpResponse}
     *         <p>
     *         {@code httpCode}
     *         <p>
     *         {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException
     *             connect error,fail to get iam token ,throw exception
     */
	HttpResponse deleteTopicAttributes(DeleteTopicAttributesRequest smnRequest) throws RuntimeException;

}
