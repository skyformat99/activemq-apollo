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
package org.apache.activemq.apollo.stomp.dto;

import org.apache.activemq.apollo.dto.AddUserHeaderDTO;
import org.apache.activemq.apollo.dto.ProtocolDTO;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Allow you to customize the stomp protocol implementation.
 *
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
@XmlRootElement(name="stomp")
@XmlAccessorType(XmlAccessType.FIELD)
public class StompDTO extends ProtocolDTO {

    @XmlAttribute(name="add_user_header")
    public String add_user_header;

    /**
     * A broker accepts connections via it's configured connectors.
     */
    @XmlElement(name="add_user_header")
    public List<AddUserHeaderDTO> add_user_headers = new ArrayList<AddUserHeaderDTO>();

    @XmlAttribute(name="max_header_length")
    public Integer max_header_length;

    @XmlAttribute(name="max_headers")
    public Integer max_headers;

    @XmlAttribute(name="max_data_length")
    public Integer max_data_length;

    /**
     * A broker accepts connections via it's configured connectors.
     */
    @XmlElement(name="protocol_filter")
    public List<String> protocol_filters = new ArrayList<String>();

    @XmlAttribute(name="queue_prefix")
    public String queue_prefix;

    @XmlAttribute(name="topic_prefix")
    public String topic_prefix;

    @XmlAttribute(name="destination_separator")
    public String destination_separator;

    @XmlAttribute(name="path_separator")
    public String path_separator;

    @XmlAttribute(name="any_child_wildcard")
    public String any_child_wildcard;

    @XmlAttribute(name="any_descendant_wildcard")
    public String any_descendant_wildcard;

}
