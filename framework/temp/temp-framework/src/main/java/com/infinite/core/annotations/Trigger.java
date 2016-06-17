package com.infinite.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/***
 *
 */
@Component
@Target(ElementType.TYPE)
public @interface Trigger {
    String name() default "";

    Class configClass() default void.class;
}
