/*
 * (c) Copyright 2019 Palantir Technologies Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.metric.schema.grafana.api.panels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(as = ImmutableRowPanel.class)
@JsonSerialize(as = ImmutableRowPanel.class)
public interface RowPanel extends Panel {

    String TYPE = "row";

    @Override
    @Value.Default
    default String type() {
        return TYPE;
    }

    String title();

    List<Panel> panels();

    @Value.Default
    default boolean collapsed() {
        return false;
    }

    @Override
    @Value.Default
    default GridPosition gridPos() {
        return GridPosition.builder().height(1).width(GridPosition.MAX_WIDTH).build();
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableRowPanel.Builder {}
}