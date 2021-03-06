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
package com.smn.client;

import com.smn.common.HttpResponse;
import com.smn.model.request.publish.PublishMsgRequest;
import com.smn.model.request.sms.*;
import com.smn.model.request.subscription.ListSubscriptionsByTopicRequest;
import com.smn.model.request.subscription.ListSubscriptionsRequest;
import com.smn.model.request.subscription.SubcriptionRequest;
import com.smn.model.request.subscription.UnSubcriptionRequest;
import com.smn.model.request.template.*;
import com.smn.model.request.topic.*;

/**
 * smn client
 *
 * @author zhangyx
 * @version 0.9
 */
public interface SmnClient {

    /**
     * query topic list
     * <p>
     *
     * @param smnRequest {@link ListTopicsRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse listTopics(ListTopicsRequest smnRequest);

    /**
     * delete topic
     * <p>
     * failed，return request_id and status
     *
     * @param smnRequest {@link DeleteTopicRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse deleteTopic(DeleteTopicRequest smnRequest);

    /**
     * create topic
     * <p>
     * failed，return request_id and status
     *
     * @param smnRequest {@link CreateTopicRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse createTopic(CreateTopicRequest smnRequest);

    /**
     * query topic detail
     *
     * @param smnRequest {@link QueryTopicDetailRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse queryTopicDetail(QueryTopicDetailRequest smnRequest);

    /**
     * update topic display name
     *
     * @param smnRequest {@link UpdateTopicRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse updateTopic(UpdateTopicRequest smnRequest);

    /**
     * query topic attributes
     *
     * @param smnRequest {@link ListTopicAttributesRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse listTopicAttributes(ListTopicAttributesRequest smnRequest);

    /**
     * update topic attributes
     *
     * @param smnRequest {@link UpdateTopicAttributeRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse updateTopicAttribute(UpdateTopicAttributeRequest smnRequest);

    /**
     * delete designated topic attribute by name
     *
     * @param smnRequest {@link DeleteTopicAttributeByNameRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse deleteTopicAttributeByName(DeleteTopicAttributeByNameRequest smnRequest);

    /**
     * delete all topic attributes
     * <p>
     *
     * @param smnRequest {@link DeleteTopicAttributesRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse deleteTopicAttributes(DeleteTopicAttributesRequest smnRequest);

    /**
     * subscribe
     *
     * @param subcriptionRequest {@link SubcriptionRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse subscribe(SubcriptionRequest subcriptionRequest);

    /**
     * unSubcription
     *
     * @param unSubcriptionRequest {@link UnSubcriptionRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse unsubscribe(UnSubcriptionRequest unSubcriptionRequest);

    /**
     * list subscribers
     *
     * @param listSubscriptionsRequest {@link ListSubscriptionsRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest);

    /**
     * list subscribers of designated topic
     *
     * @param listSubscriptionsByTopicRequest {@link ListSubscriptionsByTopicRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest);

    /**
     * create message template
     *
     * @param smnRequest {@link CreateMessageTemplateRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error throw exception
     */
    HttpResponse createMessageTemplate(CreateMessageTemplateRequest smnRequest);

    /**
     * update message template
     *
     * @param smnRequest request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error throw exception
     */
    HttpResponse updateMessageTemplate(UpdateMessageTemplateRequest smnRequest);

    /**
     * delete message template
     * <p>
     *
     * @param smnRequest {@link DeleteMessageTemplateRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error throw exception
     */
    HttpResponse deleteMessageTemplate(DeleteMessageTemplateRequest smnRequest);

    /**
     * query message template list
     *
     * @param smnRequest {@link ListMessageTemplatesRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error throw exception
     */
    HttpResponse listMessageTemplates(ListMessageTemplatesRequest smnRequest);

    /**
     * query message template detail
     * <p>
     *
     * @param smnRequest {@link QueryMessageTemplateDetailRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse queryMsgTemplateDetail(QueryMessageTemplateDetailRequest smnRequest);

    /**
     * publish message
     * <p>
     * success，return<CODE>HttpResponse</CODE>
     * <p>
     * failed，return request_id and status
     *
     * @param publishMsgRequest {@link PublishMsgRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token ,throw exception
     */
    HttpResponse publish(PublishMsgRequest publishMsgRequest);

    /**
     * send sms
     * <p>
     * sucess,return<CODE>Map</CODE>including:request_id,message_id and status
     * <p>
     * 发送fail，return request_id and status
     *
     * @param smnRequest {@link SmsPublishRequest} request
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     * @throws RuntimeException connect error,fail to get iam token will throw exception
     */
    HttpResponse smsPublish(SmsPublishRequest smnRequest);

    /**
     * 查询短信的发送状态
     *
     * @param smnRequest {@link ListSmsMsgReportRequest} request message
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     */
    HttpResponse listSmsMsgReport(ListSmsMsgReportRequest smnRequest);

    /**
     * 查询已发送短信的内容
     *
     * @param smnRequest {@link GetSmsMessageRequest} request message
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     */
    HttpResponse getSmsMessage(GetSmsMessageRequest smnRequest);


    /**
     * 查询短信回调时间列表
     *
     * @param smnRequest {@link ListSmsCallbackEventRequest} request message
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     */
    HttpResponse listSmsCallbackEvent(ListSmsCallbackEventRequest smnRequest);

    /**
     * 查询短信回调时间列表
     *
     * @param smnRequest {@link ListSmsCallbackEventRequest} request message
     * @return {@link HttpResponse}
     * <p>
     * {@code httpCode}
     * <p>
     * {@code body}Map&lt;String,String%gt;
     */
    HttpResponse updateSmsCallbackEvent(UpdateSmsCallbackEventRequest smnRequest);
}
