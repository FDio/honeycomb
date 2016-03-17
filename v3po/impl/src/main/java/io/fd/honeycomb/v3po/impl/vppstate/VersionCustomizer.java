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

package io.fd.honeycomb.v3po.impl.vppstate;

import io.fd.honeycomb.v3po.impl.trans.impl.spi.ChildVppReaderCustomizer;
import io.fd.honeycomb.v3po.impl.trans.util.VppApiReaderCustomizer;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.v3po.rev150105.VppStateBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.v3po.rev150105.vpp.state.Version;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.v3po.rev150105.vpp.state.VersionBuilder;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.openvpp.vppjapi.vppVersion;

public final class VersionCustomizer
    extends VppApiReaderCustomizer
    implements ChildVppReaderCustomizer<Version, VersionBuilder> {

    public VersionCustomizer(final org.openvpp.vppjapi.vppApi vppApi) {
        super(vppApi);
    }

    @Override
    public void merge(final Builder<? extends DataObject> parentBuilder, final Version readValue) {
        ((VppStateBuilder) parentBuilder).setVersion(readValue);
    }

    @Override
    public VersionBuilder getBuilder() {
        return new VersionBuilder();
    }

    @Override
    public void readCurrentAttributes(final VersionBuilder builder) {
        final vppVersion vppVersion = getVppApi().getVppVersion();
        builder.setBranch(vppVersion.gitBranch);
        builder.setName(vppVersion.programName);
        builder.setBuildDate(vppVersion.buildDate);
        builder.setBuildDirectory(vppVersion.buildDirectory);
    }
}