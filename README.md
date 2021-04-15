# sup
工具类

# 访问路径
http://localhost:8080/swagger-ui.html
# 工具类
1、change-name 重新生成报文名 参数如下：
         {
           "path": "string" 
         } 
  path 报文路径 ,会在同级目录中生成 creditCode.NEW_FILE_NAME 文件夹。新的文件存放在这里面
  ps:注意Windows路径复制是这样：C:\Users\thinkpad\Desktop\test\个人基本信息
                       需改为 C:\\Users\\thinkpad\\Desktop\\est\\人基本信息
2、del  生成整笔删除报文 参数如下：
     {
       "orgCode": "string", // 机构码
       "path": "string",    // 报文路径
       "type": 0            // 生成的报文类型 110 210 220 等
     }
