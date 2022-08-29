# Dagger2
###  Dagger可以理解为快递流程  类对象：物品. Module:包装（@Module、@Provides、@Singleton ）。 
#### Component为快递员（@Component 并需要 inject绑定Activity用户）
#### Activity 为用户（@Inject 取对应的对象）

### 单例模式添加
#### 需要在Module 和 Component 对应的类里面添加
#### 同Activity 里面单例 hashcode 值是一样的，不同的Activity 即使设置了@Singleton 也不同    
### 通过测试在Module 里面注入@Singleton  对象是局部单例

### 获取的依赖注入对象全局单例

### scope  范围作用域，可以实现局部单例
#### 先自定义一个作用域
    
```aidl
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {

}
```
#### 然后在 Module 方法上和 Component类上加上自定义 @ActivityScope，就可以实现局部单例
