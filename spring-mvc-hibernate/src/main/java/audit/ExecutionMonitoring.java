/**
 * 
 */
package audit;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Alain Narcisse SOBNGWI
 *
 */

@Aspect
public class ExecutionMonitoring {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExecutionMonitoring.class);
	
	@Around("execution(* *(..))")
	public Object mesure(ProceedingJoinPoint pjp) throws Throwable {
		//StopWatch sw = new StopWatch(getClass().getSimpleName()) ;
		long start = (new Date()).getTime() ;
		//sw.start(pjp.getSignature().getDeclaringTypeName());
		Object retVal = pjp.proceed() ;
		long  duration  = (new Date()).getTime() - start  ;
		LOGGER.info("[Duration] " +  pjp.getSignature().getDeclaringTypeName() +"."+ pjp.getSignature().getName() + "  took ****  [" + duration + "]  ****   ms" );
		// sw.stop();
		// LOGGER.info(sw.prettyPrint());
		return retVal ;
	}
	
}
