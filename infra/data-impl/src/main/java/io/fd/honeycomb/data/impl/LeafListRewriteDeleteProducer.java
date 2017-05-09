/*
 * Copyright (c) 2017 Cisco and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fd.honeycomb.data.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nonnull;
import org.opendaylight.yangtools.yang.data.api.YangInstanceIdentifier;
import org.opendaylight.yangtools.yang.data.api.schema.DataContainerChild;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LeafListRewriteDeleteProducer implements RewriteDeleteProducer{

    private static final Logger LOG = LoggerFactory.getLogger(LeafListRewriteDeleteProducer.class);

    @Override
    public Collection<NormalizedNodeUpdate> normalizedUpdates(@Nonnull final YangInstanceIdentifier topLevelIdentifier,
                                                              @Nonnull final Map.Entry<YangInstanceIdentifier.PathArgument, DataContainerChild<? extends YangInstanceIdentifier.PathArgument, ?>> entry) {
        // if leaf-list,just builds delete right away
        LOG.debug("Processing {} as leaf-list", topLevelIdentifier);
        return Collections.singletonList(new NormalizedNodeUpdate(YangInstanceIdentifier.builder(topLevelIdentifier)
                .node(entry.getKey()).build(), entry.getValue(), null));
    }
}
