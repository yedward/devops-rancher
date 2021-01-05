import devops.Config
import devops.RancherApps
import devops.RancherCatalog
import devops.Utils

/**
 * 部署应用
 * @param params
 * @return
 */
def deployApp(Map params) {
    println("params参数：${params.toString()}")
    Map rancherApiInfo = params.get("rancher_api_info")
    Config.API_SERVER_URL = rancherApiInfo.get("API_SERVER_URL")
    Config.API_TOKEN = rancherApiInfo.get("API_TOKEN")
    println("解析后：${Config.API_SERVER_URL}, ${Config.API_TOKEN}")
//    def url = params["url"]
//    def namespace = params["namespace"]
//    RancherCatalog catalog = new RancherCatalog()
//    catalog.add("c-92nlp:p-jr7r6","testtestaaa","http://sdfsdf.github.com/sdfsd.git","master", "adminaa", "sdfsdfsdf")
//    println("deploy app from url:${url} to namespace:${namespace} success.")
}