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

package com.pileproject.drivecommand.util;

public class Log {
    public static void e(String tag, String msg) {
        System.err.println(String.format("%s: %s", tag, msg));
    }

    public static void e(String tag, String msg, Throwable e) {
        System.err.println(String.format("%s: %s", tag, msg));
        System.err.println(e.toString());
    }

    public static void d(String tag, String msg) {
        System.err.println(String.format("%s: %s", tag, msg));
    }
}
