/*
 * This file is part of JobsLite, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015 - 2017 Flibio
 * Copyright (c) Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package me.flibio.jobslite.data;

import static com.google.common.reflect.TypeToken.of;
import static org.spongepowered.api.data.DataQuery.of;
import static org.spongepowered.api.data.key.KeyFactory.makeSingleKey;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.mutable.Value;

public class LiteKeys {

    public static final Key<Value<String>> JOB_NAME = makeSingleKey(of(String.class), new TypeToken<Value<String>>() {

        private static final long serialVersionUID = -8644529579369003317L;
    }, of("JobName"), "jobslite:job_name", "JobName");
    public static final Key<Value<Integer>> LEVEL = makeSingleKey(of(Integer.class), new TypeToken<Value<Integer>>() {

        private static final long serialVersionUID = 7218880567997099120L;
    }, of("Level"), "jobslite:level", "Level");
    public static final Key<Value<Integer>> EXP = makeSingleKey(of(Integer.class), new TypeToken<Value<Integer>>() {

        private static final long serialVersionUID = -4497218535858457012L;
    }, of("Exp"), "jobslite:exp", "Exp");

}
