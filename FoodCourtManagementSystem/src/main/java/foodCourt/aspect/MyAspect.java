package foodCourt.aspect;

import foodCourt.domain.User;
import foodCourt.repository.UserRepository;
import foodCourt.service.AdminService;
import foodCourt.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class MyAspect {

    private Logger logger = Logger.getLogger(MyAspect.class.getName());

    private UserService userService;

    public MyAspect(UserService userService) {
        this.userService = userService;
    }

    @Before("execution(* *(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {

        long accessTime = System.currentTimeMillis();


        String userId = getUserId();


        String methodName = joinPoint.getSignature().getName();


        Object[] args = joinPoint.getArgs();
        String parameterList = Arrays.toString(args);


        String logEntry = "----------------------------------------------------------[" + accessTime + "][" + userId + "]-[" + methodName + " " + parameterList + "]";
        //logger.info(logEntry);
        logger.log(Level.SEVERE, "In Aspect");
        logger.log(Level.SEVERE, logEntry);
    }

    private String getUserId() {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get((String) loggedInUser);
        return String.valueOf(user.getId());
    }
}

