package test.infinite.framework.module;

import com.infinite.framework.module.IModule;
import com.infinite.framework.module.flow.AbstractWorkFlow;

/**
 * Created by hx on 16-6-15.
 */
public class StepWorkFlowIngnoreException extends AbstractWorkFlow {

    public Class<? extends IModule>[] getModules() {
        return new Class[]{
                Step1Serivce.class,
                Step2Serivce.class,
                Step3Serivce.class,
        };
    }

    @Override
    public Tactics getTactics() {
        return Tactics.IGNORE_EXCEPTION;
    }
}
