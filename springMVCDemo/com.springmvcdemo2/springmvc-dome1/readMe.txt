1.拦截器和配置拦截器
SpringMVC中的拦截器用于拦截控制器方法的执行
SpringMVC中的拦截器需要实现HandlerInterceptor接口

多个拦截器拦截的顺序
preHandle()会按照配置的顺序执行，而postHandle()和afterComplation()会按照配置的反序执行

1.preHandle方法是通过  ref的顺序执行的
2.postHandle方法和afterCompletion方法是通过 ref的倒序执行的
        <ref bean="firstInterceptor"></ref>
        <ref  bean="secondInterceptor"></ref>
控制台输出：
第一个拦截器中的preHandle方法执行
第二个拦截器中的preHandle方法执行
第二个拦截器中的postHandle方法执行
第一个拦截器中的postHandle方法执行
第二个拦截器中的afterCompletion方法执行
第一个拦截器中的afterCompletion方法执行

b>若某个拦截器的preHandle()返回了false
preHandle()返回false和它之前的拦截器的preHandle()都会执行，postHandle()都不执行，返回false
的拦截器之前的拦截器的afterComplation()会执行



异常处理器
基于配置的异常处理
（是一个解析器）
SpringMVC提供了一个处理控制器方法执行过程中所出现的异常的接口：HandlerExceptionResolver
HandlerExceptionResolver接口的实现类有：DefaultHandlerExceptionResolver（系统定义的）和
SimpleMappingExceptionResolver（可以自定义，如果控制器中出现异常，可以重新定义返回一个modelAndView）

基于注解的自定义异常信息处理