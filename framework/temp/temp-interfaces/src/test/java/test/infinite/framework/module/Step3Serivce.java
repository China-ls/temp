package test.infinite.framework.module;

import com.infinite.framework.core.entity.AbstractEntity;
import com.infinite.framework.module.AbstractModule;

/**
 * Created by hx on 16-6-15.
 */
public class Step3Serivce extends AbstractModule {

    public AbstractEntity handler(AbstractEntity orienData, AbstractEntity flowData) {
        log.info("work by step3");
        return null;
    }
}
