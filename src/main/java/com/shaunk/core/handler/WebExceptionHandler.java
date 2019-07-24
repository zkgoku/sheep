package com.shaunk.core.handler;

import com.shaunk.core.exception.*;
import com.shaunk.core.vo.E;
import com.shaunk.core.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Project sheep
 * @Package com.shaunk.core.handler
 * @Name WebExceptionHandler
 * @Version 1.0
 * @Data: 2019/6/28 4:45 PM
 * @User: shaunk
 * @Description: 统一异常处理
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public R userNotFound(HttpServletRequest request, HttpServletResponse response, UserNotFoundException e) {
        log.error(e.getMessage());
        return R.info(E.USER_NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseBody
    public R userPasswordError(HttpServletRequest request, HttpServletResponse response, UserPasswordErrorException e) {
        log.error(e.getMessage());
        return R.info(E.USER_PASSWORD_ERROR);
    }

    @ExceptionHandler
    @ResponseBody
    public R userIsLock(HttpServletRequest request, HttpServletResponse response, UserIsLockException e) {
        log.error(e.getMessage());
        return R.info(E.USER_IS_LOCK);
    }

    @ExceptionHandler
    @ResponseBody
    public R userIsLock(HttpServletRequest request, HttpServletResponse response, UserNotRoleException e) {
        log.error(e.getMessage());
        return R.info(E.USER_NOT_ROLE);
    }

    @ExceptionHandler
    @ResponseBody
    public R userAuthFail(HttpServletRequest request, HttpServletResponse response, UserAuthFailException e) {
        log.error(e.getMessage());
        return R.info(E.USER_AUTH_FAIL);
    }

    @ExceptionHandler
    @ResponseBody
    public R userAuthExpire(HttpServletRequest request, HttpServletResponse response, UserAuthExpireException e) {
        log.error(e.getMessage());
        return R.info(E.USER_AUTH_EXPIRE);
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public R requestParamsError(HttpServletRequest request, HttpServletResponse response, BindException e) {
        return R.fail(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler()
    @ResponseBody
    public R requestParamsError1(HttpServletRequest request, HttpServletResponse response, MissingServletRequestParameterException e) {
        log.error(e.getMessage());
        return R.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public R errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error(e.getMessage());
        log.error("err", e);
        return R.fail("系统异常，请联系管理员！");
    }

}
