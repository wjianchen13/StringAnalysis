# 字符串相关操作
字符串相关检测操作，实现主播发言过滤  

# 遇到问题
1.编译报错：  
  java.lang.RuntimeException: java.lang.RuntimeException: Duplicate class com.google.common.util.concurrent.ListenableFuture  
   found in modules jetified-guava-23.6-android.jar (com.google.guava:guava:23.6-android) and jetified-listenablefuture-1.0.jar (com.google.guava:listenablefuture:1.0)  
在app的build.gradle添加   
```Java
configurations {
    all*.exclude group: 'com.google.guava', module: 'listenablefuture'
}   
```