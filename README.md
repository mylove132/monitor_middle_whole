#中间层自动化框架 <br>
* java <br>
    * dev <br>
        * --dev环境log配置 <br>
    * hotfix <br>
        * --hotfix环境log配置 <br>
    * online <br>
        * --online环境log配置 <br>
    * stress <br>
        * --stress环境log配置 <br>
    * okjiaoyu.qa <br>
        * base <br>
            * TestBase 测试基类 <br>
        * domain <br>
            * RequestSampler 请求的实体类 <br>
        * middle.auto <br>
            * main <br>
                * MainJUnit testNG主函数入口<br>
            * testcase 测试用例 <br>
        * persistance.controller  <br>
            * EntityEnvController 获取各个环境redis配置信息<br>
            * LinkProjectEnvController 获取各个环境的项目信息<br>
            * RequestHistoryController 请求信息数据入库<br>
            * TestHistoryController 测试历史数据入库<br>
        * tools 工具包 <br>
* resources     
    * config <br>
        * controller tesgNG用例管理 <br>
        * mybatis 配置文件<br>
        * spring spring配置文件 <br>
    * data 测试数据 <br>
    * profile 各个环境数据配置<br>
    * url 接口的URL配置<br>