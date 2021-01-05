package devops

import javax.security.auth.login.AppConfigurationEntry

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
    httpRequest customHeaders: [[maskValue: true, name: 'Authorization', value: "Bearer ${ApplicationConfig.RANCHER_SERVER_INFO.API_TOKEN}"],
                                [maskValue: false, name: 'Content-Type', value: 'application/json'],
                                [maskValue: false, name: 'Accept', value: 'application/json']],
            httpMode: "${httpMode}",
            consoleLogResponseBody: true,
            ignoreSslErrors: true,
            requestBody: "${requestBody}",
            url: "${ApplicationConfig.RANCHER_SERVER_INFO.API_SERVER_URL}/${httpUrl}"
}

/**
 * 从params中解析配置项，以初始化全局参数配置
 *
 * @param params
 */
def initParseParams(Map params) {
    Map rancherApiInfo = params.get("rancher_api_info")
    ApplicationConfig.RANCHER_SERVER_INFO.API_SERVER_URL = rancherApiInfo.get("API_SERVER_URL")
    ApplicationConfig.RANCHER_SERVER_INFO.API_TOKEN = rancherApiInfo.get("API_TOKEN")
}

/**
 * 部署发布应用
 */
def deploy(Map params) {
    // 第一步，初始化发布配置
    initParseParams(params)
    // 第二步，添加chart地址到应用仓库中
    RancherCatalog rancherCatalog = new RancherCatalog()
    rancherCatalog.add(
            ApplicationConfig.APPLICATION_INFO.PROJECT_ID,
            ApplicationConfig.APPLICATION_INFO.CATALOG_NAME,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_URL,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_BRANCH,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_USERNAME,
            ApplicationConfig.APPLICATION_INFO.CATALOG_GIT_PASSWORD
    )
    // 第三步，刷新应用仓库，以便获取最新的chart
    rancherCatalog.refresh()
    // 第四步，发布或者更新应用
    RancherApps rancherApps = new RancherApps()
    rancherApps.install()
}