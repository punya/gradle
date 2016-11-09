/*
 * Copyright 2016 the original author or authors.
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

package org.gradle.internal.operations;

import org.gradle.internal.concurrent.StoppableExecutor;

public class DefaultBuildOperationQueueFactory implements BuildOperationQueueFactory {
    private final BuildOperationWorkerRegistry buildOperationWorkerRegistry;

    public DefaultBuildOperationQueueFactory(BuildOperationWorkerRegistry buildOperationWorkerRegistry) {
        this.buildOperationWorkerRegistry = buildOperationWorkerRegistry;
    }

    @Override
    public <T extends BuildOperation> BuildOperationQueue<T> create(StoppableExecutor executor, BuildOperationWorker<T> worker) {
        return new DefaultBuildOperationQueue<T>(buildOperationWorkerRegistry, executor, worker);
    }
}
