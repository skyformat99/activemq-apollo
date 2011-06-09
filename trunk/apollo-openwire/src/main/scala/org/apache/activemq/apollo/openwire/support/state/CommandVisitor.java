/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.apollo.openwire.support.state;

import org.apache.activemq.apollo.openwire.command.BrokerInfo;
import org.apache.activemq.apollo.openwire.command.ConnectionControl;
import org.apache.activemq.apollo.openwire.command.ConnectionError;
import org.apache.activemq.apollo.openwire.command.ConnectionId;
import org.apache.activemq.apollo.openwire.command.ConnectionInfo;
import org.apache.activemq.apollo.openwire.command.ConsumerControl;
import org.apache.activemq.apollo.openwire.command.ConsumerId;
import org.apache.activemq.apollo.openwire.command.ConsumerInfo;
import org.apache.activemq.apollo.openwire.command.ControlCommand;
import org.apache.activemq.apollo.openwire.command.DestinationInfo;
import org.apache.activemq.apollo.openwire.command.FlushCommand;
import org.apache.activemq.apollo.openwire.command.KeepAliveInfo;
import org.apache.activemq.apollo.openwire.command.Message;
import org.apache.activemq.apollo.openwire.command.MessageAck;
import org.apache.activemq.apollo.openwire.command.MessageDispatch;
import org.apache.activemq.apollo.openwire.command.MessageDispatchNotification;
import org.apache.activemq.apollo.openwire.command.MessagePull;
import org.apache.activemq.apollo.openwire.command.ProducerAck;
import org.apache.activemq.apollo.openwire.command.ProducerId;
import org.apache.activemq.apollo.openwire.command.ProducerInfo;
import org.apache.activemq.apollo.openwire.command.RemoveInfo;
import org.apache.activemq.apollo.openwire.command.RemoveSubscriptionInfo;
import org.apache.activemq.apollo.openwire.command.Response;
import org.apache.activemq.apollo.openwire.command.SessionId;
import org.apache.activemq.apollo.openwire.command.SessionInfo;
import org.apache.activemq.apollo.openwire.command.ShutdownInfo;
import org.apache.activemq.apollo.openwire.command.TransactionInfo;
import org.apache.activemq.apollo.openwire.command.WireFormatInfo;

public interface CommandVisitor {

    Response processAddConnection(ConnectionInfo info) throws Exception;

    Response processAddSession(SessionInfo info) throws Exception;

    Response processAddProducer(ProducerInfo info) throws Exception;

    Response processAddConsumer(ConsumerInfo info) throws Exception;

    Response processRemoveConnection(RemoveInfo info, ConnectionId id, long lastDeliveredSequenceId) throws Exception;

    Response processRemoveSession(RemoveInfo info, SessionId id, long lastDeliveredSequenceId) throws Exception;

    Response processRemoveProducer(RemoveInfo info,ProducerId id) throws Exception;

    Response processRemoveConsumer(RemoveInfo info,ConsumerId id, long lastDeliveredSequenceId) throws Exception;

    Response processAddDestination(DestinationInfo info) throws Exception;

    Response processRemoveDestination(DestinationInfo info) throws Exception;

    Response processRemoveSubscription(RemoveSubscriptionInfo info) throws Exception;

    Response processMessage(Message send) throws Exception;

    Response processMessageAck(MessageAck ack) throws Exception;

    Response processMessagePull(MessagePull pull) throws Exception;

    Response processBeginTransaction(TransactionInfo info) throws Exception;

    Response processPrepareTransaction(TransactionInfo info) throws Exception;

    Response processCommitTransactionOnePhase(TransactionInfo info) throws Exception;

    Response processCommitTransactionTwoPhase(TransactionInfo info) throws Exception;

    Response processRollbackTransaction(TransactionInfo info) throws Exception;

    Response processWireFormat(WireFormatInfo info) throws Exception;

    Response processKeepAlive(KeepAliveInfo info) throws Exception;

    Response processShutdown(ShutdownInfo info) throws Exception;

    Response processFlush(FlushCommand command) throws Exception;

    Response processBrokerInfo(BrokerInfo info) throws Exception;

    Response processRecoverTransactions(TransactionInfo info) throws Exception;

    Response processForgetTransaction(TransactionInfo info) throws Exception;

    Response processEndTransaction(TransactionInfo info) throws Exception;

    Response processMessageDispatchNotification(MessageDispatchNotification notification) throws Exception;

    Response processProducerAck(ProducerAck ack) throws Exception;

    Response processMessageDispatch(MessageDispatch dispatch) throws Exception;

    Response processControlCommand(ControlCommand command) throws Exception;

    Response processConnectionError(ConnectionError error) throws Exception;

    Response processConnectionControl(ConnectionControl control) throws Exception;

    Response processConsumerControl(ConsumerControl control) throws Exception;

}
