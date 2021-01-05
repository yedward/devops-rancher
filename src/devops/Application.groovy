package devops
/**
 * 通用HTTP请求工具
 *
 * @param apiServerUrl
 * @param apiToken
 * @param httpMode
 * @param requestBody
 * @return
 */
def handleRequest(String httpMode, String httpUrl, String requestBody) {
    def response = httpRequest customHeaders: [[maskValue: false, name: 'Authorization', value: "Bearer ${ApplicationConfig.RANCHER_SERVER_INFO.API_TOKEN}"],
                                [maskValue: false, name: 'Content-Type', value: 'application/json'],
                                [maskValue: false, name: 'Accept', value: 'application/json']],
            httpMode: "${httpMode}",
            consoleLogResponseBody: true,
            ignoreSslErrors: true,
            validResponseCodes: "100:599",
            quiet: false,
            responseHandle: "STRING",
            requestBody: "${requestBody}",
            url: "${ApplicationConfig.RANCHER_SERVER_INFO.API_SERVER_URL}/${httpUrl}"
    println("reponse::" + response)
    return response
}

/**
 * 从params中解析配置项，以初始化全局参数配置
 *
 * @param params
 */
def initParseParams(Map params) {
    // 解析Rancher相关配置
    ApplicationConfig.RANCHER_SERVER_INFO.API_SERVER_URL = params.get("RANCHER_API_URL")
    ApplicationConfig.RANCHER_SERVER_INFO.API_TOKEN = params.get("RANCHER_API_TOKEN")

    // 解析应用相关配置
    Map applicationInfo = params.get("APPLICATION_INFO")
    String[] strArray = applicationInfo.get("PROJECT_ID").split(":")
    ApplicationConfig.APPLICATION_INFO.CLUSTER_ID = strArray[0]
    ApplicationConfig.APPLICATION_INFO.PROJECT_ID = strArray[1]
    ApplicationConfig.APPLICATION_INFO.CLUSTER_PROJECT_ID = applicationInfo.get("PROJECT_ID")
    ApplicationConfig.APPLICATION_INFO.RELEASE_NAME = applicationInfo.get("RELEASE_NAME")
    ApplicationConfig.APPLICATION_INFO.NAMESPACE_NAME = applicationInfo.get("NAMESPACE_NAME")

    ApplicationConfig.APPLICATION_INFO.CATALOG_NAME = applicationInfo.get("CATALOG_NAME")
    ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_URL = applicationInfo.get("CATALOG_GIT_URL")
    ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_BRANCH = applicationInfo.get("CATALOG_GIT_BRANCH")
    ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_USERNAME = applicationInfo.get("CATALOG_GIT_USERNAME")
    ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_PASSWORD = applicationInfo.get("CATALOG_GIT_PASSWORD")
}

/**
 * 部署发布应用
 *
 * @param params
 * @return
 */
def deploy(Map params) {
    // 第一步，初始化发布配置
    initParseParams(params)

    RancherCatalog rancherCatalog = new RancherCatalog()
    def resp
    String status
    // 第二步，如果还没有添加，则添加chart地址到应用仓库中
    resp = rancherCatalog.add(
            ApplicationConfig.APPLICATION_INFO.CLUSTER_PROJECT_ID,
            ApplicationConfig.APPLICATION_INFO.CATALOG_NAME,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_URL,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_BRANCH,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_USERNAME,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_PASSWORD
    )
    status = resp.status
    if (status.equals("409")) {
        println("chart已经存在于应用商店中，无需再次添加")
    }
    // 第三步，刷新应用仓库，以便获取最新的chart
    rancherCatalog.refresh()
    // 第四步，发布或者更新应用
    RancherApps rancherApps = new RancherApps()
    rancherApps.install()
}