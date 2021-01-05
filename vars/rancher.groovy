import devops.Application

/**
 * 部署应用
 *
 * @param params
 * @return
 */
def deployApp(Map params) {
    println("params参数：${params.toString()}")
    Application application = new Application()
    application.deploy(params)
//    def url = params["url"]
//    def namespace = params["namespace"]
//    RancherCatalog catalog = new RancherCatalog()
//    catalog.add("c-92nlp:p-jr7r6","testtestaaa","http://sdfsdf.github.com/sdfsd.git","master", "adminaa", "sdfsdfsdf")
//    println("deploy app from url:${url} to namespace:${namespace} success.")
}