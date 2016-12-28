/**
 * Copyright (C) 2011-2016 The DriveCommand Authors <pile-dev@googlegroups.com>
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
 */
package com.pileproject.drivecommand.model.com;

import java.io.IOException;

/**
 * An interface class for communication between machines.
 */
public interface ICommunicator {
    /**
     * Opens a connection between machines.
     *
     * @throws IOException if failed to open a connection
     */
    void open() throws IOException;

    /**
     * Closes the connection between machines.
     */
    void close();

    /**
     * Writes the byte array data to a machine.
     *
     * @param data the array of a data to be passed
     * @throws RuntimeException if failed to write data
     */
    void write(byte[] data) throws RuntimeException;

    /**
     * Reads the response from a machine.
     *
     * @param length the max length of response to be read
     * @return the read results
     * @throws RuntimeException if failed to read data
     */
    byte[] read(int length) throws RuntimeException;
}
