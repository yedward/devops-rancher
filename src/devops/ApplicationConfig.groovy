package devops

/**
 * 全局静态变量
 */
class ApplicationConfig {
//    static String API_SERVER_URL = "https://rancher.yedward.net/v3"
//    static String API_TOKEN = "token-vntwr:8cshhnnjrm4pvn2pm2fjph6mbczdhz2pn2vq27d77fnq2hkvbxmgn6"

    // Rancher API相关的配置信息
    static Map RANCHER_SERVER_INFO = [
            "API_SERVER_URL":"", // Rancher的API Server地址
            "API_TOKEN":"" // Rancher中用户的API_TOKEN
    ]

    // Application发布应用相关的信息
    static Map APPLICATION_INFO = [
            "CLUSTER_PROJECT_ID":"", // 集群ID:项目ID
            "CLUSTER_ID":"", // 应用要发布到的集群的cluster_id
            "PROJECT_ID":"", // 应用要发布到的项目的project_id
            "NAMESPACE_NAME":"", // 应用要发布到的项目下的namespac_name
            "RELEASE_NAME":"", // 应用发布的release_name，对应helm部署时的release_name
            "CATALOG_NAME":"", // 应用商店名称，helm部署时从该repo中获取chart
            "CATALOG_GIT_URL":"", // 应用商店配置的托管charts的Git仓库地址
            "CATALOG_GIT_BRANCH":"", // 应用商店配置的托管charts的Git仓库的分支
            "CATALOG_GIT_USERNAME":"", // Git仓库的用户名
            "CATALOG_GIT_PASSWORD":"", // Git仓库的密码
            "CATALOG_APP_NAME": "", // 应用App Chart名称
            "CATALOG_APP_VERSION": "", // 应用App Chart Version名称
            "VALUES_YAML":"" // 部署的Values.Yaml的内容
    ]
}
