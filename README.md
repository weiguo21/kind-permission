#kind-permission
<div>
    <p>
        Spring+SpringMVC+MyBatis+Shiro+MySQL+Redis+Maven+EasyUI+Bootstrap实现的通用权限管理系统 ,参考了一些优秀的开源项目.
    </p>
</div>
<div>
    <h3>项目结构</h3>
    <ul>
        <li>kind-perm-commmon 项目基础架构,常用工具封装</li>
        <li>kind-perm-core    权限核心逻辑</li>
        <li>kind-perm-web     web页面相关</li>
        <li>kind-session      基于redis的分布式session实现</li>
    </ul>
</div>
<div>
    <h3>技术实现</h3>
    <ul>
        <li>使用spring</li>
        <li>持久化使用mybatis</li>
        <li>mvc控制使用springmvc</li>
        <li>页面框架使用easyui+bootstrap</li>
        <li>数据库mysql，连接池使用druid</li>
        <li>缓存redis，客户端使用jedis</li>
        <li>JSON工具fast-json</li>
    </ul>
</div>
<div>
    <h3>下载</h3>
    <ol>
        <li><p>oschina <a href="https://git.oschina.net/weiguo21/kind-permission.git">kind-permission</a></p></li>
        <li><p>github &nbsp;<a href="https://github.com/weiguo21/kind-permission.git">kind-permission</a></p></li>
    </ol>
</div>

<div>
    <h3>特点</h3>
    <ul>
        <li>主要是java核心类库的使用，以及jdk 1.8的一些新特性</li>
    </ul>
</div>

<div>
    <h3>环境依赖</h3>
    <ol>
        <li>安装jdk 1.7</li>
        <li>安装Maven3</li>
        <li>安装MySQL5.5以上版本</li>
        <li>安装Redis</li>
    </ol>
</div>

<div>
    <h3>部署说明</h3>
    <ol>
        <li>
            <p>初始化kind-perm-web项目db目录下sql脚本;
                说明：导入到数据库后，
                默认用户名admin,密码：admin123
            </p>
        </li>
        <li>双击kind-perm-web/bin/jetty-run.bat启动。</li>
    </ol>
</div>

<hr/>
<div>
    <h3>相关连接</h3>
    <ul>
        <li><a href="http://www.cnblogs.com/weiguo21">我的博客</a></li>
    </ul>
</div>

<hr/>
<div>
    <br/>
    From <a href="">www.kindapp.net</a>
    <br/>
    Email <a href="mailto:cary20@126.com">cary20@126.com</a>
</div>
