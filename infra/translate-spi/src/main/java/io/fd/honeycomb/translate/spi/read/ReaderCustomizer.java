/*
 * Copyright (c) 2016 Cisco and/or its affiliates.
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

package io.fd.honeycomb.translate.spi.read;

import com.google.common.annotations.Beta;
import io.fd.honeycomb.translate.read.ReadContext;
import io.fd.honeycomb.translate.read.ReadFailedException;
import javax.annotation.Nonnull;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

/**
 * CompositeChildReader SPI to customize its behavior.
 *
 * @param <O> Specific DataObject derived type (Identifiable), that is handled by this customizer
 * @param <B> Specific Builder for handled type (C)
 */
@Beta
public interface ReaderCustomizer<O extends DataObject, B extends Builder<O>> {

    /**
     * Creates new builder that will be used to build read value.
     */
    @Nonnull
    B getBuilder(@Nonnull final InstanceIdentifier<O> id);

    /**
     * Adds current data (identified by id) to the provided builder.
     *
     * @param id      id of current data object
     * @param builder builder for creating read value
     * @param ctx     context for current read
     * @throws ReadFailedException if read was unsuccessful
     */
    void readCurrentAttributes(@Nonnull final InstanceIdentifier<O> id,
                               @Nonnull final B builder,
                               @Nonnull final ReadContext ctx) throws ReadFailedException;

    /**
     * Merge read data into provided parent builder.
     */
    void merge(@Nonnull final Builder<? extends DataObject> parentBuilder, @Nonnull final O readValue);


}
