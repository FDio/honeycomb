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

package io.fd.honeycomb.translate.v3po.interfaces.acl;

import static org.junit.Assert.assertArrayEquals;

final class AceIpWriterTestUtils {

    private AceIpWriterTestUtils() {
        throw new UnsupportedOperationException("This utility class cannot be instantiated");
    }

    protected static void assertArrayEqualsWithOffset(final byte[] baseExpected, final byte[] actual,
                                                      final int offset) {
        byte[] expected = new byte[baseExpected.length];
        System.arraycopy(baseExpected, 0, expected, offset, expected.length - offset);

        assertArrayEquals(expected, actual);
    }
}
