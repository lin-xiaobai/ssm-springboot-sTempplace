这个案例是 HTTPMessageConverter 报文信息转换器，将请求报文转换为java对象 或将java对象转换为响应报文
HTTPMessageConverter提供了两个注解和两个类型：@RequestBody，@ResponseBody RequestEntity ResponseEntity
@RequestBody RequestEntity（响应体） 将请求报文数据转化为java数据
@RequestEntity ResponseEntity（常用）将java数据转换为响应信息

@RequestBody RequestEntity作用：可以获取前端传来的报文信息

 ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
 方法的返回值：ResponseEntity

 作用：可以实现上传和下载、自定义报文
 ResponseEntity类型：底层也就是一个流

在这个项目中含有一个ajax与json之间数据的交互
springmvc+jackson+ajax

@ResponseBody用于标识一个控制器方法，将该方法的返回值（string类型和json数据）直接作为报文的响应体响应到浏览器

//@RestController //复合注解 标识在控制器的类，相当于为类添加了
@Controller注解，并且为其中的每个方法都添加上了@ResponseBody注解


里面还有写js对象与json数据格式的关系
对象转为json
和json转为对象

js的key和value都是object类型
json对象的key要求是string类型，value是obejct类型

满足json格式（js的key是字符串类型）需要将对象转为json对象

如果json对象需要获取指定的属性值需要将json对象 转为js对象
就可以通过对象名.属性获取值





