package devops

/**
 * 从应用商店部署应用
 *
 * 示例：
 *  url: https://rancher_api_url/v3/projects/your_cluster_project_id/app
 *  method:POST
 *  request payload：
 *  {
 *  "prune": false,
 *  "timeout": 300,
 *  "wait": false,
 *  "type": "app",
 *  "name": "your_release_name",
 *  "answers": {},
 *  "targetNamespace": "your_namespace",
 *  "externalId": "catalog://?catalog=your_project_id/your_catalog_name&type=projectCatalog&template=your_release_app_name&version=your_release_app_version",
 *  "projectId": "your_cluster_project_id",
 *  "valuesYaml": "your_release_values_yaml"
 *  }
 */
def install(String clusterProjectId, String projectId, String releaseName, String namespaceName, String catalogName, String releaseAppName, String releaseAppVersion, String releaseValuesYaml) {
    println("---------------【从应用商店部署应用】开始--------------")
    Application application = new Application()
    String requestBody = """
     {
     "prune": false,
     "timeout": 300,
     "wait": false,
     "type": "app",
     "name": "${releaseName}",
     "answers": {},
     "targetNamespace": "${namespaceName}",
     "externalId": "catalog://?catalog=${projectId}/${catalogName}&type=projectCatalog&template=${releaseAppName}&version=${releaseAppVersion}",
     "projectId": "${clusterProjectId}",
     "valuesYaml": "${releaseValuesYaml}"
     }
"""
    print("${requestBody}")
    def response = application.handleRequest("POST","/projects/${clusterProjectId}/app", "${requestBody}")
    println("---------------【从应用商店部署应用】结束--------------")
    return response
}

/**
 * 从应用商店中升级已部署的应用
 *
 * 示例：
 *  url: https://rancher_api_url/v3/project/your_cluster_project_id/apps/your_project_id:your_release_name?action=upgrade
 *  method:POST
 *  request payload：
 *  {
 *  "externalId": "catalog://?catalog=your_project_id/your_catalog_name&type=projectCatalog&template=your_release_app_name&version=your_release_app_version",
 *  "answers": {},
 *  "valuesYaml": "your_release_values_yaml",
 *  "forceUpgrade": false
 *  }
 */
def upgrade(String clusterProjectId, String projectId, String releaseName, String catalogName, String releaseAppName, String releaseAppVersion, String releaseValuesYaml) {
    println("---------------【从应用商店中升级已部署的应用】开始--------------")
    Application application = new Application()
    String requestBody = """
    {
    "externalId": "catalog://?catalog=${projectId}/${catalogName}&type=projectCatalog&template=${releaseAppName}&version=${releaseAppVersion}",
    "answers": {},
    "valuesYaml": "${releaseValuesYaml}",
    "forceUpgrade": false
    }
"""
    print("${requestBody}")
    def response = application.handleRequest("POST","/project/${clusterProjectId}/apps/${projectId}:${releaseName}?action=upgrade", "${requestBody}")
    println("---------------【从应用商店中升级已部署的应用】结束--------------")
    return response
}