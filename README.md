# URL说明
项目所有URL采用RESTful写法  
默认端口号：**7070**  
在本地启动springboot jar包，访问格式如下：
~~~ 
http://localhost:7070/请求链接
~~~
所有请求将会返回一个JSON对象，如下：
```json lines
{
    "flag": "false", /*响应的结果*/
    "result": {},/*响应的数据，可能是数组或者对象，一般只在查询时会返回内容，其他情况下为null*/
    "msg": "default" /*返回的提示消息，可以直接在前端用*/
}
```
以下详细请求按照如下格式描述：
~~~
请求方式
请求路径
~~~
## GoodsController 商品相关
~~~
GET
/goods/
~~~
查看所有商品  
result会返回一个数组
~~~
GET
/goods/type/{id}
~~~
按照商品的分类查看商品  
result : 返回一个对象数组  
{id} : 分类id
~~~
GET
/goods/{id}
~~~
按照商品id查看商品  
result : 会返回一个对象  
{id} : 商品id
## UserController 用户相关
~~~
POST
/users/register
~~~
用户注册  
需要传入一个user对象（邮箱、昵称、密码）
~~~
POST
/users/login
~~~
用户登录  
需要传入一个user对象（邮箱、密码）
## RecommendController 推荐相关
~~~
PUT
/recommends/
~~~
添加推荐信息  
需要传入一个recommend对象
~~~
DELETE
/recommends/{type}/{goodsId}
~~~
删除一条推荐信息
{type} : 推荐类型  
{goodsId} : 商品id
~~~
GET
/recommends/{type}
~~~
按照推荐类型查询商品  
{type} : 推荐类型ID  
result : 返回一个商品的数组对象  
## ShopCarController 购物车相关
~~~
GET
/shopcars/goods/{userId}
~~~
查看当前用户购物车中商品的信息  
{userId} : 用户id  
result : 商品的对象数组  
~~~
GET
/shopcars/{userId}

~~~
查看购物车信息  
{userId} : 用户id  
result : 购物车对象数组  
~~~
PUT
/shopcars/{userId}/{goodsId}
~~~
添加购物车条目  
{userId} : 用户id  
{goodsId} : 商品id  
~~~
GET
/shopcars/{shopCarId}/{amount}
~~~
修改购物车中已有商品的数量  
{shopCarId} : 购物车条目id  
{mount} : 要修改的数量，可以为负  
~~~
DELETE
/shopcars/{shopCarId}
~~~
删除购物车中的一条记录  
{shopCarId} : 购物车条目id  
~~~
DELETE
/shopcars/clear/{userId}
~~~
清空用户的购物车  
{userId} : 用户id  
## TypeController 商品相关（分类）
~~~
GET
/types/
~~~
查看分类名和数字id的对照表  
result : 分类的对象数组  
~~~
GET
/types/{id}
~~~
按照id返回分类名  
{id} : 用户id  
result : 分类名  
## OrderController 订单相关
~~~
GET
/orders/{userId}
~~~
查看用户的所有订单  
{userId} : 用户id  
result : 订单对象数组  
~~~
GET
/orders/create/{userId}
~~~
把购物车中的所有商品创建为订单  
{userId} : 用户id  
~~~
GET
/orders/status/{orderId}/{status}
~~~
修改订单的发货状态  
{orderId} : 订单id  
{status} : 发货状态 1未发货 2已发货 3已签收
~~~
GET
/orders/status/{orderId}/{paytype}
~~~
修改订单的发货状态  
{orderId} : 订单id  
{paytype} : 支付状态 1待付款 2已付款