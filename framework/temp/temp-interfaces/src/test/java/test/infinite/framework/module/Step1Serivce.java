package test.infinite.framework.module;

import com.infinite.framework.core.dto.AbstractEntity;
import com.infinite.framework.module.AbstractModule;

/**
 * Created by hx on 16-6-15.
 */
public class Step1Serivce extends AbstractModule {

    public AbstractEntity handler(AbstractEntity orienData, AbstractEntity flowData) {
        log.info("work by step1");
        return null;
    }
}
