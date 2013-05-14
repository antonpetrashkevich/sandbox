package foo.bar.aop.aspect;


import foo.bar.aop.model.Shape;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * User: Anton
 * Date: 14.05.13
 * Time: 13:49
 */

@Aspect
public class LoggingAspect {

    /*@After(value = "target(foo.bar.aop.model.Circle)")
    private void methodCalled() {
        System.out.println("A mehtod was called!!");
    }*/

  /*@After(value = "this(foo.bar.aop.model.Shape)")
    private void voidReturningMethodCalled(){
        System.out.println("A void method was called!!");
    }*/

    @After(value = "@annotation(foo.bar.aop.aspect.Loggable)")
    private void loggingAnnotatedMethods() {
        System.out.println("A method annotated with @Loggable was invoked");
    }

 /*   @Around(value = "args(foo.bar.aop.model.Shape)")
    private void shapeArgsMethods(ProceedingJoinPoint jointPoint){
        System.out.println("A method having Shape parameter was invoked");
        try {
            jointPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/


    @Pointcut(value = "args(foo.bar.aop.model.Shape)")
    private void shapeArgsMethods() {
    }

    @AfterReturning(pointcut = "shapeArgsMethods()", returning = "shape")
    private void printShapeArgument(Shape shape) {
        System.out.println(shape);
    }


}
