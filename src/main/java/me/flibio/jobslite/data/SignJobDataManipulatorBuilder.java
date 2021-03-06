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

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;

import java.util.Optional;

public class SignJobDataManipulatorBuilder implements DataManipulatorBuilder<SignJobData, ImmutableSignJobData> {

    private String jobName;

    @Override
    public Optional<SignJobData> build(DataView container) throws InvalidDataException {
        if (container.contains(LiteKeys.JOB_NAME.getQuery())) {
            final String jobName = container.getString(LiteKeys.JOB_NAME.getQuery()).get();
            return Optional.of(new SignJobData(jobName));
        }
        return Optional.empty();
    }

    public SignJobDataManipulatorBuilder setSignInfo(String jobName) {
        this.jobName = jobName;
        return this;
    }

    @Override
    public SignJobData create() {
        if (jobName == null) {
            jobName = "";
        }
        return new SignJobData(jobName);
    }

    @Override
    public Optional<SignJobData> createFrom(DataHolder dataHolder) {
        return Optional.of(dataHolder.get(SignJobData.class).orElse(new SignJobData("")));
    }

}
