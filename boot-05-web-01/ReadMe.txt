2.1静态资源访问
1.静态资源目录
主要将静态资源目录放在类路径下：called/static(or/public or /resources or /META-INF/resources
访问：当前项目根路径/+静态资源  http://localhost:8080/s.png

原理“静态映射/**
请求进来，先去找controller能不能处理。不能处理的所有请求又都交给静态资源处理器。静态资源也找不到则响应404

（2）在application.yaml配置文件下修改默认的静态资源路径
http://localhost:8888/res/s.png  res是设置访问静态资源的前缀名

（3）修改默认的存放静态资源的文件夹，即其他的默认存在的位置会失效
  可以使用数组，各个路径之间使用，隔开   在application.yaml中设置
 访问路径：http://localhost:8888/res/mr.png:

（3）
会自动映射
使用webjars技术在工程中引入jQuery的jar包--> 在webjars官网找依赖
访问地址：http://localhost:8888/webjars/jquery/3.6.0/bower.json
后面要按照依赖里面的包路径


2.2欢迎页（首页）
访问路径：http://localhost:8888/
1.在将index.html存在在静态资源文件路径下，就会当成一个欢迎页(首页）
（1）可以配置静态资源路径
（2）但是不可以配置静态资源的访问路径，否则导致index.html不能被默认访问
2.在控制器中设置能处理 index请求
1和2会当成一个欢迎页显示出来

2.3、Favicon功能（小图标）
（1）直接将favicon.ico放在静态资源文件路径下就可以了



3.rest风格设置
 3.1.put和delete请求，需要在前端的表单中添加
 value中的值 可以为delete或者put请求，无论大小写，后端会自动转换为大写
 <input name="_method" type="hidden" value="请求方式"/>
 3.2.在controller层设置
 @RequestMapping(value = "/user",method = RequestMethod.GET/DETELE)
 3.3 在application.yanl配置文件中 开启页面表单的Rest功能
 spring:mvc:hiddenmethod:filter:enabled: true
 Rest原理（表单提交要使用REST的时候）
 ● 表单提交会带上_method=PUT
 ● 请求过来被HiddenHttpMethodFilter拦截
   ○ 请求是否正常，并且是POST
     ■ 获取到_method的值。
     ■ 兼容以下请求；PUT.DELETE.PATCH
     ■ 原生request（post），包装模式requesWrapper重写了getMethod方法，返回的是传入的值。
     ■ 过滤器链放行的时候用wrapper。以后的方法调用getMethod是调用requesWrapper的。

3.4 自定义HiddenHttpMethodFilter拦截器，将"_method"修改为"_m"  （自己喜欢的内容）
1.创建一个配置类，并且取消代理模式
即：在类上添加 @Configuration(proxyBeanMethods = false)
2.在配置类上,创建HiddenHttpMethodFilter方法，创建该对象，通过该对象的setMethodParam()方法修改值 并且将HiddenHttpMethodFilter对象 作为返回值返回

3.将该方法添加到IOC容器中，即在方法上添加 @Bean注解
4.在前端页面中修改 <input name="_m" type="hidden" value="delete"/>

