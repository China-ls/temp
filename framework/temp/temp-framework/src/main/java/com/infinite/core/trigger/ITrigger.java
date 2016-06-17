package com.infinite.core.trigger;

import com.infinite.core.annotations.Trigger;
import com.infinite.core.entity.trigger.TriggerOptions;

@Trigger
public interface ITrigger {

    public TriggerOptions getOptions();

}
