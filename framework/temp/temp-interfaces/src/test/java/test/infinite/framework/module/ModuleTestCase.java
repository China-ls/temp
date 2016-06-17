package test.infinite.framework.module;

import com.infinite.framework.core.entity.AbstractEntity;
import org.junit.Test;

/**
 * Created by hx on 16-6-15.
 */
public class ModuleTestCase {

    @Test
    public void testWorkflowAllSuccess() {
        StepWorkFlowAllSuccess stepWorkFlow = new StepWorkFlowAllSuccess();
        AbstractEntity result = stepWorkFlow.handler(null, null);
        System.out.println( result );
    }

    @Test
    public void testWorkflowIgnoreException() {
        StepWorkFlowIngnoreException stepWorkFlow = new StepWorkFlowIngnoreException();
        AbstractEntity result = stepWorkFlow.handler(null, null);
        System.out.println( result );
    }

}
