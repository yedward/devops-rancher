import devops.Application

/**
 * 部署应用
 *
 * @param params
 * @return
 */
def deployApp(Map params) {
    println("params传入参数：${params.toString()}")
    Application application = new Application()
    application.deploy(params)
}