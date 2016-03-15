/*
 * Copyright (C) 2011-2015 PILE Project, Inc. <dev@pileproject.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.pileproject.drivecommand.model.com;

import java.io.IOException;

public interface ICommunicator {
    /**
     * Open the connection between devices.
     *
     * @throws IOException
     */
    void open() throws IOException;

    /**
     * Close the connection between devices.
     */
    void close();

    /**
     * Write the byte array data to the device.
     *
     * @param data
     * @throws RuntimeException
     */
    void write(byte[] data) throws RuntimeException;

    /**
     * Read the response from the device.
     *
     * @param length  The max length of response wanted to be read.
     * @return
     * @throws RuntimeException
     */
    byte[] read(int length) throws RuntimeException;
}
